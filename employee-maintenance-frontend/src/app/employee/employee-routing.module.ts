/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-09 17:35:44
 * @modify date 2020-05-09 17:35:44
 * @desc To declar all Employee Routes
 */

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from "@angular/router";
import { SearchEmployeeComponent } from './employees/search-employee/search-employee.component';
import { ViewLeavesComponent } from './employees/view-leaves/view-leaves.component';
import { HomeComponent } from './employees/home/home.component';
import { CreateLeaveComponent } from './employees/create-leave/create-leave.component';
import { ChangePasswordComponent } from './employees/change-password/change-password.component';
import { AddEmployeeComponent } from './admin/add-employee/add-employee.component';
import { EditEmployeeComponent } from './admin/edit-employee/edit-employee.component';
import { ApproveLeaveComponent } from './manager/approve-leave/approve-leave.component';
import { EmployeeComponent } from './employee.component';
import { AddUserComponent } from './admin/add-user/add-user.component';



const routes: Routes = [
    {
        path: 'employee', component: EmployeeComponent, children: [
            { path: '', redirectTo: 'home', pathMatch: 'full' },
            { path: 'search', component: SearchEmployeeComponent },
            { path: 'leaves', component: ViewLeavesComponent },
            { path: 'home', component: HomeComponent },
            { path: 'details/:id', component: HomeComponent },
            { path: 'addleave', component: CreateLeaveComponent },
            { path: 'change', component: ChangePasswordComponent },
            { path: 'admin/adduser', component: AddUserComponent },
            { path: 'admin/addemp', component: AddEmployeeComponent },
            { path: 'admin/edit', component: EditEmployeeComponent },
            { path: 'manager/approve', component: ApproveLeaveComponent },
        ]
    },
    { path: '**', redirectTo: 'error/404' }
]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})

export class EmployeeRoutingModule {}
