package com.ajayMovies.ajayMoviesBackend.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "poster_path")
    private String posterPath;

    @Column(name = "subhead_movie_name")
    private String subHead_MovieName;
    @Column(name = "subhead_type")
    private String subHead_type;
    @Column(name = "movie_info_imbd_rating")
    private String movieInfo_ImbdRating;
    @Column(name = "movie_info_movie_name")
    private String movieInfo_movieName;
    @Column(name = "movie_info_language")
    private String movieInfo_langauge;
    @Column(name = "movie_info_release_year")
    private String movieInfo_releaseYear;
    @Column(name = "movie_info_quality")
    private String movieInfo_quality;
    @Column(name = "movie_info_size")
    private String movieInfo_size;
    @Column(name = "movie_info_format")
    private String movieInfo_Format;

    @Column(name = "movie_synopsis")
    private String movieSynopsis;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Screenshots> screenshots;

    @Column(name = "download_link_480")
    private String downloadLink480;
    @Column(name = "download_link_720")
    private String downloadLink720;
    @Column(name = "download_link_1080")
    private String downloadLink1080;

}
