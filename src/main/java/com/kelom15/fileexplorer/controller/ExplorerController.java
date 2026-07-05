package com.kelom15.fileexplorer.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kelom15.fileexplorer.datastructure.tree.DirectoryNode;
import com.kelom15.fileexplorer.datastructure.tree.DirectoryTree;
import com.kelom15.fileexplorer.dto.DirectoryResponse;
import com.kelom15.fileexplorer.service.ExplorerService;

@RestController
public class ExplorerController {

    private final ExplorerService explorerService;

    public ExplorerController(ExplorerService explorerService) {
        this.explorerService = explorerService;
    }

    @GetMapping("/api/tree")
    public DirectoryNode buildTree(
            @RequestParam String path)
            throws Exception {

        DirectoryTree tree = explorerService.buildTree(path);

        return tree.getRoot();

    }

    @GetMapping("/api/drives")
    public List<String> getDrives() {

        return explorerService.getDrives();

    }

    @GetMapping("/api/folder")
    public List<DirectoryResponse> getFolder(
            @RequestParam String path,
            @RequestParam(defaultValue = "name") String sort)
            throws Exception {

        return explorerService.getFolderContent(path, sort);

    }

    @GetMapping("/api/search")
    public List<DirectoryResponse> search(
            @RequestParam String path,
            @RequestParam String keyword)
            throws IOException {

        return explorerService.search(path, keyword);

    }

}
