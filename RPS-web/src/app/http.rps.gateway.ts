import { Injectable } from "@angular/core";
import { RpsGateway } from './rps.gateway';
import { PlayPracticeGameRequest } from './rps.gateway';
import { PlayPracticeGameResponse } from './rps.gateway';
import { PlayGameRequest } from './rps.gateway';
import { GameResult } from './game';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class HttpRpsGateway implements RpsGateway {
    constructor( private http: HttpClient ){ }

    playPraticeGame(request: PlayPracticeGameRequest ): Observable<PlayPracticeGameResponse>{
        return this.http.post<PlayPracticeGameResponse>( 'http://localhost:8080/api/gameResults/practice', request );
    }

    playGame(request: PlayGameRequest ): Observable<GameResult>{
        return this.http.post<GameResult>( 'http://localhost:8080/api/gameResults', request );
    }
}