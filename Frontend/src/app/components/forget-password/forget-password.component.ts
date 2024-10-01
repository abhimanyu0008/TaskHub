import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-forget-password',
  templateUrl: './forget-password.component.html',
  styleUrls: ['./forget-password.component.css']
})
export class ForgetPasswordComponent {

  username: string = '';
  newPassword: string = '';
  confirmPassword: string = '';



  constructor(private service: LoginService, private router: Router) {}

  changePassword() {
    // Check if new password and confirm password match
    if (this.newPassword !== this.confirmPassword) {
      alert("Passwords do not match!");
      return;
    }

    // Call the service to change the password
    this.service.changePassword(this.username, this.newPassword).subscribe(
      (response) => {
        // Handle successful response
        alert(response.message); // Access the message from the response
        this.router.navigate(['']); // Navigate to login page
      },
      (error) => {
        // Handle error response
        console.error('Error updating password:', error);
        if (error.status === 404) {
          alert("User not found.");
        } else {
          alert("An error occurred while changing the password.");
        }
      }
    );
  }
}
