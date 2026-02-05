package com.ajayMovies.ajayMoviesBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajayMovies.ajayMoviesBackend.Entity.Movie;

@Repository
public interface  MovieRepo extends JpaRepository<Movie, Long> {
}
