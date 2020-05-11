/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-11 02:08:08
 * @modify date 2020-05-11 02:08:08
 * @desc [description]
 */
import {
  FormControl,
  ValidatorFn,
  AsyncValidatorFn,
  ValidationErrors,
} from '@angular/forms';
import { Observable } from 'rxjs';
import { map, take } from 'rxjs/operators';
import { ValidatorService } from '../service/validator.service';
import { Grade } from '../models/grade.model';

export class CustomValidators {
  static forbiddenAge(control: FormControl) {
    const dob = new Date(control.value);
    const today = new Date();
    const diff = today.getFullYear() - dob.getFullYear();

    if (diff < 18 || diff > 58) {
      return { ageIsForbidden: true };
    }
    return null;
  }

  static forbidFutureDate(control: FormControl) {
    const dob = new Date(control.value);
    if (dob > new Date()) {
      return { futureDateForbidden: true };
    }
    return null;
  }

  static forbiddenSalary(grade: Grade): ValidatorFn {
    return (control: FormControl): ValidationErrors | null => {
      const currentSal = +control.value;
      if (currentSal < grade.minSalary || currentSal > grade.maxSalary) {
        return { salaryIsForbidden: true };
      }
      return null;
    };
  }

  static matchPassword(control: FormControl) {
    const password = control.get('password').value;
    const confirmPassword = control.get('confirmPassword').value;
    if (password != confirmPassword) {
      control.get('confirmPassword').setErrors({ passwordMatchError: true });
    } else {
      return null;
    }
  }

  static usernameValidator(service: ValidatorService) {
    return (control: FormControl) => {
      return service
        .validateUser(control.value)
        .pipe(map((response) => (response ? null : { usernameTaken: true })));
    };
  }
}
