package com.kelom15.fileexplorer.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kelom15.fileexplorer.datastructure.queue.BFSQueue;
import com.kelom15.fileexplorer.datastructure.sorting.QuickSort;
import com.kelom15.fileexplorer.datastructure.tree.DirectoryNode;
import com.kelom15.fileexplorer.datastructure.tree.DirectoryTree;
import com.kelom15.fileexplorer.dto.DirectoryResponse;

@Service
public class ExplorerService {

    /**
     * ============================== TREE (UNTUK IMPLEMENTASI UAS)
     * ==============================
     */
    public DirectoryTree buildTree(String rootPath) throws IOException {

        Path path = Paths.get(rootPath);

        if (!Files.exists(path)) {
            throw new IllegalArgumentException("Path tidak ditemukan.");
        }

        DirectoryNode root = createNode(path);

        DirectoryTree tree = new DirectoryTree(root);

        buildChildren(root, path);

        return tree;

    }

    /**
     * Recursive membangun seluruh child.
     */
    private void buildChildren(DirectoryNode parentNode, Path parentPath)
            throws IOException {

        if (!Files.isDirectory(parentPath)) {
            return;
        }

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(parentPath)) {

            for (Path child : stream) {

                try {

                    DirectoryNode childNode = createNode(child);

                    parentNode.addChild(childNode);

                    if (Files.isDirectory(child)) {

                        buildChildren(childNode, child);

                    }

                } catch (Exception e) {

                    // Skip file/folder yang tidak bisa dibaca
                    System.out.println("Skip Tree : " + child);

                }

            }

        }

    }

    /**
     * Mengubah Path menjadi DirectoryNode.
     */
    private DirectoryNode createNode(Path path)
            throws IOException {

        BasicFileAttributes attr = Files.readAttributes(path,
                BasicFileAttributes.class);

        return new DirectoryNode(
                path.getFileName() == null
                ? path.toString()
                : path.getFileName().toString(),
                path.toAbsolutePath().toString(),
                attr.isDirectory(),
                attr.size(),
                LocalDateTime.ofInstant(
                        attr.lastModifiedTime().toInstant(),
                        ZoneId.systemDefault()));

    }

    /**
     * ============================== API FRONTEND
     * ==============================
     */
    /**
     * Mengambil seluruh drive komputer.
     */
    public List<String> getDrives() {

        List<String> drives = new ArrayList<>();

        File[] roots = File.listRoots();

        if (roots != null) {

            for (File root : roots) {

                drives.add(root.getAbsolutePath());

            }

        }

        return drives;

    }

    /**
     * Mengambil isi folder untuk React.
     */
    public List<DirectoryResponse> getFolderContent(
            String folderPath,
            String sort)
            throws IOException {

        List<DirectoryResponse> response = new ArrayList<>();

        Path path = Paths.get(folderPath);

        if (!Files.exists(path)) {

            return response;

        }

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {

            for (Path child : stream) {

                try {

                    BasicFileAttributes attr = Files.readAttributes(
                            child,
                            BasicFileAttributes.class);

                    DirectoryResponse dto = new DirectoryResponse();

                    dto.setName(child.getFileName().toString());

                    dto.setPath(child.toAbsolutePath().toString());

                    dto.setDirectory(Files.isDirectory(child));

                    System.out.println(
                            child.getFileName()
                            + " -> "
                            + Files.isDirectory(child));

                    dto.setSize(attr.size());

                    dto.setLastModified(
                            attr.lastModifiedTime().toString());

                    response.add(dto);

                } catch (Exception e) {

                    // Skip file/folder yang tidak bisa dibaca
                    System.out.println("Skip Folder : " + child);

                }

            }

        }

        switch (sort) {

            case "name-desc":
                QuickSort.sortByNameDesc(response);
                break;

            case "size":
                QuickSort.sortBySize(response);
                break;

            case "date":
                QuickSort.sortByDate(response);
                break;

            case "folder":
                QuickSort.sortFolderFirst(response);
                break;

            default:
                QuickSort.sortByName(response);
        }

        return response;

    }

    public List<DirectoryResponse> search(String rootPath, String keyword)
            throws IOException {

        System.out.println("===== SEARCH =====");
        System.out.println("Path : " + rootPath);
        System.out.println("Keyword : " + keyword);

        List<DirectoryResponse> result = new ArrayList<>();

        if (rootPath == null || rootPath.isBlank()) {

            System.out.println("GLOBAL SEARCH");

            File[] drives = File.listRoots();

            if (drives != null) {

                for (File drive : drives) {

                    System.out.println("Drive : " + drive);

                    bfsSearch(drive.toPath(), keyword, result);

                }

            }

        } else {

            System.out.println("LOCAL SEARCH");

            bfsSearch(Paths.get(rootPath), keyword, result);

        }

        System.out.println("Result = " + result.size());

        return result;
    }

    private void bfsSearch(
            Path root,
            String keyword,
            List<DirectoryResponse> result)
            throws IOException {

        BFSQueue<Path> queue = new BFSQueue<>();

        queue.enqueue(root);

        while (!queue.isEmpty()) {

            Path current = queue.dequeue();

            try {

                if (!Files.exists(current)) {
                    continue;
                }

                BasicFileAttributes attr = Files.readAttributes(current,
                        BasicFileAttributes.class);

                String name = current.getFileName() == null
                        ? current.toString()
                        : current.getFileName().toString();

                if (name.toLowerCase()
                        .contains(keyword.toLowerCase())) {
                    System.out.println("FOUND : " + current);

                    DirectoryResponse dto = new DirectoryResponse();

                    dto.setName(name);
                    dto.setPath(current.toAbsolutePath().toString());
                    dto.setDirectory(attr.isDirectory());
                    dto.setSize(attr.size());
                    dto.setLastModified(
                            attr.lastModifiedTime().toString());

                    result.add(dto);

                }

                if (attr.isDirectory()) {

                    try (DirectoryStream<Path> stream = Files.newDirectoryStream(current)) {

                        for (Path child : stream) {

                            queue.enqueue(child);

                        }

                    }

                }

            } catch (Exception e) {

                // Skip folder yang tidak memiliki izin akses
            }

        }

    }
}
