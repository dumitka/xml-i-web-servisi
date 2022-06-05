import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
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

  constructor(private formBulder: FormBuilder, 
    // private service: AuthService, 
    private router: Router,
    private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.loginForm = this.formBulder.group({
      username: ["", [Validators.required]],
      password: ["", [Validators.required]]
    });    
  }

  login() {
    if(this.loginForm.value.username === "pera" && this.loginForm.value.password === "pera"){
      this.openSnackBar("Successfully logged in!", this.RESPONSE_OK);
      this.router.navigate(["/dashboard"]);
    } else {
      this.openSnackBar("", this.RESPONSE_ERROR);
    }

    // this.service.login(this.loginForm.value).subscribe(
    //   data => {
    //     this.openSnackBar("Successfully logged in!", this.RESPONSE_OK);
    //     if(this.service.getTokenData()?.role === "ROLE_ADMIN") {
    //       this.router.navigate(["/dashboard"]);
    //     }
    //   },
    //   error => {
    //     console.log(error.error)
    //     this.openSnackBar(error.error, this.RESPONSE_ERROR);
    //   });
  }


  openSnackBar(msg: string, responseCode: number) {
    this.snackBar.open(msg, "x", {
      duration: responseCode === this.RESPONSE_OK ? 3000 : 20000,
      verticalPosition: "top",
      panelClass: responseCode === this.RESPONSE_OK ? "blue" : "red"
    });
  }
}
