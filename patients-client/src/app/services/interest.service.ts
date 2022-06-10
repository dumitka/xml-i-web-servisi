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
    let doc = `<?xml version="1.0" encoding="UTF-8"?>
    <Interesovanje
        xmlns="http://www.baklavice.com/interesovanje"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.baklavice.com/interesovanje Interesovanje.xsd"
        xmlns:tipovi="http://www.baklavice.com/tipovi"
        xmlns:pred="http://www.baklavice.com/rdf/predikati/"
        vocab="http://www.baklavice.com/rdf/predikati/"
        about="http://www.baklavice.com/rdf/interesovanje/00">
        <Sifra_interesovanja>00</Sifra_interesovanja>
        <Podaci_o_licu>
            <tipovi:Drzavljanstvo>${raw.drzavljanstvo}</tipovi:Drzavljanstvo>
            <tipovi:Boraviste>${raw.boraviste}</tipovi:Boraviste>
            <tipovi:Ime property="pred:ime" datatype="xsi:string">${raw.ime}</tipovi:Ime>
            <tipovi:Prezime  property="pred:prezime" datatype="xsi:string">${raw.prezime}</tipovi:Prezime>
            <tipovi:Pol>${raw.pol}</tipovi:Pol>
            <tipovi:Datum_rodjenja property="pred:datum_rodjenja" datatype="xs:date">${raw.datum_rodjenja}</tipovi:Datum_rodjenja>
            <tipovi:JMBG>${raw.jmbg}</tipovi:JMBG>
        </Podaci_o_licu>
        <Kontakt>
            <tipovi:Email>${raw.email}</tipovi:Email>
            <tipovi:Broj_mobilnog>${raw.broj_mobilnog}</tipovi:Broj_mobilnog>
            <tipovi:Broj_fiksnog>${raw.broj_fixnog}</tipovi:Broj_fiksnog>
        </Kontakt>
        <Podaci_o_vakcinaciji>
            <Opstina_ustanove>${raw.opstina_ustanove}</Opstina_ustanove>
            <Tip_vakcine>${raw.tip_vakcine}</Tip_vakcine>
            <Davalac_krvi>${raw.davalac_krvi === "DA" ? true : false}</Davalac_krvi>
        </Podaci_o_vakcinaciji>
        <Datum_interesovanja property="pred:datum_interesovanja" datatype="xs:date">${raw.datum_interesovanja}</Datum_interesovanja>    
    </Interesovanje>
    `
    return doc
  }

  errorHandler(error: HttpErrorResponse) {
    return throwError(error);
  }
}