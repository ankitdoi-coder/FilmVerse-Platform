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
  selectedFile: File | null = null;

  constructor(
    private fb:FormBuilder,
    private movieService:Movie,
    private router:Router,
    private route:ActivatedRoute
  ){
    this.movieFormGroup=this.fb.group({
      title: ['', [Validators.required]],
      downloadLink: ['', [Validators.required]],
    })
  }

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }

  submitForm() {
    if (this.movieFormGroup.invalid || !this.selectedFile) {
      console.log("form data is invalid or no file selected")
      return;
    }

   
    const formValue = this.movieFormGroup.value;
    const formData = new FormData();
    formData.append('title', formValue.title || '');
    formData.append('posterImg', this.selectedFile);
    formData.append('downloadLink', formValue.downloadLink || '');

    //call the save api here
      this.movieService.saveMovie(formData).subscribe({
        next: () => this.router.navigate(['/']),
        error: err => console.error(err)
      });

  }

}
