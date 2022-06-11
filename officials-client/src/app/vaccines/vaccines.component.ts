import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
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

  sinopharmCount:  number =0;
  astraCount:  number =0;
  sputnikCount: number = 0;
  pfizerCount: number = 0;
  modernaCount: number = 0;
  

  constructor(private router: Router, private authService: AuthService,
    private formBuilder: FormBuilder, 
    private snackBar: MatSnackBar,
    private vaccService: VaccService) { }

  ngOnInit(): void {

    this.refreshData()
    


    // form ctrl pfizerCount: [""], 
    
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
