import { Component, OnInit } from '@angular/core';
import { EmployeeDetails } from 'src/app/models/employee-details.model';
import { EmployeeService } from 'src/app/service/employee.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  employee: EmployeeDetails;

  constructor(private employeeService: EmployeeService, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit() {
    let empId = this.activatedRoute.snapshot.params['id'];
    if(empId){
      this.fetchUserInfo(empId);
    }
  }

  fetchUserInfo(empId: number) {
    this.employeeService.getEmployeeById(empId).subscribe(response => {
      this.employee = response;
    })
  }

}
