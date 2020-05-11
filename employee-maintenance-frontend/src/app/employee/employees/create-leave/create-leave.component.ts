import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-create-leave',
  templateUrl: './create-leave.component.html',
  styleUrls: ['./create-leave.component.css']
})
export class CreateLeaveComponent implements OnInit {

  form: FormGroup;
  previousDateForbidden = false;
  submitted = false;
  leaveBalance: boolean = false;
  applyLeave: boolean = true;
  fromDate = new Date();
  toDate = new Date();
  days: any;
  todateSec: any;
  fromdateSec: any;
  millisecondsPerDay: any;
  diff: any;
  weeks: any;
  leaveDays :any;
  availableLeaveBalance = 13;

  constructor(private fb: FormBuilder)
  {

  }
  ngOnInit() {
    this.form = this.fb.group({
      fromDate : new FormControl('', Validators.required),
      toDate : new FormControl('', Validators.required)
    }, {validator: this.validateLeaveDays});
}

validateLeaveDays()
{
if(this.leaveDays> this.availableLeaveBalance)
return "You don't have enough leave balance"
}
  onKeyUpfromdate(event: any) {
    this.fromDate = event.target.value;
    console.log(this.fromDate);
    this.todateSec = new Date(this.toDate);
    this.fromdateSec = new Date(this.fromDate);

    // Calculate days between dates
    this.millisecondsPerDay = 86400 * 1000; // Day in milliseconds
    this.fromdateSec.setHours(0, 0, 0, 1); // Start just after midnight
    this.todateSec.setHours(23, 59, 59, 999); // End just before midnight
    this.diff = this.todateSec - this.fromdateSec; // Milliseconds between datetime objects 
    this.days = Math.ceil(this.diff / this.millisecondsPerDay);

    // Subtract two weekend days for every week in between
    this.weeks = Math.floor(this.days / 7);
    this.days = this.days - (this.weeks * 2);

    // Handle special cases
    this.fromdateSec = this.fromdateSec.getDay();
    this.todateSec = this.todateSec.getDay();

    // Remove weekend not previously removed. 
    if (this.fromdateSec - this.todateSec > 1)
      this.days = this.days - 2;

    // Remove start day if span starts on Sunday but ends before Saturday
    if (this.fromdateSec == 0 && this.todateSec != 6)
      this.days = this.days - 1;

    // Remove end day if span ends on Saturday but starts after Sunday
    if (this.todateSec == 6 && this.fromdateSec != 0) {
      this.days = this.days - 1;
    }
    this.leaveDays = this.days;
    if (this.leaveDays == 'NaN' || this.leaveDays == '' || this.leaveDays <= '0' || this.leaveDays == 'undefined') {
      this.leaveDays = '';
    } else {
      this.leaveDays = this.days;
    }


  }

  onKeyUptoDate(event: any) {
    this.toDate = event.target.value;
    console.log(this.toDate);
    
    this.todateSec = new Date(this.toDate);
    this.fromdateSec = new Date(this.fromDate);

    if (this.todateSec < this.fromdateSec)
      alert('To date must be greater than from date!');

    // Calculate days between dates
    this.millisecondsPerDay = 86400 * 1000; // Day in milliseconds
    this.fromdateSec.setHours(0, 0, 0, 1); // Start just after midnight
    this.todateSec.setHours(23, 59, 59, 999); // End just before midnight
    this.diff = this.todateSec - this.fromdateSec; // Milliseconds between datetime objects 
    this.days = Math.ceil(this.diff / this.millisecondsPerDay);

    // Subtract two weekend days for every week in between
    this.weeks = Math.floor(this.days / 7);
    this.days = this.days - (this.weeks * 2);

    // Handle special cases
    this.fromdateSec = this.fromdateSec.getDay();
    this.todateSec = this.todateSec.getDay();

    // Remove weekend not previously removed. 
    if (this.fromdateSec - this.todateSec > 1)
      this.days = this.days - 2;

    // Remove start day if span starts on Sunday but ends before Saturday
    if (this.fromdateSec == 0 && this.todateSec != 6)
      this.days = this.days - 1;

    // Remove end day if span ends on Saturday but starts after Sunday
    if (this.todateSec === 6 && this.fromdateSec !== 0) {
      this.days = this.days - 1;
    }
    this.leaveDays = this.days;
    if (this.leaveDays === 'NaN' || this.leaveDays === '' || this.leaveDays <= '0' || this.leaveDays == 'undefined') {
      this.leaveDays = '';
    } else {
      this.leaveDays = this.days;
    }

  }
  submitForm()
  {
    this.submitted= true;
  }
}