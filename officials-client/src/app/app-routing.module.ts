import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppointmentsComponent } from './appointments/appointments.component';
import { DashboardOfficialComponent } from './dashboard-official/dashboard-official.component';
import { DashboardWorkerComponent } from './dashboard-worker/dashboard-worker.component';
import { LoginComponent } from './login/login.component';
import { VaccinesComponent } from './vaccines/vaccines.component';
import { ImmunisationComponent } from './immunisation/immunisation.component';
import { ConsentComponent } from './consent/consent.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'dashboardWorker', component: DashboardWorkerComponent},
  {path: 'dashboardOfficial', component: DashboardOfficialComponent},
  {path: 'vaccines', component: VaccinesComponent},
  {path: 'appointments', component: AppointmentsComponent},
  {path: 'immunisation', component: ImmunisationComponent},
  {path: 'consent', component: ConsentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
