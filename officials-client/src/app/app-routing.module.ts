import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardOfficialComponent } from './dashboard-official/dashboard-official.component';
import { DashboardWorkerComponent } from './dashboard-worker/dashboard-worker.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'dashboardWorker', component: DashboardWorkerComponent},
  {path: 'dashboardOfficial', component: DashboardOfficialComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
