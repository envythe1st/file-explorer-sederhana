package com.kelom15.fileexplorer.dto;

public class DirectoryResponse {

    private String name;
    private String path;
    private boolean directory;
    private long size;
    private String lastModified;

    public DirectoryResponse() {
    }

    public DirectoryResponse(String name,
            String path,
            boolean directory,
            long size,
            String lastModified) {

        this.name = name;
        this.path = path;
        this.directory = directory;
        this.size = size;
        this.lastModified = lastModified;

    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public boolean isDirectory() {
        return directory;
    }

    public long getSize() {
        return size;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setDirectory(boolean directory) {
        this.directory = directory;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

}
