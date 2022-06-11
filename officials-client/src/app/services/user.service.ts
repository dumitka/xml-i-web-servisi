import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map, Observable, throwError } from 'rxjs';
import { Main } from 'src/main';
import * as xml2js from 'xml2js';
import { processors } from 'xml2js';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  readonly URL: string = Main.PATH + 'api/user';

  constructor(private http: HttpClient) { }

  private parser = new xml2js.Parser({
    explicitArray: false,
    explicitRoot: false,
    tagNameProcessors: [processors.stripPrefix]
  });

  getPatientsWithConsent(): Observable<any> {
    return this.http.get(this.URL + '/consent', {headers: Main.HEADERS,  responseType: 'text'}).pipe(map((data) => {
      let out_result;
      this.parser.parseString(data, (err, result) => {
        out_result = result.Pacijenti.Pacijent;
      })
      return out_result;
    }, catchError(this.errorHandler)));
  }

  errorHandler(error: HttpErrorResponse) {
    return throwError(error);
  }
}
