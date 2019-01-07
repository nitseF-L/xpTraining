package com.rps.core;

import java.util.ArrayList;
import java.util.List;

public class InMemoryGameResultRepository implements GameResultRepository {

    private List<GameResult> results = new ArrayList<>();
    @Override
    public GameResult save(GameResult gameResult) {
        results.add( new GameResult( gameResult ) );
        return new GameResult( results.get( results.size() - 1 ) );
    }

    @Override
    public GameResult findById(int id) {
        return results.stream()
                .filter( result -> result.getGameResultId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public List<GameResult> findAll() {
        return new ArrayList<>( results );
    }
}