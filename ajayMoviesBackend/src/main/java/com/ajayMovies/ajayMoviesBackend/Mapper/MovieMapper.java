package com.ajayMovies.ajayMoviesBackend.Mapper;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ajayMovies.ajayMoviesBackend.DTO.MovieDTO;
import com.ajayMovies.ajayMoviesBackend.Entity.Movie;
import com.ajayMovies.ajayMoviesBackend.Services.FileStorageService;

@Component
public class MovieMapper {
    @Autowired
    FileStorageService fileStorageService;

    //Maps the Movie DTO into Movie Entity
    public Movie DtoToMovie(MovieDTO movieDTO) throws IOException {
        Movie movie=new Movie();

        movie.setId(movieDTO.getId());
        movie.setTitle(movieDTO.getTitle());
        movie.setPosterPath(fileStorageService.savePoster(movieDTO.getPosterImg()));
        movie.setDownloadLink(movieDTO.getDownloadLink());

        return movie;
    }


    //Maps the Movie Entity into Movie DTO
    public MovieDTO MovieToDto(Movie movie){
        MovieDTO movieDto=new MovieDTO();

        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setPosterPath(movie.getPosterPath());
        movieDto.setDownloadLink(movie.getDownloadLink());

        return movieDto;
    }
}
