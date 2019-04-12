import { Component } from '@angular/core';
import { RpsGateway, PlayPracticeGameRequest, PlayGameRequest } from './rps.gateway';
import { Throw, throwLocalization, outcomeLocatization, Player } from './game';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  gameResult: string;
  player1Name: string;
  player2Name: string;
  player1Id: string;
  player2Id: string;
  player1Throw: Throw;
  player2Throw: Throw;
  throwTypes: Throw[] = Object.keys(Throw).map(value => Throw[value]);
  throwLocalization = throwLocalization;

  constructor(private gateway: RpsGateway) {

  }

  title = 'Rock, Paper, Scissors';

  playGame(): void {

    const p1: Player = new Player(this.player1Name, this.player1Id);
    const p2: Player = new Player(this.player2Name, this.player2Id);

    this.gateway.playGame(
      new PlayGameRequest(p1, p2, this.player1Throw, this.player2Throw))
      .subscribe((response) => {
        this.gameResult = outcomeLocatization[response.outcome];
        console.log(response.outcome);
        console.log(outcomeLocatization[response.outcome]);
      });

  }

  playPracticeGame(): void {

    this.gateway.playPracticeGame(
      new PlayPracticeGameRequest(this.player1Throw, this.player2Throw))
      .subscribe((response) => {
        this.gameResult = outcomeLocatization[response.outcome];
        console.log(response.outcome);
        console.log(outcomeLocatization[response.outcome]);
      });

  }
}
