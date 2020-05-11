import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { EmployeePage } from '../models/employee-page.model';
import { EmployeeDetails } from '../models/employee-details.model';
import { BehaviorSubject } from 'rxjs';
import { UserForm } from '../models/user-form.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  saveEmployee(userForm: UserForm) {
    return this.httpClient.post(environment.url + environment.addEmployee, userForm);
  }

  public userEmitter: BehaviorSubject<UserForm> = new BehaviorSubject<UserForm>(null);

  searchByName(searchString: string) {
    let params = new HttpParams();
    params = params.set('name', searchString);
    return this.httpClient.get<EmployeePage>(environment.url + environment.byName,
      {
        params: params
      });
  }

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

  getEmployeeById(id: number) {
    return this.httpClient.get<EmployeeDetails>(environment.url + environment.byId + id);
  }

}
