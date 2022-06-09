import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';
import { HttpHeaders } from '@angular/common/http';

export class Main {
  public static PATH = "http://localhost:8081/";
  public static HEADERS = new HttpHeaders({
    'Accept': 'application/xml',
    'Content-Type': 'application/xml',
  });
}


if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
