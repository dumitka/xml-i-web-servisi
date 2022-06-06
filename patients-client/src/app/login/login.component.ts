import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { Observable } from 'rxjs';
// import { AuthService } from '../services/auth.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  hide = true;
  loginForm: FormGroup;
  RESPONSE_OK: number = 0;
  RESPONSE_ERROR: number = -1;

  constructor(private formBuilder: FormBuilder, 
    private service: AuthService, 
    private router: Router,
    private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: ["", [Validators.required]],
      password: ["", [Validators.required]]
    });    
  }

  login() {
    this.service.login(this.loginForm.value).subscribe(
      data => {
        this.openSnackBar("Uspešno ste ulogovani!", this.RESPONSE_OK);
        if(this.service.getTokenData()?.role === "ROLE_USER") {
          this.router.navigate(["/dashboard"]);
        } else if (this.service.getTokenData()?.role === "ROLE_ADMIN"){
          this.router.navigate(["/adminDashboard"]);
        }
      },
      error => {
        console.log(error.error)
        this.openSnackBar(error.error, this.RESPONSE_ERROR);
      }
    )
  }

  signupPage() {
    this.router.navigate(["/register"])
  }

  openSnackBar(msg: string, responseCode: number) {
    this.snackBar.open(msg, "x", {
      duration: responseCode === this.RESPONSE_OK ? 3000 : 20000,
      verticalPosition: "top",
      panelClass: responseCode === this.RESPONSE_OK ? "blue" : "red"
    });
  }
}
