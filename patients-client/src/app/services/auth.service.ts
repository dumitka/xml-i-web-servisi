import { HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { Main} from '../../main';
import * as xml2js from 'xml2js';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  readonly URL: string = Main.PATH + "api/auth/";

 
  constructor(private router: Router,
    private http: HttpClient,
    private jwtHelper: JwtHelperService) {}

  private token_data = null;

  private parser = new xml2js.Parser({
    explicitArray: false,
    explicitRoot: false,
  });

  login(credentials) {
    const builder = new xml2js.Builder({rootName: 'loginData'});
    let loginData = builder.buildObject(credentials);
    console.log(loginData);

    return this.http.post<any>(Main.PATH + "api/auth/login", loginData, {headers: Main.HEADERS})
    .pipe(map((res) => {
      console.log(res)
      this.parser.parseString(res, (err, result) => {
        console.log("Login successssssssssss")
        console.log(result)

        this.token_data = this.getTokenData();
        sessionStorage.setItem("jwt", res.accessToken)
      })

    }, catchError(this.errorHandler)));

  }

  logout() {
    sessionStorage.removeItem("jwt")
    console.log("Logged out FROM AUTH SERVICE")
  }

  signup(user) {  //TODO OVO KORISTITI ZA REGISTRACIJU
    const builder = new xml2js.Builder({rootName: 'signupData'});
    let signupData = builder.buildObject(user);
    console.log(signupData)

    return this.http.post<any>(Main.PATH + "api/auth/signup", signupData, {headers: Main.HEADERS})
    .pipe(map((res) => {
      console.log(res)
      this.parser.parseString(res, (err, user) => {
        console.log(user)
        // return user; //??
      })
    }))
  }

  tokenIsPresent() {
    return sessionStorage.getItem("jwt") != undefined &&  sessionStorage.getItem("jwt") != null;
  }

  static getToken() {
    return  sessionStorage.getItem("jwt");
  }

  getTokenData() {
    if ( this.token_data != null) {
        return this.token_data;
    } else {
      try {
        console.log("TOKEN", sessionStorage.getItem("jwt"))
        console.log("DECODED")
        var stuff =  this.jwtHelper.decodeToken(sessionStorage.getItem("jwt"));//localStorage.getItem('access_token'));
        console.log(stuff)
        return {
          role: stuff.role,
          username: stuff.sub
        }
      } catch(Error) {
        return null;
      }
    }
  }


  errorHandler(error: HttpErrorResponse) {
    return throwError(error);
  }
}