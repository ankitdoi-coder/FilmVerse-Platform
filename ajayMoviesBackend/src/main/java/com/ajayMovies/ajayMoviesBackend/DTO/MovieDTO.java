package com.ajayMovies.ajayMoviesBackend.DTO;

import org.springframework.web.multipart.MultipartFile;
import java.util.*;
import lombok.Data;


@Data
public class MovieDTO {

    private Long id;
    private String title;
    private String posterPath;
    private MultipartFile posterImg;
    private List<MultipartFile> screenshots;

    private String subHead_MovieName;
    private String subHead_type;
    private String movieInfo_ImbdRating;
    private String movieInfo_movieName;
    private String movieInfo_langauge;
    private String movieInfo_releaseYear;
    private String movieInfo_quality;
    private String movieInfo_size;
    private String movieInfo_Format;

    private String movieSynopsis;

    private String downloadLink480;
    private String downloadLink720;
    private String downloadLink1080;
}

