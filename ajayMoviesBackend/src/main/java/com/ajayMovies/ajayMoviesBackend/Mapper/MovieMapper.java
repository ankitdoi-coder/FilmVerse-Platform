package com.ajayMovies.ajayMoviesBackend.Mapper;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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
    public Movie DtoToMovie(MovieDTO movieDTO,MultipartFile poster,List<MultipartFile> screenshots) throws IOException {
        Movie movie = new Movie();

        //Normal Data
        movie.setId(movieDTO.getId());
        movie.setTitle(movieDTO.getTitle());
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
        movie.setDownloadLink480(movieDTO.getDownloadLink480());
        movie.setDownloadLink720(movieDTO.getDownloadLink720());
        movie.setDownloadLink1080(movieDTO.getDownloadLink1080());

        //Files Data
        // 1.Poster 
        movie.setPosterPath(fileStorageService.savePoster(poster));

        // 2.Screenshots
        //first save the screenshots path into a List of Strings
        List<String> screenShotsPaths = fileStorageService.saveScreenshots(screenshots);

        //save the paths into  screenshots entity
        List<Screenshots> screenShotList = screenShotsPaths.stream()
                .map(path -> {
                    Screenshots ss = new Screenshots();
                    ss.setScreenshotPath(path);
                    ss.setMovie(movie); // VERY IMPORTANT
                    return ss;
                })
                .toList();


        //then Finaly save that screenshots Entity into movie Entity         
        movie.setScreenshots(screenShotList);
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
