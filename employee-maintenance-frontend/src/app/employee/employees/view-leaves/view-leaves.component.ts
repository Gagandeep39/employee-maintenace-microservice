import { Component, OnInit } from '@angular/core';
import { LeaveService } from 'src/app/service/leave.service';
import { LeavePage } from 'src/app/models/leave-page.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-leaves',
  templateUrl: './view-leaves.component.html',
  styleUrls: ['./view-leaves.component.css']
})
export class ViewLeavesComponent implements OnInit {

  public leavePage: LeavePage = new LeavePage();
  public currentPage: number;

  constructor(private leaveService: LeaveService, private route : Router) { }

  ngOnInit() {
    this.fetchDatafromServer(0);
    this.currentPage = 0;
  }

  fetchDatafromServer(pageNo: number, pageSize = 10) {
    this.leaveService
      .getLeavePages(pageNo, pageSize)
      .subscribe((response) => {
        this.leavePage = response;
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

  createLeave()
  {
    this.route.navigate(['employee/addleave']);
  }
}
