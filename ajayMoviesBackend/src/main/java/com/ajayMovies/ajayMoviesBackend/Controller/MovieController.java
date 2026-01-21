package com.ajayMovies.ajayMoviesBackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajayMovies.ajayMoviesBackend.DTO.MovieDTO;
import com.ajayMovies.ajayMoviesBackend.Entity.Movie;
import com.ajayMovies.ajayMoviesBackend.Services.MovieService;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    MovieService movieService;
    
    @PostMapping("save-movie")
    public ResponseEntity<Movie> saveMovie(@RequestBody MovieDTO movieDTO){
        return ResponseEntity.ok(movieService.saveMovie(movieDTO));
    }
}
