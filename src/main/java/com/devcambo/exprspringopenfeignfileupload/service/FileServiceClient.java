package com.devcambo.exprspringopenfeignfileupload.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "${file-service.name}", url = "${file-service.url}")
public interface FileServiceClient {

    @PostMapping(value = "/v1/files/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<?> uploadFile(@RequestPart("file") MultipartFile file);

}
