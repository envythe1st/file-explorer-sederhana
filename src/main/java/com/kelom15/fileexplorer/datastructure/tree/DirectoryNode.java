package com.kelom15.fileexplorer.datastructure.tree;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DirectoryNode {

    private String name;
    private String path;
    private boolean directory;
    private long size;
    private LocalDateTime lastModified;
    @JsonIgnore
    private DirectoryNode parent;
    private List<DirectoryNode> children;

    public DirectoryNode() {
        this.children = new ArrayList<>();
    }

    public DirectoryNode(String name,
            String path,
            boolean directory,
            long size,
            LocalDateTime lastModified) {

        this.name = name;
        this.path = path;
        this.directory = directory;
        this.size = size;
        this.lastModified = lastModified;
        this.children = new ArrayList<>();
    }

    public void addChild(DirectoryNode child) {

        child.setParent(this);
        children.add(child);

    }

    public void removeChild(DirectoryNode child) {

        children.remove(child);

    }

    public boolean isLeaf() {

        return children.isEmpty();

    }

    public boolean hasChildren() {

        return !children.isEmpty();

    }

    public DirectoryNode getChildByName(String name) {

        for (DirectoryNode child : children) {

            if (child.getName().equalsIgnoreCase(name)) {

                return child;

            }

        }

        return null;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isDirectory() {
        return directory;
    }

    public void setDirectory(boolean directory) {
        this.directory = directory;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public DirectoryNode getParent() {
        return parent;
    }

    public void setParent(DirectoryNode parent) {
        this.parent = parent;
    }

    public List<DirectoryNode> getChildren() {
        return children;
    }

    public void setChildren(List<DirectoryNode> children) {
        this.children = children;
    }

}
