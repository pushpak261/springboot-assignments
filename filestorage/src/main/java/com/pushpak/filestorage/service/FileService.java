package com.pushpak.filestorage.service;

import com.pushpak.filestorage.entity.UploadFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
public interface FileService {

    UploadFile uploadFile(MultipartFile file) throws IOException;

    List<UploadFile> getAllFiles();

    Optional<UploadFile> getFileById(Long id);

    byte[] downloadFile(String name) throws IOException;

    String deleteFile(Long id);
}
