import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import { Router } from '@angular/router';
import { throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { Main} from '../../main';
import * as xml2js from 'xml2js';

@Injectable({
  providedIn: 'root'
})
export class GreenSerRequestServiceService {
  readonly URL: string = Main.PATH + "api/greenSerRequest/"; //TODO link na kontrolor
  
  private parser = new xml2js.Parser({
    explicitArray: false,
    explicitRoot: false,
  });

  constructor(private router: Router, private http: HttpClient,) {}


  createRequest(raw) {
    let request = this.getRequestAsXml(raw);

    return this.http.post(this.URL, request, {headers: Main.HEADERS})
    .pipe(map((data) => {
      console.log("USPEHH")
    }, catchError(this.errorHandler)));
  }


  getRequestAsXml(raw) {
    let doc = `<?xml version="1.0" encoding="UTF-8"?>
    <Zahtev xmlns="http://www.baklavice.com/zahtev_za_sertifikat"
        xmlns:tipovi="http://www.baklavice.com/tipovi"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.baklavice.com/zahtev_za_sertifikat Zahtev_za_sertifikat.xsd"
        Ime_dokumenta="Zahtev za izdavanje digitalnog zelenog sertifikata"
        xmlns:pred="http://www.baklavice.com/rdf/predikati/"
        vocab="http://www.baklavice.com/rdf/predikati/"
        about="http://www.baklavice.com/rdf/zahtev_za_sertifikat/00">
        <Sifra_zahteva>00</Sifra_zahteva>
        <Izjava_podnosenja_zahteva>
            U skladu sa odredbom Republike Srbije o izdavanju digitalnog zelenog sertifikata kao potvrde o 
            izvršenoj vakcinaciji protiv COVID-19, rezultatima testiranja na zaraznu bolest SARS-CoV-2 ili oporavku 
            od bolesti COVID-19 podnosim zahtev za izdavanje digitalnog zelenog sertifikata.
        </Izjava_podnosenja_zahteva>
        <Podaci_o_podnosiocu>
            <tipovi:Drzavljanstvo></tipovi:Drzavljanstvo>
            <tipovi:Boraviste></tipovi:Boraviste>
            <tipovi:Ime property="pred:ime" datatype="xsi:string">${raw.name}</tipovi:Ime>
            <tipovi:Prezime property="pred:prezime" datatype="xsi:string">${raw.lastName}</tipovi:Prezime>
            <tipovi:Pol>${raw.gender}</tipovi:Pol>
            <tipovi:Datum_rodjenja property="pred:datum_rodjenja" datatype="xs:date">${raw.dateOfBirth}</tipovi:Datum_rodjenja>
            <tipovi:JMBG>${raw.jmbg}</tipovi:JMBG>
        </Podaci_o_podnosiocu>
        <Razlog_podnosenja_zahteva>${raw.reason}</Razlog_podnosenja_zahteva>
        <Mesto_podnosenja_zahteva>${raw.place}</Mesto_podnosenja_zahteva>
        <Datum_podnosenja_zahteva property="pred:datum_podnosenja_zahteva" datatype="xsi:date">${raw.date}</Datum_podnosenja_zahteva>
    </Zahtev>
    `
    return doc
  }

  errorHandler(error: HttpErrorResponse) {
    return throwError(error);
  }
}
