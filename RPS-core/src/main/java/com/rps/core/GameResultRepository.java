package com.rps.core;

import java.util.List;

public interface GameResultRepository {
    GameResult save( GameResult gameResult );
    GameResult findById( int id );
    List<GameResult> findAll();
}