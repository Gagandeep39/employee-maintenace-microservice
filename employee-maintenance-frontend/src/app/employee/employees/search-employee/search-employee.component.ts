import { Component, OnInit } from '@angular/core';
import { EmployeeService } from 'src/app/service/employee.service';
import { EmployeePage } from 'src/app/models/employee-page.model';

@Component({
  selector: 'app-search-employee',
  templateUrl: './search-employee.component.html',
  styleUrls: ['./search-employee.component.css']
})
export class SearchEmployeeComponent implements OnInit {

  public employeePage: EmployeePage = new EmployeePage();
  public currentPage: number;

  constructor(private employeeService: EmployeeService) { }

  ngOnInit() {
    this.fetchDatafromServer(0);
    this.currentPage = 0;
  }
  
  fetchDatafromServer(pageNo: number, pageSize = 10) {
    this.employeeService.getEmployeePages(pageNo, pageSize).subscribe(response=>{
      this.employeePage = response;
    });
  }

  goToPage(pageNo: number){
    this.currentPage = pageNo;
    this.fetchDatafromServer(pageNo);
  }

  previousPage(){
    this.fetchDatafromServer(this.currentPage --);
  }

  nextPage(){
    this.fetchDatafromServer(this.currentPage ++);
  }

  counter(i: number) {
    return new Array(i);
  }

}
