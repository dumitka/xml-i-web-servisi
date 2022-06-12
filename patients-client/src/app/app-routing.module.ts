import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
//import { VaccRequestComponent } from '/vacc-request/vacc-request.component';
import { GreenSerRequestComponent } from './green-ser-request/green-ser-request.component';
import { InterestComponent } from './interest/interest.component';
import { ConsentComponent } from './consent/consent.component';


const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'interest', component: InterestComponent},
  {path: 'adminDashboard', component: AdminDashboardComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'greenSerRequest', component: GreenSerRequestComponent},
  {path: 'consent', component: ConsentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
