import { Component, OnInit } from '@angular/core';
import { EmployeeService } from 'src/app/service/employee.service';
import { EmployeePage } from 'src/app/models/employee-page.model';
import { ValidatorService } from 'src/app/service/validator.service';
import { Department } from 'src/app/models/department.model';
import { Grade } from 'src/app/models/grade.model';
import { MaritalStatus } from 'src/app/models/marital-status.model';

@Component({
  selector: 'app-search-employee',
  templateUrl: './search-employee.component.html',
  styleUrls: ['./search-employee.component.css'],
})
export class SearchEmployeeComponent implements OnInit {
  public employeePage: EmployeePage = new EmployeePage();
  public currentPage: number;
  departments : Department[]= [];
  grades : Grade[]=[];
  maritalStatuses : MaritalStatus[]=[]

  constructor(private employeeService: EmployeeService, private validatorService: ValidatorService) {}

  ngOnInit() {
    this.fetchDatafromServer(0);
    this.currentPage = 0;
    this.validatorService.fetchAllDepartments().subscribe(response => this.departments = response);
    this.validatorService.fetchAllGrades().subscribe(response => this.grades = response);
    this.maritalStatuses=Object.values(MaritalStatus);
  }

  fetchDatafromServer(pageNo: number, pageSize = 10) {
    this.employeeService
      .getEmployeePages(pageNo, pageSize)
      .subscribe((response) => {
        this.employeePage = response;
      });
  }

  goToPage(pageNo: number) {
    this.currentPage = pageNo;
    this.fetchDatafromServer(pageNo);
  }

  previousPage() {
    this.fetchDatafromServer(this.currentPage--);
  }

  nextPage() {
    this.fetchDatafromServer(this.currentPage++);
  }

  counter(i: number) {
    return new Array(i);
  }

  searchByName(searchString: string){
    this.employeeService.searchByName(searchString).subscribe(response=>{
      this.employeePage = response;
    });
  }
}
