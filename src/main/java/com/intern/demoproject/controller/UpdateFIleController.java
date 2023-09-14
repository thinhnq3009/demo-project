package com.intern.demoproject.controller;

import com.intern.demoproject.service.AmazonClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import static com.intern.demoproject.utils.Constants.Storage.UPLOAD_ENDPOINT;

@Controller
@RequiredArgsConstructor
@RequestMapping(UPLOAD_ENDPOINT)
public class UpdateFIleController {

    private final AmazonClient amazonClient;

    @PostMapping()
    public ResponseEntity<?> uploadFile(
            @RequestPart(value = "file") MultipartFile file) {
        String path = amazonClient.uploadFile(file);
        return ResponseEntity.ok(path);
    }
}
