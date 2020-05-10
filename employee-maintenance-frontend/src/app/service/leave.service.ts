import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { LeavePage } from '../models/leave-page.model';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';
import { User } from '../models/user.mode';
import { map } from 'rxjs/operators';
import { LeaveBalance } from '../models/leave-balance.model';

@Injectable({
  providedIn: 'root'
})
export class LeaveService {

  constructor(private httpClient: HttpClient, private authService: AuthService) { }

  getLeavePages(pageNo: number, pageSize = 10, sortBy = undefined) {
    let user : User = this.authService.fetchFromSessionStorage();
    let params = new HttpParams();
    params = params.set('pageNo', pageNo.toString());
    params = params.set('pageSize', pageSize.toString());
    if (sortBy !== undefined && sortBy !== null) {
      params = params.set('sortBy', sortBy.toString());
    }
    return this.httpClient.get<LeavePage>(environment.url + environment.employeeLeave + user.empId,
      {
        params: params
      });
  }

  getLeaveBalance() {
    let user : User = this.authService.fetchFromSessionStorage();
    return this.httpClient.get<LeaveBalance>(environment.url + environment.leaveBalance + user.empId)
    .pipe(
      map(response => {
        return response.balance;
      })
    );
  }

  createLeave() {
  }
}
