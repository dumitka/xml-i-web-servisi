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
export class VaccService {

  readonly URL: string = Main.PATH + "api/vaccinfo";

  constructor(private router: Router,
    private http: HttpClient,
    ) {}


  private parser = new xml2js.Parser({
    explicitArray: false,
    explicitRoot: false,
    tagNameProcessors: [xml2js.processors.stripPrefix]
  });

  getAll() {
    return this.http.get(Main.PATH + "api/vaccinfo", {headers: Main.HEADERS,  responseType: 'text'})
    .pipe(map((data) => {
      let out_result;
      this.parser.parseString(data, (err, result) => {
        out_result = result;
      })
      return out_result.VaccineInfos.VaccineInfo;
    }, catchError(this.errorHandler)));
  }


  errorHandler(error: HttpErrorResponse) {
    return throwError(error);
  }
}