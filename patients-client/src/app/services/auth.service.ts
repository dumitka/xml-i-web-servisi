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
    ) {}

  private token_data = null;

  private parser = new xml2js.Parser({
    explicitArray: false,
    explicitRoot: false,
  });

  login(credentials) {
    const builder = new xml2js.Builder({rootName: 'loginData'});
    let loginData = builder.buildObject(credentials);

    return this.http.post(Main.PATH + "api/auth/login", loginData, {headers: Main.HEADERS,  responseType: 'text'})
    .pipe(map((data) => {
      
      let out_result;
      this.parser.parseString(data, (err, result) => {
        out_result = result;
      })

      sessionStorage.setItem("jwt", out_result.accessToken)
      this.token_data = this.getTokenData();//on izvlaci to iz sessionstoragea

    }, catchError(this.errorHandler)));

  }

  logout() {
    sessionStorage.removeItem("jwt")
    this.token_data = null
  }

  signup(user) {
    const builder = new xml2js.Builder({rootName: 'signupData'});
    let signupData = builder.buildObject(user);

    return this.http.post<any>(Main.PATH + "api/auth/signup", signupData, {headers: Main.HEADERS})
    .pipe(map((res) => {
      console.log(res)
     
    }, catchError(this.errorHandler)))
  }

  tokenIsPresent() {
    return sessionStorage.getItem("jwt") != undefined &&  sessionStorage.getItem("jwt") != null;
  }

  static getToken() {
    return  sessionStorage.getItem("jwt");
  }

  getTokenData() {
    let jwtHelper: JwtHelperService = new JwtHelperService();
    if ( this.token_data != null) {
        return this.token_data;
    } else {
      try {
        var stuff =  jwtHelper.decodeToken(sessionStorage.getItem("jwt"));
        
        return {
          user: stuff.user,
          role: stuff.user.authorities[0].name,
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