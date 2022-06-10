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

  constructor(private router: Router,
    private http: HttpClient,
    ) {}


  private parser = new xml2js.Parser({
    explicitArray: false,
    explicitRoot: false,
  });



  errorHandler(error: HttpErrorResponse) {
    return throwError(error);
  }
}