/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-05-09 17:30:38
 * @modify date 2020-05-09 17:30:38
 * @desc Root module with all component, modules declaration
 */

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";

import { AppComponent } from './app.component';
import { HomeComponent } from './employees/home/home.component';
import { CreateLeaveComponent } from './employees/create-leave/create-leave.component';
import { ChangePasswordComponent } from './employees/change-password/change-password.component';
import { AddEmployeeComponent } from './admin/add-employee/add-employee.component';
import { EditEmployeeComponent } from './admin/edit-employee/edit-employee.component';
import { ApproveLeaveComponent } from './manager/approve-leave/approve-leave.component';
import { SearchEmployeeComponent } from './employees/search-employee/search-employee.component';
import { ViewLeavesComponent } from './employees/view-leaves/view-leaves.component';
import { LoginComponent } from './login/login.component';
import { AppHeaderComponent } from './shared/app-header/app-header.component';
import { AppFooterComponent } from './shared/app-footer/app-footer.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CreateLeaveComponent,
    ChangePasswordComponent,
    AddEmployeeComponent,
    EditEmployeeComponent,
    ApproveLeaveComponent,
    SearchEmployeeComponent,
    ViewLeavesComponent,
    LoginComponent,
    AppHeaderComponent,
    AppFooterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
