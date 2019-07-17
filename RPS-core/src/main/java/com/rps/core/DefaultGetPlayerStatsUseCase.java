package com.rps.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultGetPlayerStatsUseCase implements GetPlayerStatsUseCase {

    private GameResultRepository gameResultRepository;

    public DefaultGetPlayerStatsUseCase(GameResultRepository gameResultRepository) {
        this.gameResultRepository = gameResultRepository;
    }

    @Override
    public List<PlayerStat> execute() {
        List<GameResult> results = gameResultRepository.findAll();
        List<GameStat> playerOneList = results.stream()
                .map( gr -> new GameStat( gr, true ))
                .collect(Collectors.toList());
        List<GameStat> playerOnTwoList = results.stream()
                .map( gr -> new GameStat( gr, false ))
                .collect(Collectors.toList());
        return new ArrayList<>();
    }
}
