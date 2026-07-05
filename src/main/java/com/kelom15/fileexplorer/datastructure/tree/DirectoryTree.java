package com.kelom15.fileexplorer.datastructure.tree;

public class DirectoryTree {

    private DirectoryNode root;

    public DirectoryTree() {
    }

    public DirectoryTree(DirectoryNode root) {
        this.root = root;
    }

    public DirectoryNode getRoot() {
        return root;
    }

    public void setRoot(DirectoryNode root) {
        this.root = root;
    }

    public void clear() {
        root = null;
    }

    public int countNodes() {

        return count(root);

    }

    private int count(DirectoryNode node) {

        if (node == null) {
            return 0;
        }

        int total = 1;

        for (DirectoryNode child : node.getChildren()) {

            total += count(child);

        }

        return total;

    }

    public DirectoryNode findNode(String path) {

        return search(root, path);

    }

    private DirectoryNode search(DirectoryNode node, String path) {

        if (node == null) {
            return null;
        }

        if (node.getPath().equals(path)) {
            return node;
        }

        for (DirectoryNode child : node.getChildren()) {

            DirectoryNode result = search(child, path);

            if (result != null) {
                return result;
            }

        }

        return null;

    }

    public void traverseDFS() {

        traverse(root);

    }

    private void traverse(DirectoryNode node) {

        if (node == null) {
            return;
        }

        System.out.println(node.getName());

        for (DirectoryNode child : node.getChildren()) {

            traverse(child);

        }

    }

    public void printTree() {

        print(root, "");

    }

    private void print(DirectoryNode node, String indent) {

        if (node == null) {
            return;
        }

        System.out.println(indent + "📁 " + node.getName());

        for (DirectoryNode child : node.getChildren()) {

            print(child, indent + "    ");

        }

    }

}
