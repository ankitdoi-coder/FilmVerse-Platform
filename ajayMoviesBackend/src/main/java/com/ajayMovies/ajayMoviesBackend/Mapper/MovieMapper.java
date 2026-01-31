package com.ajayMovies.ajayMoviesBackend.Mapper;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ajayMovies.ajayMoviesBackend.DTO.MovieDTO;
import com.ajayMovies.ajayMoviesBackend.Entity.Movie;
import com.ajayMovies.ajayMoviesBackend.Entity.Screenshots;
import com.ajayMovies.ajayMoviesBackend.Services.FileStorageService;
import java.util.*;

@Component
public class MovieMapper {

    @Autowired
    FileStorageService fileStorageService;

    //Maps the Movie DTO into Movie Entity
    public Movie DtoToMovie(MovieDTO movieDTO) throws IOException {
        Movie movie = new Movie();

        movie.setId(movieDTO.getId());
        movie.setTitle(movieDTO.getTitle());
        //poster Path
        movie.setPosterPath(fileStorageService.savePoster(movieDTO.getPosterImg()));

        movie.setSubHead_MovieName(movieDTO.getSubHead_MovieName());
        movie.setSubHead_type(movieDTO.getSubHead_type());
        movie.setMovieInfo_ImbdRating(movieDTO.getMovieInfo_ImbdRating());
        movie.setMovieInfo_movieName(movieDTO.getMovieInfo_movieName());
        movie.setMovieInfo_langauge(movieDTO.getMovieInfo_langauge());
        movie.setMovieInfo_releaseYear(movieDTO.getMovieInfo_releaseYear());
        movie.setMovieInfo_quality(movieDTO.getMovieInfo_quality());
        movie.setMovieInfo_size(movieDTO.getMovieInfo_size());
        movie.setMovieInfo_Format(movieDTO.getMovieInfo_Format());
        movie.setMovieSynopsis(movieDTO.getMovieSynopsis());

        List<String> screenShotsPaths = fileStorageService.saveScreenshots(movieDTO.getScreenshots());
        List<Screenshots> screenShotList = screenShotsPaths.stream()
                .map(path -> {
                    Screenshots ss = new Screenshots();
                    ss.setScreenshotPath(path);
                    ss.setMovie(movie); // VERY IMPORTANT
                    return ss;
                })
                .toList();

        movie.setScreenshots(screenShotList);
        movie.setDownloadLink480(movieDTO.getDownloadLink480());
        movie.setDownloadLink720(movieDTO.getDownloadLink720());
        movie.setDownloadLink1080(movieDTO.getDownloadLink1080());
        return movie;
    }

    //Maps the Movie Entity into Movie DTO
    // public MovieDTO MovieToDto(Movie movie) {
    //     MovieDTO movieDto = new MovieDTO();

    //     movieDto.setId(movie.getId());
    //     movieDto.setTitle(movie.getTitle());
    //     movieDto.setPosterPath(movie.getPosterPath());
    //     movieDto.setDownloadLink(movie.getDownloadLink());

    //     return movieDto;
    // }
}
