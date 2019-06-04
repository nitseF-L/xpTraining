import { RpsGateway, PlayPracticeGameRequest, PlayPracticeGameResponse, PlayGameRequest } from './rps.gateway';
import { GameResult, Player, Throw, Outcome } from './game';
import { Observable, of } from 'rxjs';

export class StubRpsGateway implements RpsGateway {

  savePlayPracticeGameCalledWith: PlayPracticeGameRequest;

  playPracticeGame(request: PlayPracticeGameRequest): Observable<PlayPracticeGameResponse> {
    this.savePlayPracticeGameCalledWith = request;

    return of(new PlayPracticeGameResponse(Outcome.P1Wins));
  }

  playGame(request: PlayGameRequest): Observable<GameResult> {
    const p1: Player = new Player('Jane Doe', 'A001');
    const p2: Player = new Player('John Doe', 'A002');
    return of(new GameResult(p1, p2, Throw.Rock, Throw.Scissors, Outcome.P1Wins));
  }
}
