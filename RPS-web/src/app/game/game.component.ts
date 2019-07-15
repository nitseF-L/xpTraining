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
  player1Id: number;
  player2Id: number;
  player1Throw: Throw;
  player2Throw: Throw;
  throwTypes: Throw[] = Object.keys(Throw).map(value => Throw[value]);
  throwLocalization = throwLocalization;
  mostRecentOutcome = '';
  rankedGameRequest: PlayGameRequest;
  practiceGameRequest: PlayPracticeGameRequest;
  playerList: Player[] = [];
  selectedPlayer1: Player;
  selectedPlayer2: Player;

  isPracticeGame = false;

  constructor(private gameGateway: GameGateway) {

  }

  ngOnInit() {
    this.playerList = [];
    this.getPlayers();
  }

  processRankedGame() {
    this.mostRecentOutcome = '';
    this.rankedGameRequest = new PlayGameRequest(this.selectedPlayer1, this.selectedPlayer2, this.player1Throw, this.player2Throw);

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

  getPlayers() {
    this.gameGateway.getPlayers().subscribe(returnedPlayers => {
      for(let i = 0; i < returnedPlayers.length; i++) {
        this.playerList.push(returnedPlayers[i]);
      }
      this.playerList = this.playerList.sort((a,b) => a.name.localeCompare(b.name));
      console.log('got players', this.playerList);
    })
  }
}
