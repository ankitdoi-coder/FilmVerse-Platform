import { Component, OnInit } from '@angular/core';
import { Movie } from '../Services/movie';
import { Moviez } from '../Models/Moviez';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  imports: [CommonModule],
  templateUrl: './home.html',
  styleUrl: './home.scss',
})
export class Home implements OnInit {

  movies: Moviez[] = [];

  constructor(private movieService: Movie) {}

  ngOnInit() {
    this.movieService.getAllMovies().subscribe({
      next: (data) => this.movies = data,
      error: (err) => console.error(err)
    });
  }

}
