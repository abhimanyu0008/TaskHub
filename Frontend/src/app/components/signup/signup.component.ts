import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SignupService } from 'src/app/services/signup.service';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  signupForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private service: SignupService,
    private router: Router
  ) {
    this.signupForm = this.formBuilder.group({
      fullName: ['', Validators.required],
      username: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required, Validators.pattern('[0-9]{10}')]],
      password: ['', Validators.required],
      gender: ['', Validators.required]
    });
  }

  addUser() {
    if (this.signupForm.valid) {
      this.service.addUser(
        this.signupForm.value.fullName,
        this.signupForm.value.username,
        this.signupForm.value.email,
        this.signupForm.value.phone,
        this.signupForm.value.password,
        this.signupForm.value.gender
      ).subscribe(
        (response) => {
          console.log('User added successfully:', response);
          this.router.navigate(['/home']);
        },
        (error: HttpErrorResponse) => {
          if (error.status === 409) { // Assuming 409 for conflict
            alert('Username already exists. Please choose another one.');
          } else {
            console.error('Error occurred while adding user:', error.message);
          }
        }
      );
    } else {
      alert('Please fill all required fields correctly!');
    }
  }
}
