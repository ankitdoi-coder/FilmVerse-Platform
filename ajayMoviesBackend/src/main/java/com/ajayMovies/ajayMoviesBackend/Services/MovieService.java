package com.ajayMovies.ajayMoviesBackend.Services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ajayMovies.ajayMoviesBackend.DTO.MovieDTO;
import com.ajayMovies.ajayMoviesBackend.Entity.Movie;


public interface  MovieService {
    Movie saveMovie(MovieDTO movieDTO,MultipartFile poster,List<MultipartFile> screenshots) throws IOException;
    List<Movie> getAllMovies() throws IOException;
}
