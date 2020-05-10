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
        tap((user: User)=>{
          this.loggedInUser = user;
          if(this.keepMeSignedInToggleState)
            sessionStorage.setItem("user", user.toString());
        })
      );
  }

  public logOut() : void {
    sessionStorage.clear();
    this.router.navigate(['/login']);
  }

}
