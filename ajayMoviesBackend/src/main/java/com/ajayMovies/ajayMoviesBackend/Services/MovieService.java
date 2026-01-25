package com.ajayMovies.ajayMoviesBackend.Services;

import java.io.IOException;
import java.util.List;

import com.ajayMovies.ajayMoviesBackend.DTO.MovieDTO;
import com.ajayMovies.ajayMoviesBackend.Entity.Movie;


public interface  MovieService {
    Movie saveMovie(MovieDTO movieDTO) throws IOException;
    List<Movie> getAllMovies() throws IOException;
}
