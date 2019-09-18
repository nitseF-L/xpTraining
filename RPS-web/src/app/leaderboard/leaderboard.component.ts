import { Component, OnInit } from '@angular/core';
import { PlayerStat, GameRecord } from '../game/game';
import { GameGateway } from '../game/game.gateway';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit {

  playerStats: PlayerStat[] = [];
  gameRecords: GameRecord[] = [];
  selectedPlayer = -1;
  selectedPlayerName = '';
  selectedPlayerWin: number;
  selectedPlayerRock: number;
  selectedPlayerPaper: number;
  selectedPlayerScissors: number;
  selectedPlayerLizard: number;
  selectedPlayerSpock: number;

  constructor(private gameGateway: GameGateway) {
    this.playerStats = [];
    this.gameRecords = [];
  }

  ngOnInit() {
    this.getPlayerStats();
  }

  showPlayer( playerId: number ){
    console.log('Click - Player: ', playerId );
    this.selectedPlayer = playerId;
    this.selectedPlayerName = '';
    if( playerId === -1 ) {
      this.getPlayerStats();
    } else {
      this.getGameRecords();
    }

  }

  getPlayerStats() {
    this.playerStats = [];
    this.gameGateway.getPlayerStats().subscribe(returnedPlayerStats => {
      for(let i = 0; i < returnedPlayerStats.length; i++) {
        this.playerStats.push(returnedPlayerStats[i]);
      }
      // this.playerList = this.playerList.sort((a,b) => a.name.localeCompare(b.name));
      console.log('got player Stats', this.playerStats);
    });
  }

  getGameRecords(){
    this.gameRecords = [];
    this.gameGateway.getPlayerGameRecords( this.selectedPlayer).subscribe(returnedGameRecords => {
      for(let i = 0; i < returnedGameRecords.length; i++) {
        this.gameRecords.push(returnedGameRecords[i]);
      }
      // this.playerList = this.playerList.sort((a,b) => a.name.localeCompare(b.name));
      console.log('got player game records', this.gameRecords);
    });
    this.gameGateway.getPlayerStats().subscribe(returnedPlayerStats => {
      for(let i = 0; i < returnedPlayerStats.length; i++) {
        if( returnedPlayerStats[i].player.id == this.selectedPlayer ){
          this.selectedPlayerName = returnedPlayerStats[i].player.name;
          this.selectedPlayerWin = returnedPlayerStats[i].winPercentage;
          this.selectedPlayerRock = returnedPlayerStats[i].rockPercent;
          this.selectedPlayerPaper = returnedPlayerStats[i].paperPercent;
          this.selectedPlayerScissors = returnedPlayerStats[i].scissorsPercent;
          this.selectedPlayerLizard = returnedPlayerStats[i].lizardPercent;
          this.selectedPlayerSpock = returnedPlayerStats[i].spockPercent;
        }
      }
      // this.playerList = this.playerList.sort((a,b) => a.name.localeCompare(b.name));
      console.log('got player Stats', this.playerStats);
    });
  }

  setWinLossStyle(gameResult: any) {
    let cellColor = '';
    switch(gameResult) { 
      case 'WON': { 
         cellColor = 'rgb(124, 252, 0)';
         break; 
      } 
      case 'LOSS': { 
        cellColor = 'rgb(255, 0, 0)';
         break; 
      } 
      case 'TIE': { 
        cellColor = 'rgb(0, 255, 255)';
         break;
      }
      default: { 
        cellColor = 'rgb(255, 255, 255)';
         break;
      } 
   } 
    let styles = {
      'background-color': cellColor + ''
    };

    return styles;
  }
  setHeatStyle(stat: number) {
    let heatColor = '';
    if (stat >= 85) {
      heatColor = 'red';
    } else if (stat < 85 && stat >= 70) {
      heatColor = 'orange';
    } else if (stat <= 30 && stat > 15) {
      heatColor = 'cyan';
    } else if (stat <= 15) {
      heatColor = 'blue';
    }
    const style = {
      backgroundColor:  heatColor
    };
    return style;
  }
}
