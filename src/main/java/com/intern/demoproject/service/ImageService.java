package com.intern.demoproject.service;

import com.intern.demoproject.dto.UserDto;
import com.intern.demoproject.entity.User;
import com.intern.demoproject.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final AmazonClient amazonClient;

    private final UserRepository userRepository;

    @Transactional
    public void uploadImage(Long id, MultipartFile path) {

        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String oldPath = user.getAvatar();

        if (oldPath != null) {
            amazonClient.deleteFileFromS3Bucket(oldPath);
        }

        String newPath = amazonClient.uploadFile(path);
        userRepository.updateImagePath(id, newPath);
    }

}
