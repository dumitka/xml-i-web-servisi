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

  readonly URL: string = Main.PATH + "api/consents";  //controler

  constructor(private router: Router, private http: HttpClient,) {}

  private parser = new xml2js.Parser({
    explicitArray: false,
    explicitRoot: false,
    tagNameProcessors: [xml2js.processors.stripPrefix]
  });

  getAll() {
    return this.http.get(this.URL, {headers: Main.HEADERS,  responseType: 'text'})
    .pipe(map((data) => {
      let out_result;
      this.parser.parseString(data, (err, result) => {
        out_result = result;
      })
      return out_result.Consents.Consent;  
    }, catchError(this.errorHandler)));
  }



  dodaj(data) {
    //const builder = new xml2js.Builder({rootName: 'ConsentHWPart'});
    //let obj = builder.buildObject(data);
    console.log(data)
    
    let consent = this.getRequestAsXml(data);

    return this.http.post(this.URL, consent, {headers: Main.HEADERS}).pipe(map((data) => {
      console.log("USPEHH")
    }, catchError(this.errorHandler)));
  }


  

  errorHandler(error: HttpErrorResponse) {
    return throwError(error);
  }


  getRequestAsXml(raw){
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
                <tipovi:Drzavljanstvo>${raw.Deo_za_pacijenta.Licni_podaci.Drzavljanstvo}</tipovi:Drzavljanstvo>
                <tipovi:Boraviste>${raw.Deo_za_pacijenta.Licni_podaci.Boraviste}</tipovi:Boraviste>
                <tipovi:Ime property="pred:ime" datatype="xsi:string">${raw.Deo_za_pacijenta.Licni_podaci.Ime}</tipovi:Ime>
                <tipovi:Prezime property="pred:prezime" datatype="xsi:string">${raw.Deo_za_pacijenta.Licni_podaci.Prezime}</tipovi:Prezime>
                <tipovi:Pol>${raw.Deo_za_pacijenta.Licni_podaci.Pol}</tipovi:Pol>
                <tipovi:Datum_rodjenja property="pred:datum_rodjenja" datatype="xs:date">${raw.Deo_za_pacijenta.Licni_podaci.Datum_rodjenja}</tipovi:Datum_rodjenja>
                <tipovi:JMBG>${raw.Deo_za_pacijenta.Licni_podaci.Broj_pasosa}</tipovi:JMBG>
                <tipovi:Ime_roditelja>${raw.Deo_za_pacijenta.Licni_podaci.Ime_roditelja}</tipovi:Ime_roditelja>
                <tipovi:Mesto_rodjenja>${raw.Deo_za_pacijenta.Licni_podaci.Mesto_rodjenja}</tipovi:Mesto_rodjenja>
                <tipovi:Adresa>
                    <tipovi:Opstina>${raw.Deo_za_pacijenta.Licni_podaci.Adresa.Opstina}</tipovi:Opstina>
                    <tipovi:Mesto>${raw.Deo_za_pacijenta.Licni_podaci.Adresa.Mesto}</tipovi:Mesto>
                    <tipovi:Ulica>${raw.Deo_za_pacijenta.Licni_podaci.Adresa.Ulica}</tipovi:Ulica>
                    <tipovi:Broj>${raw.Deo_za_pacijenta.Licni_podaci.Adresa.Broj}</tipovi:Broj>
                </tipovi:Adresa>
                <tipovi:Kontakt>
                    <tipovi:Broj_fiksnog>${raw.Deo_za_pacijenta.Licni_podaci.Kontakt.Broj_fiksnog}</tipovi:Broj_fiksnog>
                    <tipovi:Broj_mobilnog>${raw.Deo_za_pacijenta.Licni_podaci.Kontakt.Broj_mobilnog}</tipovi:Broj_mobilnog>
                    <tipovi:Email>${raw.Deo_za_pacijenta.Licni_podaci.Kontakt.Email}</tipovi:Email>
                </tipovi:Kontakt>
                <tipovi:Radni_status></tipovi:Radni_status>
                <tipovi:Zanimanje_zaposlenog></tipovi:Zanimanje_zaposlenog>
                <tipovi:Socijalna_zastita>${raw.Deo_za_pacijenta.Licni_podaci.Socijalna_zastita}</tipovi:Socijalna_zastita>
            </Licni_podaci>
            <Pacijent_je_saglasan property="pred:pacijent_je_saglasan" datatype="xsi:boolean">${raw.Deo_za_pacijenta.Pacijent_je_saglasan}</Pacijent_je_saglasan>
            <Tip_vakcine>${raw.Deo_za_pacijenta.Tip_vakcine}</Tip_vakcine>
            <Datum_saglasnosti property="pred:datum_saglasnosti" datatype="xsi:date">${raw.Deo_za_pacijenta.Datum_saglasnosti}</Datum_saglasnosti>
        </Deo_za_pacijenta>
        <Deo_za_radnika>
            <Zdravstvena_ustanova property="pred:zdravstvena_ustanova" datatype="xsi:string">${raw.Deo_za_radnika.Zdravstvena_ustanova}</Zdravstvena_ustanova>
            <Vakcinacijski_punkt>${raw.Deo_za_radnika.Vakcinacijski_punkt}</Vakcinacijski_punkt>
            <Podaci_o_lekaru property="pred:podaci_o_lekaru" datatype="xsi:string">${raw.Deo_za_radnika.Podaci_o_lekaru}</Podaci_o_lekaru>
            <Primljene_vakcine_info>
                <Primljena_vakcina>
                    <Naziv_vakcine>${raw.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[0].Naziv_vakcine}</Naziv_vakcine>
                    <Datum_davanja_vakcine property="pred:datum_davanja_vakcine" datatype="xsi:date">${raw.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[0].Datum_davanja_vakcine}</Datum_davanja_vakcine>
                    <Nacin_davanja_vakcine>${raw.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[0].Nacin_davanja_vakcine}</Nacin_davanja_vakcine>
                    <Ekstremitet>${raw.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[0].Ekstremitet}</Ekstremitet>
                    <Serija_vakcine>${raw.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[0].Serija_vakcine}</Serija_vakcine>
                    <Proizvodjac>${raw.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[0].Proizvodjac}</Proizvodjac>
                </Primljena_vakcina>
                <Primljena_vakcina>
                    <Naziv_vakcine>${raw.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[1].Naziv_vakcine}</Naziv_vakcine>
                    <Datum_davanja_vakcine property="pred:datum_davanja_vakcine" datatype="xsi:date">${raw.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[1].Datum_davanja_vakcine}</Datum_davanja_vakcine>
                    <Nacin_davanja_vakcine>${raw.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[1].Nacin_davanja_vakcine}</Nacin_davanja_vakcine>
                    <Ekstremitet>${raw.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[1].Ekstremitet}</Ekstremitet>
                    <Serija_vakcine>${raw.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[1].Serija_vakcine}</Serija_vakcine>
                    <Proizvodjac>${raw.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[1].Proizvodjac}</Proizvodjac>
                </Primljena_vakcina>
                <Primljena_vakcina>
                    <Naziv_vakcine>${raw.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[2].Naziv_vakcine}</Naziv_vakcine>
                    <Datum_davanja_vakcine property="pred:datum_davanja_vakcine" datatype="xsi:date">${raw.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[1].Datum_davanja_vakcine}</Datum_davanja_vakcine>
                    <Nacin_davanja_vakcine>${raw.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[2].Nacin_davanja_vakcine}</Nacin_davanja_vakcine>
                    <Ekstremitet>${raw.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[2].Ekstremitet}</Ekstremitet>
                    <Serija_vakcine>${raw.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[2].Serija_vakcine}</Serija_vakcine>
                    <Proizvodjac>${raw.Deo_za_radnika.Primljene_vakcine_info.Primljena_vakcina[2].Proizvodjac}</Proizvodjac>
                </Primljena_vakcina>
            </Primljene_vakcine_info>
        </Deo_za_radnika>
    </Saglasnost>
    `
    return doc
  }

}
