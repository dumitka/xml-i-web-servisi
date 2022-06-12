import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-dashboard-official',
  templateUrl: './dashboard-official.component.html',
  styleUrls: ['./dashboard-official.component.css']
})
export class DashboardOfficialComponent implements OnInit {

  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit(): void {
  }

  termini() {
    this.router.navigate(["/appointments"]);
  }

  vakcine() {
    this.router.navigate(["/vaccines"]);
  }

  logout() {
    this.authService.logout();
    this.router.navigate(["/"])
  }

  imunizacija(){
    this.router.navigate(["/immunisation"])
  }
}
