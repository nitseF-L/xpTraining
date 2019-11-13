import { RpsGateway } from './rps.gateway';
import { PlayPracticeGameRequest } from './rps.gateway';
import { PlayPracticeGameResponse } from './rps.gateway';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { OutCome } from './game';

export class StubRpsGateway implements RpsGateway {

    savePlayPraticeGameCalledWith: PlayPracticeGameRequest;

    playPraticeGame(request: PlayPracticeGameRequest ): Observable<PlayPracticeGameResponse>{

        this.savePlayPraticeGameCalledWith = request;

        return of( new PlayPracticeGameResponse( OutCome.P1Wins));
    }
}