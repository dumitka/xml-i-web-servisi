import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit(): void {
  }

  createInterest() {
    this.router.navigate(["/interest"])
  }

  createRequestGreenSer(){
    this.router.navigate(["/greenSerRequest"])
  }

  createConsent(){
    this.router.navigate(["/consent"])
  }

  logout() {
    this.authService.logout();
    this.router.navigate(["/"])
  }

}
