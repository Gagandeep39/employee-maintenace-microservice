import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AccessDeniedComponent } from './access-denied/access-denied.component';
import { SharedRoutingModule } from './shared-routing.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    SharedRoutingModule
  ],
  declarations: [
    HeaderComponent,
    FooterComponent,
    PageNotFoundComponent,
    AccessDeniedComponent
  ],
  exports: [ 
    HeaderComponent,
    FooterComponent,
    PageNotFoundComponent,
    AccessDeniedComponent
  ]
})
export class SharedModule { }
