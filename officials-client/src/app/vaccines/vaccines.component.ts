import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { VaccService } from '../services/vacc.service';

@Component({
  selector: 'app-vaccines',
  templateUrl: './vaccines.component.html',
  styleUrls: ['./vaccines.component.css']
})
export class VaccinesComponent implements OnInit {

  RESPONSE_OK: number = 0;
  RESPONSE_ERROR: number = -1;

  sinopharmCount: number = 0;
  addSinopharm = new FormControl('');

  astraCount:  number = 0;
  addAstra= new FormControl('');

  sputnikCount: number = 0;
  addSputnik= new FormControl('');

  pfizerCount: number = 0;
  addPfizer= new FormControl('');

  modernaCount: number = 0;
  addModerna= new FormControl('');

  constructor(private router: Router, private authService: AuthService,
    private formBuilder: FormBuilder, 
    private snackBar: MatSnackBar,
    private vaccService: VaccService) { }

  ngOnInit(): void {

    this.refreshData()
    
  }

  refreshData() {
    this.vaccService.getAll().subscribe(
      data => {
        this.openSnackBar("Uspesno fecovali sve zive hehe", this.RESPONSE_OK);
        this.pfizerCount = this.getCount("Pfizer-BioNTech", data);
        this.modernaCount = this.getCount("Moderna", data);
        this.astraCount = this.getCount("AstraZeneca", data);
        this.sputnikCount = this.getCount("Sputnik-V", data);
        this.sinopharmCount = this.getCount("Sinopharm", data);
      }
    )
  }

  getCount(name, data) {
    console.log("EVO U KAUNTU SMO")
    console.log(name, data)
    for(const vacc of data) {
      if(vacc.naziv === name) {
        console.log("Nasli")
        return vacc.slobodnih
      }
    }
    return null;
  }

  sendPfizer() {
    this.vaccService.dodajNove({name: "Pfizer-BioNTech", kolicina: this.addPfizer.value}).subscribe(
      data => {
        this.openSnackBar("Uspešno ažurirana količina!", this.RESPONSE_OK);
        this.addPfizer.setValue(0);
        this.refreshData();
      },
      error => {
        console.log(error.error)
        this.openSnackBar(error.error, this.RESPONSE_ERROR);
      }
    )
  }

  sendSinopharm() {
    this.vaccService.dodajNove({name: "Sinopharm", kolicina: this.addSinopharm.value}).subscribe(
      data => {
        this.openSnackBar("Uspešno ažurirana količina!", this.RESPONSE_OK);
        this.addSinopharm.setValue(0);
        this.refreshData();
      },
      error => {
        console.log(error.error)
        this.openSnackBar(error.error, this.RESPONSE_ERROR);
      }
    )
  }

  sendAstra() {
    this.vaccService.dodajNove({name: "AstraZeneca", kolicina: this.addAstra.value}).subscribe(
      data => {
        this.openSnackBar("Uspešno ažurirana količina!", this.RESPONSE_OK);
        this.addAstra.setValue(0);
        this.refreshData();
      },
      error => {
        console.log(error.error)
        this.openSnackBar(error.error, this.RESPONSE_ERROR);
      }
    )
  }

  sendModerna() {
    this.vaccService.dodajNove({name: "Moderna", kolicina: this.addModerna.value}).subscribe(
      data => {
        this.openSnackBar("Uspešno ažurirana količina!", this.RESPONSE_OK);
        this.addModerna.setValue(0);
        this.refreshData();
      },
      error => {
        console.log(error.error)
        this.openSnackBar(error.error, this.RESPONSE_ERROR);
      }
    )
  }

  sendSputnik(){
    this.vaccService.dodajNove({name: "Sputnik-V", kolicina: this.addSputnik.value}).subscribe(
      data => {
        this.openSnackBar("Uspešno ažurirana količina!", this.RESPONSE_OK);
        this.addSputnik.setValue(0);
        this.refreshData();
      },
      error => {
        console.log(error.error)
        this.openSnackBar(error.error, this.RESPONSE_ERROR);
      }
    )
  }

  logout() {
    this.authService.logout();
    this.router.navigate(["/"])
  }

  openSnackBar(msg: string, responseCode: number) {
    this.snackBar.open(msg, "x", {
      duration: responseCode === this.RESPONSE_OK ? 3000 : 20000,
      verticalPosition: "top",
      panelClass: responseCode === this.RESPONSE_OK ? "blue" : "red"
    });
  }
}
