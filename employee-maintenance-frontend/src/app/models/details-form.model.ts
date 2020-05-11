import { MaritalStatus } from './marital-status.model';
import { Gender } from './gender.model';
import { Department } from './department.model';
import { Grade } from './grade.model';
import { Address } from 'cluster';
import { ManagerDetailsForm } from './manager-form.model';

export class UserDetailsFrom {
        firstName: string;
        lastName: string;
        dateOfBirth: Date;
        dateOfJoining: Date;
        maritalStatus: MaritalStatus;
        gender: Gender;
        department: Department
        manager: ManagerDetailsForm;
        grade: Grade;
        designation: string;
        basic: number;
        phoneNumber: string;
        email: string;
        address: Address;
}