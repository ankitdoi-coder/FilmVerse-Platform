package com.ajayMovies.ajayMoviesBackend.Mapper;

import com.ajayMovies.ajayMoviesBackend.DTO.MovieDTO;
import com.ajayMovies.ajayMoviesBackend.Entity.Movie;

public class MovieMapper {

    //Maps the Movie DTO into Movie Entity
    public Movie DtoToMovie(MovieDTO movieDTO){
        Movie movie=new Movie();

        movie.setId(movieDTO.getId());
        movie.setTitle(movieDTO.getTitle());
        movie.setPosterPath(movieDTO.getPosterPath());
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
