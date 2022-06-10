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

  vaccForm: FormGroup;
  inventory= {
    sinopharmCount: 0,
    astraCount: 0,
    sputnikCount: 0,
    pfizerCount: 0,
    modernaCount: 0
  }

  constructor(private router: Router, private authService: AuthService,
    private formBuilder: FormBuilder, 
    private snackBar: MatSnackBar,
    private vaccService: VaccService) { }

  ngOnInit(): void {

    this.vaccForm = this.formBuilder.group({
      pfizerCount: [""],
      
      
    })
  }

  logout() {
    this.authService.logout();
    this.router.navigate(["/"])
  }
}
