import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { EmployeePage } from '../models/employee-page.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private httpClient: HttpClient) { }

  getEmployeePages(pageNo: number, pageSize = 10, sortBy = undefined) {
    let params = new HttpParams();
    params = params.set('pageNo', pageNo.toString());
    params = params.set('pageSize', pageSize.toString());
    if (sortBy !== undefined && sortBy !== null) {
      params = params.set('sortBy', sortBy.toString());
    }
    return this.httpClient.get<EmployeePage>(environment.url + environment.fetchAllEmployee,
      {
        params: params
      });
  }

}
