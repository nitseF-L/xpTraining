import { Component, OnInit } from '@angular/core';
import { Player, Throw, throwLocalization } from './game';
import { HttpGameGateway } from './http.game.gateway';
import { PlayGameRequest, PlayPracticeGameRequest, GameGateway } from './game.gateway';
import { MatDialog } from '@angular/material';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {
  gameResult: string;
  player1Name: string;
  player2Name: string;
  player1Id: string;
  player2Id: string;
  player1Throw: Throw;
  player2Throw: Throw;
  throwTypes: Throw[] = Object.keys(Throw).map(value => Throw[value]);
  throwLocalization = throwLocalization;
  mostRecentOutcome = '';
  rankedGameRequest: PlayGameRequest;
  practiceGameRequest: PlayPracticeGameRequest;

  isPracticeGame = false;

  constructor(private gameGateway: GameGateway) {

  }

  ngOnInit() {
  }

  processRankedGame() {
    this.mostRecentOutcome = '';
    const player1: Player = new Player(this.player1Name, this.player1Id);
    const player2: Player = new Player(this.player2Name, this.player2Id);

    this.rankedGameRequest = new PlayGameRequest(player1, player2, this.player1Throw, this.player2Throw);

    this.gameGateway.playGame(this.rankedGameRequest).subscribe(gameResult => {
      this.mostRecentOutcome = gameResult.outcome;
    });
  }

  processPracticeGame() {
    this.mostRecentOutcome = '';

    this.practiceGameRequest = new PlayPracticeGameRequest(this.player1Throw, this.player2Throw);

    this.gameGateway.playPracticeGame(this.practiceGameRequest).subscribe(gameResult => {
      this.mostRecentOutcome = gameResult.outcome;
    });
  }

  flipToggle() {
    this.isPracticeGame = !this.isPracticeGame;
  }
}
