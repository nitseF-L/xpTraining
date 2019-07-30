import { Component, OnInit } from '@angular/core';
import { PlayerStat } from '../game/game';
import { GameGateway } from '../game/game.gateway';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit {

  playerStats: PlayerStat[] = [];

  constructor(private gameGateway: GameGateway) {
    this.playerStats = [];
  }

  ngOnInit() {
    this.playerStats = [];
    this.getPlayerStats();
  }

  getPlayerStats() {
    this.gameGateway.getPlayerStats().subscribe(returnedPlayerStats => {
      for(let i = 0; i < returnedPlayerStats.length; i++) {
        this.playerStats.push(returnedPlayerStats[i]);
      }
      // this.playerList = this.playerList.sort((a,b) => a.name.localeCompare(b.name));
      console.log('got player Statss', this.playerStats);
    })
  }

}
