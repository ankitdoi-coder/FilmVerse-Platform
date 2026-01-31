package com.ajayMovies.ajayMoviesBackend.Services;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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

    // ================= POSTER =================
    public String savePoster(MultipartFile file) {
        validateImage(file);
        return saveFile(file, "posters");
    }

    // ================= SCREENSHOTS =================
    public List<String> saveScreenshots(List<MultipartFile> files) {

        if (files == null || files.isEmpty()) {
            throw new IllegalArgumentException("Screenshots are required");
        }

        return files.stream()
                .map(file -> {
                    validateImage(file);
                    return saveFile(file, "screenshots");
                })
                .toList();
    }

    // ================= COMMON SAVE METHOD =================
    private String saveFile(MultipartFile file, String folder) {

        try {
            // uploads/movies/posters OR uploads/movies/screenshots
            Path uploadPath = Paths.get(uploadDir, folder);
            Files.createDirectories(uploadPath);

            // Unique filename
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

            // Full path
            Path filePath = uploadPath.resolve(fileName);

            // Save file
            Files.copy(
                    file.getInputStream(),
                    filePath,
                    StandardCopyOption.REPLACE_EXISTING
            );

            // Public URL (used by frontend)
            return "/movies/" + folder + "/" + fileName;

        } catch (IOException e) {
            throw new RuntimeException("Failed to store file: " + file.getOriginalFilename(), e);
        }
    }

    // ================= VALIDATION =================
    private void validateImage(MultipartFile file) {

        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }

        // String contentType = file.getContentType();
        // if (contentType == null || !contentType.startsWith("image/")) {
        //     throw new IllegalArgumentException("Only image files are allowed");
        // }
    }
}
