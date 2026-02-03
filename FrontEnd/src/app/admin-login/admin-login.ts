import { Component } from '@angular/core';
import { FormBuilder, Validator, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from '../Services/movie';

@Component({
  selector: 'app-admin-login',
  imports: [],
  templateUrl: './admin-login.html',
  styleUrl: './admin-login.scss',
})
export class AdminLogin {

  //form Froup name
  loginFormGrp: any;

  constructor(private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private movieService: Movie
  ) {
    this.loginFormGrp = fb.group({
      userName: ['', [Validators.required]],
      password: ['', [Validators.required]]
    })
  }



  showPassword: boolean = false;
  loading: boolean = false;
  rememberMe: boolean = false;
  errorMessage = '';

  togglePassword() {
    this.showPassword = !this.showPassword;
  };

  login() {
    this.loading = true;
    this.errorMessage = '';

    //first create service for the jwt token and all then come here 
  };

}
