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
  selectedFilePoster: File | null = null;
  selectedFileSS: File[] = [];

  constructor(
    private fb: FormBuilder,
    private movieService: Movie,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.movieFormGroup = this.fb.group({
      title: ['', [Validators.required]],
      subHead_MovieName: ['', [Validators.required]],
      subHead_type: ['', [Validators.required]],
      movieInfo_movieName: ['', [Validators.required]],
      movieInfo_ImbdRating: ['', [Validators.required]],
      movieInfo_langauge: ['', [Validators.required]],
      movieInfo_releaseYear: ['', [Validators.required]],
      movieInfo_quality: ['', [Validators.required]],
      movieInfo_size: ['', [Validators.required]],
      movieInfo_Format: ['', [Validators.required]],
      movieSynopsis: ['', [Validators.required]],
      downloadLink480: ['', [Validators.required]],
      downloadLink720: ['', [Validators.required]],
      downloadLink1080: ['', [Validators.required]],
    })
  }

  onFileSelectedPoster(event: any) {
    this.selectedFilePoster = event.target.files[0];
  }
  onFileSelectedSS(event: any) {
    this.selectedFileSS = Array.from(event.target.files);
  }

  // submitForm() {
  //   if (this.movieFormGroup.invalid || !this.selectedFilePoster || this.selectedFileSS.length === 0) {
  //     console.log("form data is invalid or no file selected")
  //     return;
  //   }


  //   const formValue = this.movieFormGroup.value;
  //   const formData = new FormData();
  //   formData.append('title', formValue.title || '');
  //   formData.append('subHead_MovieName', formValue.subHead_MovieName || '');
  //   formData.append('subHead_type', formValue.subHead_type || '');
  //   formData.append('movieInfo_movieName', formValue.movieInfo_movieName || '');
  //   formData.append('movieInfo_ImbdRating', formValue.movieInfo_ImbdRating || '');
  //   formData.append('movieInfo_langauge', formValue.movieInfo_langauge || '');
  //   formData.append('movieInfo_releaseYear', formValue.movieInfo_releaseYear || '');
  //   formData.append('movieInfo_quality', formValue.movieInfo_quality || '');
  //   formData.append('movieInfo_size', formValue.movieInfo_size || '');
  //   formData.append('movieInfo_Format', formValue.movieInfo_Format || '');
  //   formData.append('movieSynopsis', formValue.movieSynopsis || '');
  //   formData.append('downloadLink480', formValue.downloadLink480 || '');
  //   formData.append('downloadLink720', formValue.downloadLink720 || '');
  //   formData.append('downloadLink1080', formValue.downloadLink1080 || '');
  //   formData.append('posterImg', this.selectedFilePoster);
    
  //   // Append all screenshot files
  //   this.selectedFileSS.forEach((file, index) => {
  //     formData.append(`screenshots`, file);
  //   });

  //   //call the save api here
  //   this.movieService.saveMovie(formData).subscribe({
  //     next: () => this.router.navigate(['/']),
  //     error: err => console.error(err)
  //   });

  // }

// src/app/admin/admin.ts

submitForm() {
  // Debugging: If this block hits, the form is invalid. Check your console.
  if (this.movieFormGroup.invalid || !this.selectedFilePoster || this.selectedFileSS.length === 0) {
    console.error("Form is invalid. Please check the following fields:");
    // This will help you find WHICH field is invalid causing the 'no request' issue
    Object.keys(this.movieFormGroup.controls).forEach(key => {
      const controlErrors = this.movieFormGroup.get(key)?.errors;
      if (controlErrors) {
        console.log('Field: ' + key + ', Errors: ', controlErrors);
      }
    });
    return;
  }

  const formValue = this.movieFormGroup.value;

  // 1. Create a Javascript Object matching your MovieDTO
  const movieData = {
    title: formValue.title,
    subHead_MovieName: formValue.subHead_MovieName,
    subHead_type: formValue.subHead_type,
    movieInfo_movieName: formValue.movieInfo_movieName,
    movieInfo_ImbdRating: formValue.movieInfo_ImbdRating,
    movieInfo_langauge: formValue.movieInfo_langauge,
    movieInfo_releaseYear: formValue.movieInfo_releaseYear,
    movieInfo_quality: formValue.movieInfo_quality,
    movieInfo_size: formValue.movieInfo_size,
    movieInfo_Format: formValue.movieInfo_Format,
    movieSynopsis: formValue.movieSynopsis,
    downloadLink480: formValue.downloadLink480,
    downloadLink720: formValue.downloadLink720,
    downloadLink1080: formValue.downloadLink1080
  };

  const formData = new FormData();

  // 2. Append the JSON object as a Blob with type 'application/json'
  // Key must be 'movie' to match @RequestPart("movie")
  formData.append('movie', new Blob([JSON.stringify(movieData)], { type: 'application/json' }));

  // 3. Append the Poster
  // Key must be 'poster' to match @RequestPart("poster") (Changed from 'posterImg')
  formData.append('poster', this.selectedFilePoster);

  // 4. Append Screenshots
  this.selectedFileSS.forEach((file) => {
    formData.append('screenshots', file);
  });

  // Call the save API
  this.movieService.saveMovie(formData).subscribe({
    next: () => {
      console.log('Movie saved successfully');
      this.router.navigate(['/']);
    },
    error: err => console.error('Error saving movie:', err)
  });
}
}
