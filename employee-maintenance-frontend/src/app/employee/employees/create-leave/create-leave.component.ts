/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-11 19:07:53
 * @modify date 2020-05-11 19:07:53
 * @desc Create Leave
 */
import { Component, OnInit } from '@angular/core';
import {
  FormGroup,
  FormBuilder,
  Validators,
  FormControl,
} from '@angular/forms';
import { ValidatorService } from 'src/app/service/validator.service';
import { LeaveService } from 'src/app/service/leave.service';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-create-leave',
  templateUrl: './create-leave.component.html',
  styleUrls: ['./create-leave.component.css'],
})
export class CreateLeaveComponent implements OnInit {
  form: FormGroup;
  submitted: boolean = false;
  leaveBalance: number = 13;
  leaveButtonEnabled: boolean = true;

  constructor(private fb: FormBuilder, private leaveService: LeaveService) {
    this.createForm();
  }

  ngOnInit(): void {
    this.leaveService.getLeaveBalance().subscribe(response => this.leaveBalance = response, error => this.leaveButtonEnabled = false)
  }

  createForm() {
    this.form = this.fb.group(
      {
        dateFrom: ['', Validators.required],
        dateTo: ['', Validators.required],
      },
      {
        validator: [
          this.dateLessThan('dateFrom', 'dateTo'),
          this.cannotBePastDate(),
          this.validateBalance(this.leaveBalance),
        ],
      }
    );
  }

  cannotBePastDate() {
    return (control: FormControl) => {
      const dateFrom: Date = control.get('dateFrom').value;
      const from = new Date(dateFrom);
      if (from < new Date())
          control.get('dateFrom').setErrors({ previousDate: true });
      else 
        return null;
    };
  }

  validateBalance(leaveBalance: number) {
    return (control: FormControl) => {
      const from = new Date(control.get('dateFrom').value);
      const to = new Date(control.get('dateTo').value);
      const diff = to.getDate() - from.getDate();
      if (leaveBalance - diff < 0)
        control.get('dateTo').setErrors({ insufficientBalance: true });
      else return null;
    };
  }

  dateLessThan(from: string, to: string) {
    return (group: FormGroup): { [key: string]: any } => {
      let f = group.controls[from];
      let t = group.controls[to];
      if (f.value > t.value) {
        group.controls[to].setErrors({dateToLessThanFrom: true})
      }
      return {};
    };
  }

  onSubmit() {
    this.submitted = true;
    console.log(this.form);
  }
}
