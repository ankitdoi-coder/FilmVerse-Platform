package com.ajayMovies.ajayMoviesBackend.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ajayMovies.ajayMoviesBackend.DTO.MovieDTO;
import com.ajayMovies.ajayMoviesBackend.Entity.Movie;
import com.ajayMovies.ajayMoviesBackend.Services.MovieService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

    @Autowired
    MovieService movieService;  
    
    @PostMapping(value = "/save-movie", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveMovie(
        @RequestPart("movie") MovieDTO movieDTO,
        @RequestPart("poster") MultipartFile poster,
        @RequestPart("screenshots") List<MultipartFile> screenshots
    ) {
        try {
            Movie movie = movieService.saveMovie(movieDTO,poster,screenshots);
            return ResponseEntity.ok(movie);
        } catch (IllegalArgumentException | IllegalStateException | IOException e) {
            return ResponseEntity.status(500).body("Error saving movie: " + e.getMessage());
        }
    }
    
    @GetMapping("/get-all-movies")
    public ResponseEntity<?> getAllMovies(){
        try {
            List<Movie> movies=movieService.getAllMovies();
            return ResponseEntity.ok(movies);
        } catch(IOException e){
            return ResponseEntity.status(500).body("Error while Fething Movies: "+e.getMessage());
        }
        
    }
}
