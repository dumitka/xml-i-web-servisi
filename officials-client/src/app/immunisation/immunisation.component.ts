import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ConsentServiceService } from '../services/consent-service.service';

@Component({
  selector: 'app-immunisation',
  templateUrl: './immunisation.component.html',
  styleUrls: ['./immunisation.component.css']
})
export class ImmunisationComponent implements OnInit {

  dataSource:any;
  displayedColumns: string[] = ['No.', 'Datum', 'Ime', 'Prezime', 'Vakcina', 'button'];

  constructor(private router: Router, private authService: AuthService,
    private formBuilder: FormBuilder, 
    private snackBar: MatSnackBar,
    private service: ConsentServiceService) { 
      
      this.getAll();
      
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

  


  getAll() {
    this.service.getAll().subscribe(
      data => {
        console.log("Taca")
        console.log(data)
        console.log("Taca odjava")

        //console.log(data.Deo_za_pacijenta.Datum_saglasnosti)
        this.dataSource = data;
      }
    )
  }


  popuni(element:any){
    this.router.navigate(["/consent"], {state:{data:{conset:element}}})
  }

}
