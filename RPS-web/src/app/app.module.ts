import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { RpsGateway } from './game/game.gateway';
import { HttpRpsGateway } from './game/http.game.gateway';
import { RankedGameComponent } from './game/ranked-game/ranked-game.component';
import { GameComponent } from './game/game.component';
import { SidebarComponent } from './sidebar/sidebar.component';

@NgModule({
  declarations: [
    AppComponent,
    RankedGameComponent,
    GameComponent,
    SidebarComponent
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
