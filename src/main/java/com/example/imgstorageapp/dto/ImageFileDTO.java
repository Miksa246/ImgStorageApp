package com.example.imgstorageapp.dto;

public class ImageFileDTO {
    private Long id;
    private String owner;
    private String name;
    private Long fileSize;

    public ImageFileDTO(Long id, String name, String owner, Long fileSize) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.fileSize = fileSize;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
}
