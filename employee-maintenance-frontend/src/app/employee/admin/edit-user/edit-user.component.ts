import { Component, OnInit } from '@angular/core';
import { Role } from 'src/app/models/role.model';
import { ValidatorService } from 'src/app/service/validator.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from 'src/app/service/employee.service';
import { User } from 'src/app/models/user.mode';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css'],
})
export class EditUserComponent implements OnInit {
  submitted = false;
  roles: Role[] = [];
  userEditForm: FormGroup;
  user: User = new User();
  referenceMessage;

  constructor(
    private validatorService: ValidatorService,
    private route: ActivatedRoute,
    private employeeService: EmployeeService,
    private router: Router
  ) {}

  ngOnInit() {
    this.initDropdowns();
    this.initForm();
    if (this.route.snapshot.params['id']) this.initUpdateUser();
  }

  initUpdateUser() {
    let empId = this.route.snapshot.params['id'];
    this.employeeService.findUserById(empId).subscribe((response) => {
      this.user = response;
    });
  }

  onSubmit() {
    this.submitted = true;
    if(this.userEditForm.valid) {
      this.user.role = this.userEditForm.get('role').value;
      this.employeeService.updateUser(this.user).subscribe(
        response => {
          this.referenceMessage = response;
          setTimeout(()=>{
            this.router.navigate(['/employee/home'])
          }, 2000)
        },error => {
          this.referenceMessage = error;
        }
      );
    }
  }

  initDropdowns() {
    this.validatorService
      .fetchAllRoles()
      .subscribe((response) => {
        this.roles = response.filter(role=> role.role != 'ROLE_EMPLOYEE')
      });
  }

  initForm() {
    this.userEditForm = new FormGroup({
      role: new FormGroup({
        roleId: new FormControl('', Validators.required),
      }),
    });
  }
}
