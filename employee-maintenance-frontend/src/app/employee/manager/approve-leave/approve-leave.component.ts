import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LeavePage } from 'src/app/models/leave-page.model';
import { LeaveService } from 'src/app/service/leave.service';
import { LeaveStatus } from 'src/app/models/leave-status.model';

@Component({
  selector: 'app-approve-leave',
  templateUrl: './approve-leave.component.html',
  styleUrls: ['./approve-leave.component.css']
})
export class ApproveLeaveComponent implements OnInit {

  public leavePage: LeavePage = new LeavePage();
  public currentPage: number;
  public leaveBalance: number = 0;
  public leaveStatuses = LeaveStatus;

  constructor(private leaveService: LeaveService, private route: Router) { }

  ngOnInit() {
    this.fetchDatafromServer(0);
    this.currentPage = 0;
  }

  fetchDatafromServer(pageNo: number, pageSize = 10) {
    this.leaveService
      .getManagerSubEmployeeLeaves(pageNo, pageSize)
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

  updateStatus(status: string, leaveId: number) {
    this.leaveService.updateLeaveStatus(status, leaveId)
    .subscribe(response => this.fetchDatafromServer(0))
  }

}
