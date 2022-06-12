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
export class ConsentServiceService {

  readonly URL: string = Main.PATH + "api/consent/"; //TODO link na kontrolor
  
  private parser = new xml2js.Parser({
    explicitArray: false,
    explicitRoot: false,
  });

  constructor(private router: Router, private http: HttpClient,) {}


  createConsent(raw, pasos) {
    if(pasos){
      let consent = this.getRequestAsXmlPassport(raw);

      return this.http.post(this.URL, consent, {headers: Main.HEADERS}).pipe(map((data) => {
        console.log("USPEHH")
      }, catchError(this.errorHandler)));

    }else{
      let consent = this.getRequestAsXmlJMBG(raw);

      return this.http.post(this.URL, consent, {headers: Main.HEADERS}).pipe(map((data) => {
        console.log("USPEHH")
      }, catchError(this.errorHandler)));
    }

    
  }


  getRequestAsXmlJMBG(raw) {
    let doc = `<?xml version="1.0" encoding="UTF-8"?>
    <Saglasnost
        xmlns="http://www.baklavice.com/saglasnost"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.baklavice.com/saglasnost Saglasnost.xsd"
        xmlns:tipovi="http://www.baklavice.com/tipovi"
        xmlns:pred="http://www.baklavice.com/rdf/predikati/"
        vocab="http://www.baklavice.com/rdf/predikati/"
        about="http://www.baklavice.com/rdf/saglasnost/00">
        <Sifra_saglasnosti>00</Sifra_saglasnosti>
        <Deo_za_pacijenta>
            <Licni_podaci>
                <tipovi:Drzavljanstvo>${raw.citizenship}</tipovi:Drzavljanstvo>
                <tipovi:Boraviste>${raw.citizenship}</tipovi:Boraviste>
                <tipovi:Ime property="pred:ime" datatype="xsi:string">${raw.name}</tipovi:Ime>
                <tipovi:Prezime property="pred:prezime" datatype="xsi:string">${raw.lastName}</tipovi:Prezime>
                <tipovi:Pol>${raw.gender}</tipovi:Pol>
                <tipovi:Datum_rodjenja property="pred:datum_rodjenja" datatype="xs:date">${raw.dateOfBirth}</tipovi:Datum_rodjenja>
                <tipovi:JMBG>${raw.jmbg}</tipovi:JMBG>
                <tipovi:Ime_roditelja>${raw.parentName}</tipovi:Ime_roditelja>
                <tipovi:Mesto_rodjenja>${raw.placeOfBirth}</tipovi:Mesto_rodjenja>
                <tipovi:Adresa>
                    <tipovi:Opstina>${raw.township}</tipovi:Opstina>
                    <tipovi:Mesto>${raw.livingPlace}</tipovi:Mesto>
                    <tipovi:Ulica>${raw.street}</tipovi:Ulica>
                    <tipovi:Broj>${raw.number}</tipovi:Broj>
                </tipovi:Adresa>
                <tipovi:Kontakt>
                    <tipovi:Broj_fiksnog>${raw.fiksni}</tipovi:Broj_fiksnog>
                    <tipovi:Broj_mobilnog>${raw.phone}</tipovi:Broj_mobilnog>
                    <tipovi:Email>${raw.email}</tipovi:Email>
                </tipovi:Kontakt>
                <tipovi:Radni_status>${raw.radni_status}</tipovi:Radni_status>
                <tipovi:Zanimanje_zaposlenog>${raw.zanimanje_zaposlenog}</tipovi:Zanimanje_zaposlenog>
                <tipovi:Socijalna_zastita>${raw.socijalno}</tipovi:Socijalna_zastita>
            </Licni_podaci>
            <Pacijent_je_saglasan property="pred:pacijent_je_saglasan" datatype="xsi:boolean">${raw.saglasnost}</Pacijent_je_saglasan>
            <Tip_vakcine>${raw.vakcina}</Tip_vakcine>
            <Datum_saglasnosti property="pred:datum_saglasnosti" datatype="xsi:date">${raw.dateOfConsent}</Datum_saglasnosti>
        </Deo_za_pacijenta>
        <Deo_za_radnika>
            <Zdravstvena_ustanova property="pred:zdravstvena_ustanova" datatype="xsi:string"></Zdravstvena_ustanova>
            <Vakcinacijski_punkt></Vakcinacijski_punkt>
            <Podaci_o_lekaru property="pred:podaci_o_lekaru" datatype="xsi:string"></Podaci_o_lekaru>
            <Primljene_vakcine_info>
                <Primljena_vakcina>
                    <Naziv_vakcine></Naziv_vakcine>
                    <Datum_davanja_vakcine property="pred:datum_davanja_vakcine" datatype="xsi:date"></Datum_davanja_vakcine>
                    <Nacin_davanja_vakcine></Nacin_davanja_vakcine>
                    <Ekstremitet></Ekstremitet>
                    <Serija_vakcine></Serija_vakcine>
                    <Proizvodjac></Proizvodjac>
                </Primljena_vakcina>
                <Primljena_vakcina>
                    <Naziv_vakcine></Naziv_vakcine>
                    <Datum_davanja_vakcine property="pred:datum_davanja_vakcine" datatype="xsi:date"></Datum_davanja_vakcine>
                    <Nacin_davanja_vakcine></Nacin_davanja_vakcine>
                    <Ekstremitet></Ekstremitet>
                    <Serija_vakcine></Serija_vakcine>
                    <Proizvodjac></Proizvodjac>
                </Primljena_vakcina>
                <Primljena_vakcina>
                    <Naziv_vakcine></Naziv_vakcine>
                    <Datum_davanja_vakcine property="pred:datum_davanja_vakcine" datatype="xsi:date"></Datum_davanja_vakcine>
                    <Nacin_davanja_vakcine></Nacin_davanja_vakcine>
                    <Ekstremitet></Ekstremitet>
                    <Serija_vakcine></Serija_vakcine>
                    <Proizvodjac></Proizvodjac>
                </Primljena_vakcina>
            </Primljene_vakcine_info>
        </Deo_za_radnika>
    </Saglasnost>
    `
    return doc
  }


