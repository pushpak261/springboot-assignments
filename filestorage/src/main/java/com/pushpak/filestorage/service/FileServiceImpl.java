package com.pushpak.filestorage.service;

import com.pushpak.filestorage.entity.UploadFile;
import com.pushpak.filestorage.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FileServiceImpl implements FileService {

    private static final String UPLOAD_DIR = "uploads/";

    @Autowired
    private FileRepository fr;


    @Override
    public UploadFile uploadFile(MultipartFile file) throws IOException {
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String fileName = file.getOriginalFilename();

        Path filePath = Paths.get(UPLOAD_DIR + fileName);

        Files.write(filePath, file.getBytes());

        UploadFile uploadFile = new UploadFile();
        uploadFile.setFileName(file.getOriginalFilename());
        uploadFile.setFilePath(filePath.toString());
        uploadFile.setUploadTime(LocalDateTime.now());
        return fr.save(uploadFile);
    }

    @Override
    public List<UploadFile> getAllFiles() {
        return fr.findAll();
    }

    @Override
    public Optional<UploadFile> getFileById(Long id) {
        return fr.findById(id);
    }

    @Override
    public byte[] downloadFile(String name) throws IOException {
        UploadFile file = fr.findByFileName(name);
        if (file == null) throw new RuntimeException("File not found");
        return Files.readAllBytes(Paths.get(file.getFilePath()));
    }

    @Override
    public String deleteFile(Long id) {
        Optional<UploadFile> fileOptional = fr.findById(id);

        if (fileOptional.isPresent()) {
            UploadFile file = fileOptional.get();
            File fileToDelete = new File(file.getFilePath());

            if (fileToDelete.exists() && fileToDelete.delete()) {
                fr.deleteById(id);
                return "File deleted successfully";
            } else {
                return "Failed to delete the file from storage";
            }
        } else {
            fr.deleteById(id);
            return "File record deleted, but file was not found on disk";
        }

    }
}