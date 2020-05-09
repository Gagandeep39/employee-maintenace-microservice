/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-09 17:35:44
 * @modify date 2020-05-09 17:35:44
 * @desc To declar all routes for the application
 */

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from "@angular/router";
import { LoginComponent } from './login/login.component';
import { SearchEmployeeComponent } from './employees/search-employee/search-employee.component';
import { ViewLeavesComponent } from './employees/view-leaves/view-leaves.component';
import { HomeComponent } from './employees/home/home.component';
import { CreateLeaveComponent } from './employees/create-leave/create-leave.component';
import { ChangePasswordComponent } from './employees/change-password/change-password.component';
import { AddEmployeeComponent } from './admin/add-employee/add-employee.component';
import { EditEmployeeComponent } from './admin/edit-employee/edit-employee.component';
import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import { ApproveLeaveComponent } from './manager/approve-leave/approve-leave.component';
import { PageNotFoundComponent } from './shared/page-not-found/page-not-found.component';
import { AccessDeniedComponent } from './shared/access-denied/access-denied.component';



const routes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'employees/search', component: SearchEmployeeComponent },
    { path: 'employees/leaves', component: ViewLeavesComponent },
    { path: 'employee/home', component: HomeComponent },
    { path: 'employee/addleave', component: CreateLeaveComponent },
    { path: 'employee/change', component: ChangePasswordComponent },
    { path: 'admin/add', component: AddEmployeeComponent },
    { path: 'admin/edit', component: EditEmployeeComponent },
    { path: 'manager/approve', component: ApproveLeaveComponent },
    { path: 'header', component: HeaderComponent },
    { path: 'footer', component: FooterComponent },
    { path: 'error/404', component: PageNotFoundComponent },
    { path: 'error/403', component: AccessDeniedComponent },
    { path: '**', redirectTo: 'error/404' }
]

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule {}
