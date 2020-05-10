/**
 * @author Gagandeep Singh, Pranav Karmarkar
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-10 13:32:57
 * @modify date 2020-05-10 13:32:57
 * @desc Login Screen
 */
import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';
import { NgForm } from '@angular/forms';
import { ErrorResponse } from 'src/app/models/error-response.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css'],
})
export class UserLoginComponent implements OnInit {
  
  errorUsername: string;
  errorPassword: string;
  errorMessage: string;
  staySignedInToggle: boolean;

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit() {}

  login(loginForm: NgForm) {
    if (loginForm.valid) {
      this.authService.login(loginForm.value).subscribe(
        (response) => {
          this.router.navigate(['/employee/home']);
        },
        (error) => {
          // Implies there is conection with server
          if (error.error.message != undefined) this.handleError(error.error);
          else this.errorMessage = error;
        }
      );
    }
  }

  handleError(error: ErrorResponse) {
    this.errorMessage = undefined;
    if (error.message.includes('User')) {
      this.errorUsername = error.message;
      console.log(this.errorUsername);
      this.errorPassword = undefined;
    } else {
      console.log(this.errorPassword);
      this.errorUsername = undefined;
      this.errorPassword = error.message;
    }
  }

  saveSignedInState() {
    this.authService.keepMeSignedInToggleState = this.staySignedInToggle;
  }
}
