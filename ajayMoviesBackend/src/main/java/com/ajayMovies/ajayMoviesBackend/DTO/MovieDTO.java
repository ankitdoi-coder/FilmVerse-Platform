package com.ajayMovies.ajayMoviesBackend.DTO;

import lombok.Data;

@Data
public class MovieDTO {
    private long id;
    private String title;
    private String posterPath;
    private String downloadLink;
}
