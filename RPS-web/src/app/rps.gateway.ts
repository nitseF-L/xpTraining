import { Throw, OutCome } from './game';
import { Observable } from 'rxjs';

export abstract class RpsGateway {
    abstract playPraticeGame(request: PlayPracticeGameRequest ): Observable<PlayPracticeGameResponse>;
}

export class PlayPracticeGameRequest {
    constructor(
        public player1Throw: Throw,
        public player2Throw: Throw
    ) {}
}

export class PlayPracticeGameResponse {
    constructor(
        public outcome: OutCome
    ) {}
}