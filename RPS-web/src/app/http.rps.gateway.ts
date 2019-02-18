import { Injectable } from "@angular/core";
import { RpsGateway } from './rps.gateway';
import { PlayPracticeGameRequest } from './rps.gateway';
import { PlayPracticeGameResponse } from './rps.gateway';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class HttpRpsGateway implements RpsGateway {
    constructor( private http: HttpClient ){ }

    playPraticeGame(request: PlayPracticeGameRequest ): Observable<PlayPracticeGameResponse>{
        return this.http.post<PlayPracticeGameResponse>( '/api/gameResults/practice', request );
    }
}