  getRequestAsXmlPassport(raw){
    let doc = `<?xml version="1.0" encoding="UTF-8"?>
    <Saglasnost
        xmlns="http://www.baklavice.com/saglasnost"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.baklavice.com/saglasnost Saglasnost.xsd"
        xmlns:tipovi="http://www.baklavice.com/tipovi"
        xmlns:pred="http://www.baklavice.com/rdf/predikati/"
        vocab="http://www.baklavice.com/rdf/predikati/"
        about="http://www.baklavice.com/rdf/saglasnost/00">
        <Sifra_saglasnosti>00</Sifra_saglasnosti>
        <Deo_za_pacijenta>
            <Licni_podaci>
                <tipovi:Drzavljanstvo>${raw.citizenship}</tipovi:Drzavljanstvo>
                <tipovi:Boraviste>${raw.citizenship}</tipovi:Boraviste>
                <tipovi:Ime property="pred:ime" datatype="xsi:string">${raw.name}</tipovi:Ime>
                <tipovi:Prezime property="pred:prezime" datatype="xsi:string">${raw.lastName}</tipovi:Prezime>
                <tipovi:Pol>${raw.gender}</tipovi:Pol>
                <tipovi:Datum_rodjenja property="pred:datum_rodjenja" datatype="xs:date">${raw.dateOfBirth}</tipovi:Datum_rodjenja>
                <tipovi:JMBG>${raw.passport}</tipovi:JMBG>
                <tipovi:Ime_roditelja>${raw.parentName}</tipovi:Ime_roditelja>
                <tipovi:Mesto_rodjenja>${raw.placeOfBirth}</tipovi:Mesto_rodjenja>
                <tipovi:Adresa>
                    <tipovi:Opstina>${raw.township}</tipovi:Opstina>
                    <tipovi:Mesto>${raw.livingPlace}</tipovi:Mesto>
                    <tipovi:Ulica>${raw.street}</tipovi:Ulica>
                    <tipovi:Broj>${raw.number}</tipovi:Broj>
                </tipovi:Adresa>
                <tipovi:Kontakt>
                    <tipovi:Broj_fiksnog>${raw.fiksni}</tipovi:Broj_fiksnog>
                    <tipovi:Broj_mobilnog>${raw.phone}</tipovi:Broj_mobilnog>
                    <tipovi:Email>${raw.email}</tipovi:Email>
                </tipovi:Kontakt>
                <tipovi:Radni_status>${raw.radni_status}</tipovi:Radni_status>
                <tipovi:Zanimanje_zaposlenog>${raw.zanimanje_zaposlenog}</tipovi:Zanimanje_zaposlenog>
                <tipovi:Socijalna_zastita>${raw.socijalno}</tipovi:Socijalna_zastita>
            </Licni_podaci>
            <Pacijent_je_saglasan property="pred:pacijent_je_saglasan" datatype="xsi:boolean">${raw.saglasnost}</Pacijent_je_saglasan>
            <Tip_vakcine>${raw.vakcina}</Tip_vakcine>
            <Datum_saglasnosti property="pred:datum_saglasnosti" datatype="xsi:date">${raw.dateOfConsent}</Datum_saglasnosti>
        </Deo_za_pacijenta>
        <Deo_za_radnika>
            <Zdravstvena_ustanova property="pred:zdravstvena_ustanova" datatype="xsi:string"></Zdravstvena_ustanova>
            <Vakcinacijski_punkt></Vakcinacijski_punkt>
            <Podaci_o_lekaru property="pred:podaci_o_lekaru" datatype="xsi:string"></Podaci_o_lekaru>
            <Primljene_vakcine_info>
                <Primljena_vakcina>
                    <Naziv_vakcine></Naziv_vakcine>
                    <Datum_davanja_vakcine property="pred:datum_davanja_vakcine" datatype="xsi:date"></Datum_davanja_vakcine>
                    <Nacin_davanja_vakcine></Nacin_davanja_vakcine>
                    <Ekstremitet></Ekstremitet>
                    <Serija_vakcine></Serija_vakcine>
                    <Proizvodjac></Proizvodjac>
                </Primljena_vakcina>
                <Primljena_vakcina>
                    <Naziv_vakcine></Naziv_vakcine>
                    <Datum_davanja_vakcine property="pred:datum_davanja_vakcine" datatype="xsi:date"></Datum_davanja_vakcine>
                    <Nacin_davanja_vakcine></Nacin_davanja_vakcine>
                    <Ekstremitet></Ekstremitet>
                    <Serija_vakcine></Serija_vakcine>
                    <Proizvodjac></Proizvodjac>
                </Primljena_vakcina>
                <Primljena_vakcina>
                    <Naziv_vakcine></Naziv_vakcine>
                    <Datum_davanja_vakcine property="pred:datum_davanja_vakcine" datatype="xsi:date"></Datum_davanja_vakcine>
                    <Nacin_davanja_vakcine></Nacin_davanja_vakcine>
                    <Ekstremitet></Ekstremitet>
                    <Serija_vakcine></Serija_vakcine>
                    <Proizvodjac></Proizvodjac>
                </Primljena_vakcina>
            </Primljene_vakcine_info>
        </Deo_za_radnika>
    </Saglasnost>
    `
    return doc
  }

  errorHandler(error: HttpErrorResponse) {
    return throwError(error);
  }
}
