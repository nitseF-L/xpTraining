import { GameResult, Player, Throw, Outcome } from './game';
import { Observable, of } from 'rxjs';
import { GameGateway, PlayPracticeGameRequest, PlayPracticeGameResponse, PlayGameRequest } from './game.gateway';

export class StubGameGateway implements GameGateway {

  playPracticeGameCalledWith: PlayPracticeGameRequest;
  playGameCalledWith: PlayGameRequest;

  playPracticeGame(request: PlayPracticeGameRequest): Observable<PlayPracticeGameResponse> {
    this.playPracticeGameCalledWith = request;

    return of(new PlayPracticeGameResponse(Outcome.P1Wins));
  }

  playGame(request: PlayGameRequest): Observable<GameResult> {
    this.playGameCalledWith = request;

    return of(new GameResult(request.player1, request.player2, request.player1Throw, request.player2Throw, Outcome.Tie));
  }

  getPlayers(): Observable<Player>{
    return of( (new Player("Player1",1), new Player("PLayer2",2 )));
  }
}
