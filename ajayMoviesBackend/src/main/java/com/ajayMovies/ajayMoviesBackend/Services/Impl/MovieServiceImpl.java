package com.ajayMovies.ajayMoviesBackend.Services.Impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ajayMovies.ajayMoviesBackend.DTO.MovieDTO;
import com.ajayMovies.ajayMoviesBackend.Entity.Movie;
import com.ajayMovies.ajayMoviesBackend.Mapper.MovieMapper;
import com.ajayMovies.ajayMoviesBackend.Repository.MovieRepo;
import com.ajayMovies.ajayMoviesBackend.Services.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepo movieRepo;
    @Autowired
    MovieMapper movieMapper;

    @Override
    public Movie saveMovie(MovieDTO movieDTO, MultipartFile poster, List<MultipartFile> screenshots) throws IOException {
        Movie savedMovie = movieRepo.save(movieMapper.DtoToMovie(movieDTO, poster, screenshots));
        return savedMovie;
    }

    @Override
    public List<Movie> getAllMovies() throws IOException {
        List<Movie> movies = movieRepo.findAll();
        for (Movie movie : movies) {
            if (movie.getPosterPath() != null && movie.getPosterPath().contains("uploads")) {
                String fileName = movie.getPosterPath().substring(movie.getPosterPath().lastIndexOf("\\") + 1);
                movie.setPosterPath("/movies/" + fileName);
            }
        }
        return movies;
    }

    @Override
    public Movie getMovieByID(Long id) throws IOException {
        Movie movie = movieRepo.findById(id).orElse(null);
        return movie;
    }

}
