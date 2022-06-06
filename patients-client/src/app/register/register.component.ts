import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { Observable } from 'rxjs';
import { AbstractControl } from '@angular/forms';
import { ValidationErrors } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  hide = true;
  regForm: FormGroup;
  RESPONSE_OK: number = 0;
  RESPONSE_ERROR: number = -1;

  constructor(private formBuilder: FormBuilder, 
    private service: AuthService, 
    private router: Router,
    private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.regForm = this.formBuilder.group({
      username: ["", [Validators.required, Validators.email]],
      password: ["", [Validators.required]],
      repeatPassword: ["", [Validators.required]],
      jmbg: ["", [Validators.pattern('^[0-9]{13}$'), Validators.required]],
      ime: ["", [Validators.required]],
      prezime: ["", [Validators.required]],
    }, {validator: this.matchPassword})
  }

  register() {
    let signupData = this.regForm.value;
    delete signupData.repeatPassword;

    this.service.signup(signupData).subscribe(
      data => {
        this.openSnackBar("Uspešno ste registrovani!", this.RESPONSE_OK);
        this.router.navigate(["/"]);
      },
      error => {
        console.log(error.error)
        this.openSnackBar(error.error, this.RESPONSE_ERROR);
      }
    )
  }

  loginPage() {
    this.router.navigate(["/"])
  }

  matchPassword(control: AbstractControl): ValidationErrors | null {
    const password = control.get("password").value;
    const confirm = control.get("repeatPassword").value;
 
    if (password != confirm) { return { 'noMatch': true } }
    return null
  }

  openSnackBar(msg: string, responseCode: number) {
    this.snackBar.open(msg, "x", {
      duration: responseCode === this.RESPONSE_OK ? 3000 : 20000,
      verticalPosition: "top",
      panelClass: responseCode === this.RESPONSE_OK ? "blue" : "red"
    });
  }

}