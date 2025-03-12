package com.pushpak.filestorage.controller;

import com.pushpak.filestorage.entity.UploadFile;
import com.pushpak.filestorage.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fs;

    @PostMapping("/upload")
    public UploadFile uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return fs.uploadFile(file);
    }

    @GetMapping
    public List<UploadFile> getAllFiles(){
        return fs.getAllFiles();
    }

    @GetMapping("/{id}")
    public Optional<UploadFile> getFileById(@PathVariable Long id){
        return fs.getFileById(id);
    }

    @GetMapping("/download/{name}")
    public byte[] downloadFile(@PathVariable String name) throws IOException {
        return fs.downloadFile(name);
    }

    @DeleteMapping("/{id}")
    public String deleteFile(@PathVariable Long id){
        return fs.deleteFile(id);
    }



}


//FileController to accept the file directly in the request body using @RequestBody. However, file uploads typically require @RequestParam because MultipartFile cannot be sent as JSON.