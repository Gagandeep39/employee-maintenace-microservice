/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-09 19:36:09
 * @modify date 2020-05-09 19:36:09
 * @desc Authentication Service
 */

import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user.mode';
import { environment } from 'src/environments/environment';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  loggedInUser: User;
  keepMeSignedInToggleState: boolean = false;

  constructor(private router: Router, private httpClient: HttpClient) { }

  login(credential: User) {
    return this.httpClient.post<User>(environment.url + environment.login, credential)
      .pipe(
        tap((user: User) => {
          this.loggedInUser = user;
          sessionStorage.setItem('user', JSON.stringify(user));
          sessionStorage.setItem('userType', this.loggedInUser.role.role);
          if (this.keepMeSignedInToggleState) {
            localStorage.setItem('user', JSON.stringify(user));
            localStorage.setItem('userType', this.loggedInUser.role.role);
          }
        })
      );
  }

  public logOut(): void {
    sessionStorage.clear();
    localStorage.clear();
    this.router.navigate(['/login']);
  }

  isLoggedIn() {
    let user = this.fetchFromLocalStorage();
    if (user) {
      sessionStorage.setItem('user', JSON.stringify(user));
      this.loggedInUser = user;
      this.router.navigate(['/employee/home'])
    }
  }

  isUserLoggedIn(): boolean {
    let userSession = this.fetchFromSessionStorage();
    let userLocal = this.fetchFromLocalStorage();
    if (userSession == null && userLocal == null)
      return false;
    else
      return true;
  }

  typeOfUser(): String {
    let userTypeSession = sessionStorage.getItem('userType');
    let userTypeLocal = localStorage.getItem('userType');
    if (userTypeLocal == null)
      return userTypeSession;
    else
      return userTypeLocal;
  }

  fetchFromLocalStorage() {
    return JSON.parse(localStorage.getItem('user'));
  }

  fetchFromSessionStorage() {
    return JSON.parse(sessionStorage.getItem('user'));
  }

}
