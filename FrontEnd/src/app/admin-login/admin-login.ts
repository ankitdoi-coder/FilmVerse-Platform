import { Component } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../Services/auth.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-admin-login',
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './admin-login.html',
  styleUrl: './admin-login.scss',
})
export class AdminLogin {

  loginFormGrp: any;
  showPassword: boolean = false;
  loading: boolean = false;
  errorMessage = '';

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private authService: AuthService
  ) {
    this.loginFormGrp = fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]]
    })
  }

  togglePassword() {
    this.showPassword = !this.showPassword;
  }

  login() {
    console.log('Login method called');
    console.log('Form valid:', this.loginFormGrp.valid);
    console.log('Form values:', this.loginFormGrp.value);
    
    if (this.loginFormGrp.invalid) {
      this.errorMessage = 'Please fill all required fields';
      console.log('Form is invalid');
      return;
    }

    this.loading = true;
    this.errorMessage = '';
    console.log('Making login request...');

    this.authService.login(this.loginFormGrp.value).subscribe({
      next: (response) => {
        console.log('Login successful:', response);
        this.authService.saveToken(response.token);
        this.loading = false;
        this.router.navigate(['/admin']);
      },
      error: (error) => {
        console.error('Login failed:', error);
        this.loading = false;
        this.errorMessage = 'Invalid credentials';
      }
    });
  }
}
