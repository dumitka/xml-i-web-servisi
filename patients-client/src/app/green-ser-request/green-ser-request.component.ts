import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-green-ser-request',
  templateUrl: './green-ser-request.component.html',
  styleUrls: ['./green-ser-request.component.css']
})
export class GreenSerRequestComponent implements OnInit {
  requestDataForm: FormGroup;

  constructor(private router: Router, private authService: AuthService, private fb: FormBuilder) { 
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
  }

}
