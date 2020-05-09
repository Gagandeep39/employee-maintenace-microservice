import { Component, OnInit } from '@angular/core';
import { EmployeeDetails } from 'src/app/models/employee-details.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  employee: EmployeeDetails;
  constructor() {
  }

  ngOnInit() {
  }

}
