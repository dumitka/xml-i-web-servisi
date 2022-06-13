import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ConsentServiceService } from '../services/consent-service.service'
import { VaccService } from '../services/vacc.service';
@Component({
  selector: 'app-consent',
  templateUrl: './consent.component.html',
  styleUrls: ['./consent.component.css']
})
export class ConsentComponent implements OnInit {

  consent:any;

  consentForm: FormGroup;

  RESPONSE_OK: number = 0;
  RESPONSE_ERROR: number = -1;

  constructor(private router: Router, private authService: AuthService, private fb: FormBuilder, private snackBar: MatSnackBar,
     private service:ConsentServiceService, private vaccService: VaccService) {
    this.consent = history.state.data.conset;
    this.createForm();

    console.log(this.consent)
  }

  createForm() {
    this.consentForm = this.fb.group({
      zdravstvena_ustanova: [this.consent.Deo_za_radnika.Zdravstvena_ustanova, Validators.required],//
      vakcinacijski_punkt: [this.consent.Deo_za_radnika.Vakcinacijski_punkt, Validators.required],//
      podaci_o_ljekaru: [this.consent.Deo_za_radnika.Podaci_o_lekaru,[Validators.required]],//

      naziv_vakcine1: [this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[0].Naziv_vakcine],//
      proizvodjac1: [this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[0].Proizvodjac ],//
      serija_vakcine1:[this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[0].Serija_vakcine],//
      ekstremitet1: [this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[0].Ekstremitet ], //
      nacin_davanja_vakcine1: [this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[0].Nacin_davanja_vakcine],//
      datum_davanja_vakcine1:[""],

      naziv_vakcine2: [this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[1].Naziv_vakcine],//
      proizvodjac2: [this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[1].Proizvodjac],//
      serija_vakcine2:[this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[1].Serija_vakcine],//
      ekstremitet2: [this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[1].Ekstremitet], //
      nacin_davanja_vakcine2: [this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[1].Nacin_davanja_vakcine],//
      datum_davanja_vakcine2:[""],

      naziv_vakcine3: [this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[2].Naziv_vakcine],//
      proizvodjac3: [this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[2].Proizvodjac],//
      serija_vakcine3:[this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[2].Serija_vakcine],//
      ekstremitet3: [this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[2].Ekstremitet], //
      nacin_davanja_vakcine3: [this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[2].Nacin_davanja_vakcine],//
      datum_davanja_vakcine3:[""]
    })
  }

  ngOnInit(): void {
  }

  profile(){
    this.router.navigate(["/dashboard"])
  }

  logout() {
    this.authService.logout();
    this.router.navigate(["/"])
  }

  onSubmit(){
    this.consent.Deo_za_radnika.Zdravstvena_ustanova = this.consentForm.value.zdravstvena_ustanova;
    this.consent.Deo_za_radnika.Vakcinacijski_punkt = this.consentForm.value.vakcinacijski_punkt;
    this.consent.Deo_za_radnika.Podaci_o_lekaru = this.consentForm.value.podaci_o_ljekaru;

    this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[0].Naziv_vakcine = this.consentForm.value.naziv_vakcine1;
    this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[0].Proizvodjac = this.consentForm.value.proizvodjac1;
    this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[0].Serija_vakcine = this.consentForm.value.serija_vakcine1;
    this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[0].Ekstremitet = this.consentForm.value.ekstremitet1;
    this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[0].Nacin_davanja_vakcine = this.consentForm.value.nacin_davanja_vakcine1;
    this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[0].Datum_davanja_vakcine = this.consentForm.value.datum_davanja_vakcine1;

    this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[1].Naziv_vakcine = this.consentForm.value.naziv_vakcine2;
    this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[1].Proizvodjac = this.consentForm.value.proizvodjac2;
    this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[1].Serija_vakcine = this.consentForm.value.serija_vakcine2;
    this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[1].Ekstremitet = this.consentForm.value.ekstremitet2;
    this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[1].Nacin_davanja_vakcine = this.consentForm.value.nacin_davanja_vakcine2;
    this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[1].Datum_davanja_vakcine = this.consentForm.value.datum_davanja_vakcine2;

    this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[2].Naziv_vakcine = this.consentForm.value.naziv_vakcine3;
    this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[2].Proizvodjac = this.consentForm.value.proizvodjac3;
    this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[2].Serija_vakcine = this.consentForm.value.serija_vakcine3;
    this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[2].Ekstremitet = this.consentForm.value.ekstremitet3;
    this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[2].Nacin_davanja_vakcine = this.consentForm.value.nacin_davanja_vakcine3;
    this.consent.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[2].Datum_davanja_vakcine = this.consentForm.value.datum_davanja_vakcine3;

  
    
    
   


    if(this.consentForm.value.naziv_vakcine3 != ""){
      this.vaccService.dodajNove({name: this.consentForm.value.naziv_vakcine3, kolicina: 1}).subscribe(
        data => {
          this.openSnackBar("Uspešno ažurirana količina!", this.RESPONSE_OK);
        },
        error => {
          console.log(error.error)
          this.openSnackBar(error.error, this.RESPONSE_ERROR);
        }
      )
    }else if(this.consentForm.value.naziv_vakcine2 != ""){
      this.vaccService.dodajNove({name: this.consentForm.value.naziv_vakcine2, kolicina: 1}).subscribe(
        data => {
          this.openSnackBar("Uspešno ažurirana količina!", this.RESPONSE_OK);

        },
        error => {
          console.log(error.error)
          this.openSnackBar(error.error, this.RESPONSE_ERROR);
        }
      )
    }else if(this.consentForm.value.naziv_vakcine1 != ""){
      this.vaccService.dodajNove({name: this.consentForm.value.naziv_vakcine1, kolicina: 1}).subscribe(
        data => {
          this.openSnackBar("Uspešno ažurirana količina!", this.RESPONSE_OK);
        },
        error => {
          console.log(error.error)
          this.openSnackBar(error.error, this.RESPONSE_ERROR);
        }
      )
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
