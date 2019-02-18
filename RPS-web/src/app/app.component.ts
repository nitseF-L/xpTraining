import { Component } from '@angular/core';

import { RpsGateway, PlayPracticeGameRequest } from './rps.gateway';
import { Throw, throwLocalization, outcomeLocatization } from './game';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  gameResult: String;
  player1Throw: Throw;
  player2Throw: Throw;
  throwTypes: Throw[] = Object.keys(Throw).map( value => Throw[value]);
  throwLocalization = throwLocalization;

  constructor( private gateway: RpsGateway ){

  }

  title = 'Rock, Paper, Scissors';

  palyer1throws( p1: Throw ): void{
      this.player1Throw = p1;
  }

  palyer2throws( p2: Throw ): void{
    this.player2Throw = p2;
}

  playGame(): void {
    
    this.gateway.playPraticeGame( 
      new PlayPracticeGameRequest( this.player1Throw, this.player2Throw ))
      .subscribe( (response) => {
        this.gameResult = outcomeLocatization[response.outcome];
        console.log(response.outcome);
        console.log(outcomeLocatization[response.outcome]);
      });
    
  }
}
