import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-dashboard-official',
  templateUrl: './dashboard-official.component.html',
  styleUrls: ['./dashboard-official.component.css']
})
export class DashboardOfficialComponent implements OnInit {

  constructor(private router: Router, private authService: AuthService, private http: HttpClient,) { }

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

  generisi() {
    alert("Uslo");
    this.http.get("http://localhost:8081/api/xhtml/")
    .pipe(map((data) => {},)).subscribe(data => {
      alert("Uspesno generisanje HTML-ova i PDF-ova!");
    });
  }
}
