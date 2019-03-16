import { RpsGateway } from './rps.gateway';
import { PlayPracticeGameRequest } from './rps.gateway';
import { PlayPracticeGameResponse } from './rps.gateway';
import { PlayGameRequest } from './rps.gateway';
import { GameResult, Player, Throw } from './game';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { Outcome  } from './game';

export class StubRpsGateway implements RpsGateway {

    savePlayPraticeGameCalledWith: PlayPracticeGameRequest;

    playPraticeGame(request: PlayPracticeGameRequest ): Observable<PlayPracticeGameResponse>{

        this.savePlayPraticeGameCalledWith = request;

        return of( new PlayPracticeGameResponse( Outcome.P1Wins));
    }
    
    playGame(request: PlayGameRequest ): Observable<GameResult>{
        const p1: Player = new Player('Jane Doe', 'A001');
        const p2: Player = new Player('John Doe', 'A002');
        return of( new GameResult( p1, p2, Throw.Rock, Throw.Scissors, Outcome.P1Wins));
    }
}