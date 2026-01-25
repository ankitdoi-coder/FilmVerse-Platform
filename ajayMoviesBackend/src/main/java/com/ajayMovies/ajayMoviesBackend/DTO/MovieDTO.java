package com.ajayMovies.ajayMoviesBackend.DTO;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MovieDTO {
    private Long id;
    private String title;
    private String posterPath;
    private MultipartFile posterImg;
    private String downloadLink;
}
