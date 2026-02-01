import { Component, OnInit } from '@angular/core';
import { Movie } from '../Services/movie';
import { Moviez } from '../Models/Moviez';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';


@Component({
  selector: 'app-home',
  imports: [CommonModule],
  templateUrl: './home.html',
  styleUrl: './home.scss',
})
export class Home implements OnInit {

  movies: Moviez[] = [];

  movieId:number | null=null;


  constructor(private movieService: Movie, private router: Router) {}

  //loads movies on page Load
  ngOnInit() {
    this.movieService.getAllMovies().subscribe({
      next: (data) => this.movies = data,
      error: (err) => console.error(err)
    });
  }

  //get Movie data on Click Movie Card and route to the download page
  openMovie(movieId:number){
    this.router.navigate(['/download',movieId]);
  }
}
