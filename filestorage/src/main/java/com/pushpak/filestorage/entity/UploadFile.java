package com.pushpak.filestorage.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


//fields: fileName, filePath, uploadTime


@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "fileName")})
public class UploadFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String filePath;
    private LocalDateTime uploadTime;

    public UploadFile(LocalDateTime uploadTime, String filePath, String fileName, Long id) {
        this.uploadTime = uploadTime;
        this.filePath = filePath;
        this.fileName = fileName;
        this.id = id;
    }

    public UploadFile(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public LocalDateTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(LocalDateTime uploadTime) {
        this.uploadTime = uploadTime;
    }
}
