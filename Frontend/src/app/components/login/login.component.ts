import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username: string = '';
  password: string = '';

  constructor(private router: Router, private service: LoginService) {}

  loginUser() {
    this.service.loginUser(this.username, this.password)
      .subscribe({
        next: (response) => {
          if (response != null) {
            console.log('Login successful:', response);
            this.router.navigate(['/home']);  
          } else {
            alert('Invalid username or password');
          }
        },
        error: (err) => {
          console.error('Login failed:', err);
          alert('Invalid username or password');
        }
      });
  }
}
