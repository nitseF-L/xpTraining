import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { GameGateway } from './game/game.gateway';
import { HttpGameGateway } from './game/http.game.gateway';
// ng import { RankedGameComponent } from './game/ranked-game/ranked-game.component';
import { GameComponent } from './game/game.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { MaterialModule } from './material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app.routing.module';
import { LeaderboardComponent } from './leaderboard/leaderboard.component';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    // RankedGameComponent,
    GameComponent,
    LeaderboardComponent,
    SidebarComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    MaterialModule,
    HttpClientModule,
    CommonModule,
    AppRoutingModule // must be last to facilitate subrouting
  ],
  exports: [
    BrowserModule,
    CommonModule
  ],
  providers: [
    HttpGameGateway,
    {provide: GameGateway, useClass: HttpGameGateway}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
