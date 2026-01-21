import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Movie } from '../Services/movie';
import { ActivatedRoute, Router } from '@angular/router';

import { RouterLink } from "@angular/router";

import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { Moviez } from '../Models/Moviez';
@Component({
  selector: 'app-admin',
  imports: [ReactiveFormsModule],
  templateUrl: './admin.html',
  styleUrl: './admin.scss',
})
export class Admin {

  movieFormGroup;

  constructor(
    private fb:FormBuilder,
    private movieService:Movie,
    private router:Router,
    private route:ActivatedRoute
  ){
    this.movieFormGroup=this.fb.group({
      title: ['', [Validators.required]],
      poster: ['', [Validators.required]],
      downloadLink: ['', [Validators.required]],
    })
  }

  submitForm() {
    if (this.movieFormGroup.invalid) {
      console.log("form data is invalid ")
      return;
    }

    //at First Storing the Employee form data into a variable
    const formValue = this.movieFormGroup.value;
    const movieData:Moviez = {
      title: formValue.title || '',
      poster: formValue.poster || '',
      downloadlink: formValue.downloadLink || '',
    };



    //call the save api here
      this.movieService.saveMovie(movieData).subscribe({
        next: () => this.router.navigate(['/']),
        error: err => console.error(err)
      });

  }

}
