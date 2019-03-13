import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { RpsGateway } from './rps.gateway';
import { HttpRpsGateway } from './http.rps.gateway';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    {provide: RpsGateway, useClass: HttpRpsGateway}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
