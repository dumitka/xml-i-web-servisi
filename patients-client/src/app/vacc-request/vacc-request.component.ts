import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-vacc-request',
  templateUrl: './vacc-request.component.html',
  styleUrls: ['./vacc-request.component.css']
})
export class VaccRequestComponent implements OnInit {

  interestForm: FormGroup;
  RESPONSE_OK: number = 0;
  RESPONSE_ERROR: number = -1;

  constructor(private formBulder: FormBuilder, 
    private router: Router,
    private snackBar: MatSnackBar,
    private authService: AuthService) { }

  ngOnInit(): void {
    let currentUser = this.authService.getTokenData().user;
    this.interestForm = this.formBulder.group({

      drzavljanstvo:["", [Validators.required]],
      boraviste:["", [Validators.required]],
      ime:[currentUser.ime, [Validators.required]],
      prezime:[currentUser.prezime, [Validators.required]],
      pol:["", [Validators.required]],
      datum_rodjenja:["", [Validators.required]],
      licni_dokument:[currentUser.jmbg, [Validators.required]],
      broj_mobilnog:["", [Validators.required]],
      broj_fixnog:["", [Validators.required]],
      email:[currentUser.username, [Validators.email, Validators.required]],
      opstina_ustanove:["", [Validators.required]],
      tip_vakcine:[""],
      davalac_krvi:[""],
    })


    
    // this.interestForm.controls['ime'].setValue(currentUser.ime);
    // this.interestForm.controls['ime'].disable();
    // this.interestForm.controls['prezime'].setValue(currentUser.prezime);
    // this.interestForm.controls['prezime'].disable();
    // this.interestForm.controls['email'].setValue(currentUser.username);
    // this.interestForm.controls['email'].disable();
    // this.interestForm.controls['licni_dokument'].setValue(currentUser.jmbg);
    // this.interestForm.controls['licni_dokument'].disable();
    //DODATI DATUM INTERESOVANJA i 
    //SIFRU INTERESOVANJA
  }

  createInterest() {
    // getRawValue
    alert("Kao kreirano")
    this.router.navigate(["/dashboard"]);
  }
}
