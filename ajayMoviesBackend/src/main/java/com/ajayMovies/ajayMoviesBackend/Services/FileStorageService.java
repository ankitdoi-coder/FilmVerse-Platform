package com.ajayMovies.ajayMoviesBackend.Services;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {
    
    @Value("${file.upload-dir}")
    private String uploadDir;


    public String savePoster(MultipartFile file) throws IOException {
        // Create directory if not exists
        try {
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            //generate Unique File Name
            String fileName=UUID.randomUUID() + "_" + file.getOriginalFilename();

            //Full File path
            Path filepath=uploadPath.resolve(fileName);

            Files.copy(file.getInputStream(),filepath,StandardCopyOption.REPLACE_EXISTING);

            return "/movies/" + fileName;

            
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }
}
