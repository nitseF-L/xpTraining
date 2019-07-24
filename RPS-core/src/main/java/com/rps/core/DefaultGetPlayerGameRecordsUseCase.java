package com.rps.core;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultGetPlayerGameRecordsUseCase implements GetPlayerGameRecordsUseCase {

    private GameResultRepository gameResultRepository;

    public DefaultGetPlayerGameRecordsUseCase(GameResultRepository gameResultRepository) {
        this.gameResultRepository = gameResultRepository;
    }

    @Override
    public List<GameRecord> execute(int playerId) {

        return gameResultRepository.findAll().stream()
                .filter(  gr -> gr.getPlayer1().getId() == playerId || gr.getPlayer2().getId() == playerId)
                .map( gr -> new GameRecord( playerId, gr ) )
                .sorted( Comparator.comparing( GameRecord::getGameResultId))
                .collect(Collectors.toList());
    }
}
