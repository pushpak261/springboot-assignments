package com.pushpak.filestorage.repository;

import com.pushpak.filestorage.entity.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<UploadFile, Long> {

    UploadFile findByFileName(String fileName);

    String fileName(String fileName);
}
