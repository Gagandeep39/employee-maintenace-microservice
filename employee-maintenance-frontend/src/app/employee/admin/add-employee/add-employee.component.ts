import { Component, OnInit } from '@angular/core';
import { MaritalStatus } from 'src/app/models/marital-status.model';
import { Gender } from 'src/app/models/gender.model';
import { Department } from 'src/app/models/department.model';
import { Manager } from 'src/app/models/manager.model';
import { Grade } from 'src/app/models/grade.model';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { User } from 'src/app/models/user.mode';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from 'src/app/service/employee.service';
import { ValidatorService } from 'src/app/service/validator.service';
import { CustomValidators } from 'src/app/shared/custom-validators';
import { UserDetailsFrom } from 'src/app/models/details-form.model';
import { Designation } from 'src/app/models/designation.model';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css'],
})
export class AddEmployeeComponent implements OnInit {
  submitted = false;
  editMode = false;
  maritalStatus = MaritalStatus;
  genders = Gender;
  departments: Department[] = [];
  managers: Manager[] = [];
  grades: Grade[] = [];
  designations = Designation;

  employeeForm: FormGroup;
  selectedGrade: Grade;

  isLoading = false;
  currentUser: User;
  error = '';

  constructor(
    private employeeService: EmployeeService,
    private router: Router,
    private route: ActivatedRoute,
    private validatorService: ValidatorService
  ) {}

  ngOnInit() {
    this.selectedGrade = new Grade();
    this.employeeForm = new FormGroup({
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      dateOfBirth: new FormControl('', [
        Validators.required,
        CustomValidators.forbiddenAge,
      ]),
      dateOfJoining: new FormControl('', [
        Validators.required,
        CustomValidators.forbidFutureDate,
      ]),
      maritalStatus: new FormControl('', Validators.required),
      gender: new FormControl('', Validators.required),
      department: new FormGroup({
        departmentId: new FormControl('', Validators.required),
      }),
      manager: new FormGroup({
        empDetailsId: new FormControl('', Validators.required),
      }),
      grade: new FormControl('', Validators.required),
      designation: new FormControl('', Validators.required),
      basic: new FormControl('', [
        Validators.required,
        (control: FormControl) =>
          CustomValidators.forbiddenSalary(this.selectedGrade)(control),
      ]),
      phoneNumber: new FormControl('', [
        Validators.required,
        Validators.pattern('[7-9][0-9]{9}'),
      ]),
      email: new FormControl('', [Validators.required, Validators.email]),
      address: new FormGroup({
        state: new FormControl('', Validators.required),
        area: new FormControl('', Validators.required),
        city: new FormControl('', Validators.required),
        pincode: new FormControl('', [
          Validators.required,
          Validators.pattern('[0-9]{6}'),
        ]),
      }),
    });
    this.validatorService.fetchAllDepartments().subscribe((response) => (this.departments = response));
    this.validatorService.fetchAllGrades().subscribe((response) => (this.grades = response));
    this.validatorService.fetchAllManagers().subscribe((response) => this.managers = response);
  }

  submitForm() {
    this.submitted = true;
    if (this.employeeForm.valid) {
      this.saveDataToServer(this.employeeForm.value);
    }
  }

  gradeIsSelected(event) {
    this.selectedGrade = this.grades.find(
      (g) => g.gradeCode === event.target.value
    );
  }

  saveDataToServer(userDetails: UserDetailsFrom) {
    console.log(userDetails);
    
  }

  redirectToHomePage() {
    // this.router.navigate(['../list'], { relativeTo: this.route });
  }

  OnInit() {}
}
