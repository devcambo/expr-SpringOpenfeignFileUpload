package com.devcambo.exprspringopenfeignfileupload.controller;

import com.devcambo.exprspringopenfeignfileupload.service.FileServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/files")
@Slf4j
public class FileController {

    @Autowired
    private FileServiceClient fileServiceClient;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestPart MultipartFile file){
        log.info("Received file: {}", file.getOriginalFilename());
        try {
            ResponseEntity<?> response = fileServiceClient.uploadFile(file);
            assert response.getBody() != null;
            log.info("Response from client {}", response.getBody());
            return ResponseEntity.ok(response.getBody());
        } catch (Exception e) {
            log.error("Error uploading file: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", e.getMessage()));
        }
    }

}
