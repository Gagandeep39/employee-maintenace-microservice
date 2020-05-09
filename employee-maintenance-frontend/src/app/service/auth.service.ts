/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-09 19:36:09
 * @modify date 2020-05-09 19:36:09
 * @desc Authentication Service
 */

import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private router: Router) { }

  public logOut() : void {
    sessionStorage.clear();
    this.router.navigate(['/login']);
  }

}
