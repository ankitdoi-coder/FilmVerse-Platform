package com.ajayMovies.ajayMoviesBackend.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajayMovies.ajayMoviesBackend.DTO.MovieDTO;
import com.ajayMovies.ajayMoviesBackend.Entity.Movie;
import com.ajayMovies.ajayMoviesBackend.Mapper.MovieMapper;
import com.ajayMovies.ajayMoviesBackend.Repository.MovieRepo;
import com.ajayMovies.ajayMoviesBackend.Services.MovieService;

@Service
public class MovieServiceImpl  implements MovieService{

    @Autowired
    MovieRepo movieRepo;
    @Autowired
    MovieMapper movieMapper;


    @Override
    public Movie saveMovie(MovieDTO movieDTO) {
        Movie savedMovie=movieRepo.save(movieMapper.DtoToMovie(movieDTO));
        return savedMovie;
    }
    
}
