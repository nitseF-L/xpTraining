package com.rps.core;

import java.util.List;

public interface GetPlayerGameRecordsUseCase {

    List<GameRecord> execute( int playerId );
}
