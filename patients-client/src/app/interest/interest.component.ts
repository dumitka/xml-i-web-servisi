import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { InterestService } from '../services/interest.service';

@Component({
  selector: 'app-interest',
  templateUrl: './interest.component.html',
  styleUrls: ['./interest.component.css']
})
export class InterestComponent implements OnInit {

  interestForm: FormGroup;
  RESPONSE_OK: number = 0;
  RESPONSE_ERROR: number = -1;

  constructor(private formBulder: FormBuilder, 
    private router: Router,
    private snackBar: MatSnackBar,
    private authService: AuthService,
    private interestService: InterestService) { }

  ngOnInit(): void {
    let currentUser = this.authService.getTokenData().user;
    this.interestForm = this.formBulder.group({

      drzavljanstvo:["", [Validators.required]],
      boraviste:["", [Validators.required]],
      ime:[currentUser.ime, [Validators.required]],
      prezime:[currentUser.prezime, [Validators.required]],
      pol:["Zenski", [Validators.required]],
      datum_rodjenja:["", [Validators.required]],
      licni_dokument:[currentUser.jmbg, [Validators.required ]],  //TODO JMBG ILI PASOS LICNI DOKUMENT PROVERITI
      broj_mobilnog:["", [Validators.required]],                //TODO MOZDA USTANOVA OSTAJE ISTA NA CELOM SISTEMU
      broj_fixnog:["", [Validators.required]],
      email:[currentUser.username, [Validators.email, Validators.required]],
      opstina_ustanove:["", [Validators.required]],
      tip_vakcine:["", [Validators.required]],
      davalac_krvi:["",  [Validators.required]],
    })

    //DODATI DATUM INTERESOVANJA i 
    //SIFRU INTERESOVANJA
  }

  createInterest() {
    
    let sirovo = this.interestForm.value;
    console.log(sirovo)
    sirovo['datum_interesovanja'] = new Date().toISOString().split('T')[0]  //TODO popraviti
    console.log(sirovo['datum_rodjenja'])
    let datum_rodj = new Date(sirovo['datum_rodjenja']);
    sirovo['datum_rodjenja'] = datum_rodj.toISOString().split('T')[0]
    
    this.interestService.createInterest(sirovo).subscribe(
      data => {
        this.openSnackBar("Uspešno ste poslali interesovanje!", this.RESPONSE_OK);
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
