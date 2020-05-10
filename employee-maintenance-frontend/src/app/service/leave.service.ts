import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { LeavePage } from '../models/leave-page.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LeaveService {

  empId = 100001;

  constructor(private httpClient: HttpClient) { }

  getLeavePages(pageNo: number, pageSize = 10, sortBy = undefined) {
    let params = new HttpParams();
    params = params.set('pageNo', pageNo.toString());
    params = params.set('pageSize', pageSize.toString());
    if (sortBy !== undefined && sortBy !== null) {
      params = params.set('sortBy', sortBy.toString());
    }
    return this.httpClient.get<LeavePage>(environment.url + environment.employeeLeave + this.empId,
      {
        params: params
      });
  }

  createLeave() {
  }
}
