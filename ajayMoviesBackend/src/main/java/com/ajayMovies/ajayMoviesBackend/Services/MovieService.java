package com.ajayMovies.ajayMoviesBackend.Services;

import com.ajayMovies.ajayMoviesBackend.DTO.MovieDTO;
import com.ajayMovies.ajayMoviesBackend.Entity.Movie;


public interface  MovieService {
    Movie saveMovie(MovieDTO movieDTO);
}
