import { HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { Main} from '../../main';
import * as xml2js from 'xml2js';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  readonly URL: string = Main.PATH + "api/auth/";

 
  constructor(private router: Router,
    private http: HttpClient) {}

    private access_token = null;
    private token_data = null;

    login(credentials) {
     
      const builder = new xml2js.Builder({rootName: 'loginData'});

      let loginData = builder.buildObject(credentials);
      console.log(loginData);

      let headers = new HttpHeaders({
        'Accept': 'application/xml',
        'Content-Type': 'application/xml',
      });

      const parser = new xml2js.Parser({
        explicitArray: false,
        explicitRoot: false,
      });


      return this.http.post<any>(Main.PATH + "api/auth/login", loginData, {headers: headers})
      .pipe(map((res) => {
        console.log(res)
        parser.parseString(res, (err, result) => {
          console.log(result)
          console.log("EVO SAD OBRADI TOKEN JEBO ME TOKEN DA ME JEBO TOKEN")
        })

      }, catchError(this.errorHandler)));

    }

    tokenIsPresent() {
      return this.access_token != null;
    }

    getToken() {
      return this.access_token;
    }

    errorHandler(error: HttpErrorResponse) {
      return throwError(error);
    }
}



// login(user: any) {
//   const body = {
//     'username': user.username,
//     'password': user.password
//   };
//   return this.http.post<any>(Main.PATH + "auth/login", body)
//     .pipe(map((res) => {
//       this.access_token = res.accessToken;
//       this.token_data = res;
//       window.localStorage.setItem("token", this.access_token);
//     }, catchError(this.errorHander)));
// }