import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ConsentServiceService } from '../services/consent-service.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-consent',
  templateUrl: './consent.component.html',
  styleUrls: ['./consent.component.css']
})
export class ConsentComponent implements OnInit {

  consentForm: FormGroup;
  RESPONSE_OK: number = 0;
  RESPONSE_ERROR: number = -1;

  constructor(private router: Router, private authService: AuthService, private fb: FormBuilder,
    private service:ConsentServiceService, private snackBar: MatSnackBar) { 

    this.createForm();
  }


  ngOnInit(): void {
  }

  createForm() {
    this.consentForm = this.fb.group({
      citizenship: ["",[Validators.required, Validators.pattern('[A-Za-zšđžćčŠĐŽĆČ ]*')]],//
      jmbg: ["", [Validators.maxLength(13), Validators.maxLength(13), Validators.pattern('[0-9]*')]], //
      passport: ["", [Validators.maxLength(9), Validators.maxLength(9), Validators.pattern('[0-9]*')]],//
      name: ["", [Validators.required, Validators.pattern('[A-Za-zšđžćčŠĐŽĆČ ]*')]],//
      parentName: ["", [Validators.required, Validators.pattern('[A-Za-zšđžćčŠĐŽĆČ ]*')]],//
      lastName:["",[Validators.required, Validators.pattern('[A-Za-zšđžćčŠĐŽĆČ ]*')]],//
      gender: ["", Validators.required],//
      dateOfBirth: ["", Validators.required],//
      placeOfBirth: ["", Validators.required],//

      township: ["",[Validators.required, Validators.pattern('[A-Za-zšđžćčŠĐŽĆČ ]*')]],//
      livingPlace: ["", [Validators.required, Validators.pattern('[A-Za-zšđžćčŠĐŽĆČ ]*')]],
      street: ["",  [Validators.required, Validators.pattern('[A-Za-zšđžćčŠĐŽĆČ ]*')]],
      number: ["", [Validators.required, Validators.pattern('[0-9]*')]],//
      email: ["", Validators.required],//
      phone:["",[Validators.required, Validators.pattern('[0-9]*')]],//
      fiksni: ["", [Validators.required, Validators.pattern('[0-9]*')]],
      radni_status: ["", Validators.required],//
      zanimanje_zaposlenog: ["", Validators.required],//
      socijalno: ["", Validators.required],//

      saglasnost: ["", Validators.required],
      vakcina: ["", Validators.required],
      dateOfConsent: ["", Validators.required]
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
    let raw = this.consentForm.value
    console.log(this.consentForm.value)
    this.consentForm.value.citizenship

    if(this.consentForm.value.citizenship == "Srbija" || this.consentForm.value.citizenship == "Republika Srbija"){
      if(this.consentForm.value.jmbg == "" && this.consentForm.value.passport == ""){
        //opucaj gresku
        this.openSnackBar("Molim unesite Vaš JMBG ili broj Vašeg pasoša.", this.RESPONSE_ERROR);
      }else if(this.consentForm.value.jmbg != ""){
        //drzavlajnin sa jmbg
        console.log("Drzavljanin Srbije, sa jmbg")
        
        this.service.createConsent(raw, false).subscribe(
          data => {
            this.openSnackBar("Saglasnost je uspešno poslana!", this.RESPONSE_OK);
            this.router.navigate(["/dashboard"]);
          },
          error => {
            console.log(error.error)
            this.openSnackBar(error.error, this.RESPONSE_ERROR);
          }
        )
      }else{
        //drzavlajnin sa pasosem
        console.log("Drzavljanin Srbije, sa pasosem")
        
        this.service.createConsent(raw, true).subscribe(
          data => {
            this.openSnackBar("Saglasnost je uspešno poslana!", this.RESPONSE_OK);
            this.router.navigate(["/dashboard"]);
          },
          error => {
            console.log(error.error)
            this.openSnackBar(error.error, this.RESPONSE_ERROR);
          }
        )
      }
    }else{
      //stranac
      if(this.consentForm.value.passport == ""){
        this.openSnackBar("Molim unesite broj Vašeg pasoša.", this.RESPONSE_ERROR);
      }else{
        //pozovi onu sa pasose = true
        console.log("Nije drzavljanin Srbije pasos")
        
        this.service.createConsent(raw, true).subscribe(
          data => {
            this.openSnackBar("Saglasnost je uspešno poslana!", this.RESPONSE_OK);
            this.router.navigate(["/dashboard"]);
          },
          error => {
            console.log(error.error)
            this.openSnackBar(error.error, this.RESPONSE_ERROR);
          }
        )
        
      }

    }
  }


  openSnackBar(msg: string, responseCode: number) {
    this.snackBar.open(msg, "x", {
      duration: responseCode === this.RESPONSE_OK ? 3000 : 20000,
      verticalPosition: "top",
      panelClass: responseCode === this.RESPONSE_OK ? "blue" : "red"
    });
  }

}
