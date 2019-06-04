import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RpsGateway, PlayPracticeGameRequest, PlayPracticeGameResponse, PlayGameRequest } from './rps.gateway';
import { GameResult } from './game';
import { Observable } from 'rxjs';

@Injectable()
export class HttpRpsGateway implements RpsGateway {
  constructor( private http: HttpClient ) { }

  playPracticeGame(request: PlayPracticeGameRequest ): Observable<PlayPracticeGameResponse> {
    return this.http.post<PlayPracticeGameResponse>( 'http://localhost:8080/api/gameResults/practice', request );
  }

  playGame(request: PlayGameRequest ): Observable<GameResult> {
    return this.http.post<GameResult>( 'http://localhost:8080/api/gameResults', request );
  }
}
