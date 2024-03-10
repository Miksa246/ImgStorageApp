package com.example.imgstorageapp.entities;

import jakarta.persistence.*;

// Tehtävä 2: Entiteetti kuvatiedostoa varten
@Entity
public class ImageFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String owner;

    public ImageFile() {
    }

    public ImageFile(String name, String owner, byte[] data, Long fileSize) {
        this.name = name;
        this.owner = owner;
        this.data = data;
        this.fileSize = fileSize;
    }

    @Lob
    private byte[] data;

    private Long fileSize;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
}
