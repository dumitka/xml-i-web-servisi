import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardWorkerComponent } from './dashboard-worker/dashboard-worker.component';
import { DashboardOfficialComponent } from './dashboard-official/dashboard-official.component';
import { LoginComponent } from './login/login.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { AngularMaterialModule } from './angular_material.module'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { VaccinesComponent } from './vaccines/vaccines.component';
import { AppointmentsComponent } from './appointments/appointments.component';
import { ImmunisationComponent } from './immunisation/immunisation.component';
import { ConsentComponent } from './consent/consent.component';


@NgModule({
  declarations: [
    AppComponent,
    DashboardWorkerComponent,
    DashboardOfficialComponent,
    LoginComponent,
    VaccinesComponent,
    AppointmentsComponent,
    ImmunisationComponent,
    ConsentComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NoopAnimationsModule,
    AngularMaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
