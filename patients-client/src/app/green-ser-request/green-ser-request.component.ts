import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { GreenSerRequestServiceService } from '../services/green-ser-request-service.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-green-ser-request',
  templateUrl: './green-ser-request.component.html',
  styleUrls: ['./green-ser-request.component.css']
})
export class GreenSerRequestComponent implements OnInit {
  requestDataForm: FormGroup;
  RESPONSE_OK: number = 0;
  RESPONSE_ERROR: number = -1;

  constructor(private router: Router, private authService: AuthService, 
              private fb: FormBuilder, private service:GreenSerRequestServiceService,
              private snackBar: MatSnackBar,) { 
    this.createForm();
  }

  ngOnInit(): void {
}


createForm() {
  this.requestDataForm = this.fb.group({
    name: ["",[Validators.required, Validators.pattern('[A-Za-zšđžćčŠĐŽĆČ]*')]],
    lastName: ["", [Validators.required, Validators.pattern('[A-Za-zšđžćčŠĐŽĆČ]*')]],
    dateOfBirth: ["", Validators.required],
    gender: ["", Validators.required],
    jmbg: ["", [Validators.required, Validators.maxLength(13), Validators.maxLength(13), Validators.pattern('[0-9]*')]],
    passport:["",[Validators.required, Validators.maxLength(9), Validators.maxLength(9), Validators.pattern('[0-9]*')]],
    reason: ["", Validators.required],
    date: ["", Validators.required],
    place: ["", Validators.required],
  })
}

  profile(){
    this.router.navigate(["/dashboard"])
  }

  logout() {
    this.authService.logout();
    this.router.navigate(["/"])
  }


  onSubmit(){
    console.log(this.requestDataForm.value)

    let raw = this.requestDataForm.value

    this.service.createRequest(raw).subscribe(
      data => {
        this.openSnackBar("Zahtev za zeleni sertifikat je uspešno poslan!", this.RESPONSE_OK);
        this.router.navigate(["/dashboard"]);
      },
      error => {
        console.log(error.error)
        this.openSnackBar(error.error, this.RESPONSE_ERROR);
      }
    )
  }

  openSnackBar(msg: string, responseCode: number) {
    this.snackBar.open(msg, "x", {
      duration: responseCode === this.RESPONSE_OK ? 3000 : 20000,
      verticalPosition: "top",
      panelClass: responseCode === this.RESPONSE_OK ? "blue" : "red"
    });
  }

}
