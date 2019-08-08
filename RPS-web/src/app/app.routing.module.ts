import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LeaderboardComponent } from './leaderboard/leaderboard.component';
import { GameComponent } from './game/game.component';

const routes: Routes = [
    { path: '', redirectTo: 'leaderboard', pathMatch: "full" },
    { path: 'leaderboard', component: LeaderboardComponent },
    { path: 'play', component: GameComponent },
    { path: '**', component: LeaderboardComponent },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }