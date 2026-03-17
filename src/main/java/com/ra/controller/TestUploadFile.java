package com.ra.controller;

import com.ra.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TestUploadFile {
    @Autowired
    private UploadService uploadService;
    @PostMapping("/test-upload")
    public String uploadFile(@ModelAttribute("file") MultipartFile file){
        String url = uploadService.upload(file);
        return url;
    }
}
