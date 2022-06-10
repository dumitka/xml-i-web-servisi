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
export class InterestService {
  readonly URL: string = Main.PATH + "api/interest/";

  constructor(private router: Router,
    private http: HttpClient,
    ) {}

  private parser = new xml2js.Parser({
    explicitArray: false,
    explicitRoot: false,
  });

  createInterest(raw) {
    let interest = this.getInterestAsXml(raw);

    return this.http.post(Main.PATH + "api/interest", interest, {headers: Main.HEADERS})
    .pipe(map((data) => {
      console.log("USPEHH")
    }, catchError(this.errorHandler)));
  }

  getInterestAsXml(raw) {
    let kontaktObj = {
      "Email": raw.email,
      "Broj_mobilnog": raw.broj_mobilnog,
      "Broj_fixnog": raw.broj_fixnog
    }

    let podaciOLicuObj = {
      "Drzavljanstvo": raw.drzavljanstvo,
      "Boraviste": raw.boraviste,
      "Ime": raw.ime,
      "Prezime": raw.prezime,
      "Pol": raw.pol,
      "Datum_rodjenja": raw.datum_rodjenja,
      "JMBG": raw.licni_dokument
    }

    let podaciObj = {
      "Opstina_ustanove": raw.opstina_ustanove,
      "Tip_vakcine": raw.tip_vakcine,
      "Davalac_krvi": raw.davalac_krvi === "DA" ? true : false 
    }

    let interesovanjeObj = {
      "Sifra_interesovanja": raw.sifra_interesovanja,
      "Podaci_o_licu": podaciOLicuObj,
      "Kontakt": kontaktObj,
      "Podaci_o_vakcinaciji": podaciObj,
      "Datum_interesovanja": raw.datum_interesovanja
    }
    const buildd = new xml2js.Builder({rootName: 'Interesovanje'});
    return buildd.buildObject(interesovanjeObj)
  }

  errorHandler(error: HttpErrorResponse) {
    return throwError(error);
  }
}