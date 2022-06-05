import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

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
    private snackBar: MatSnackBar) { }
    // <!-- Sifra_interesovanja 578
    // KORISNIK INFO
    // Drzavljanstvo --> Republika Srbija
    // Boraviste --> Republika Srbija
    // Ime --> Ivana
    // Prezime --> Ivanović
    // Pol --> Zenski
    // Datum_rodjenja --> Thu Nov 11 00:00:00 CET 1999
    // Licni dokument --> 1111999815055
    // KONTAKT
    // Broj_mobilnog --> 063560560
    // Broj_fixnog --> 021778777
    // Email --> ivanaa@gmail.com
    // PODACI O VAKCINACIJI
    // Opstina_ustanove --> Novi Sad
    // Tip_vakcine --> SINOPHARM
    // Davalac_krvi --> true
    // Datum_interesovanja --> Wed Dec 01 00:00:00 CET 2021 -->
  ngOnInit(): void {

    this.interestForm = this.formBulder.group({

      drzavljanstvo:["", [Validators.required]],
      boraviste:["", [Validators.required]],
      ime:["", [Validators.required]],
      prezime:["", [Validators.required]],
      pol:["", [Validators.required]],
      datum_rodjenja:["", [Validators.required]],
      licni_dokument:["", [Validators.required]],
      broj_mobilnog:["", [Validators.required]],
      broj_fixnog:["", [Validators.required]],
      email:["", [Validators.email, Validators.required]],
      opstina_ustanove:["", [Validators.required]],
      tip_vakcine:["", [Validators.required]],
      davalac_krvi:["", [Validators.required]],
    })

    //DODATI DATUM INTERESOVANJA i 
    //SIFRU INTERESOVANJA
  }

  createInterest() {
    alert("Kao kreirano")
    this.router.navigate(["/dashboard"]);
  }
}
