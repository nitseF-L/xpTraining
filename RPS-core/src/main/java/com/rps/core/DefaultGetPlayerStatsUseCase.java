package com.rps.core;

import java.util.*;
import java.util.stream.Collectors;

public class DefaultGetPlayerStatsUseCase implements GetPlayerStatsUseCase {

    private GameResultRepository gameResultRepository;

    public DefaultGetPlayerStatsUseCase(GameResultRepository gameResultRepository) {
        this.gameResultRepository = gameResultRepository;
    }

    @Override
    public List<PlayerStat> execute() {

        Comparator<PlayerStat> reversePlayerStatComparator = (h1, h2) -> h2.winPercentage().compareTo(h1.winPercentage());

        return  gameResultRepository.findAll().stream()
                .map( gr -> GameStat.getStats( gr ) )
                .flatMap( gs -> Arrays.stream(gs))
                .map( gs -> new PlayerStat( gs ))
                .collect( Collectors
                        .toMap( PlayerStat::getPlayer, p -> p, (ps1, ps2) -> ps1.merge( ps2 ))
                ).values().stream()
                .sorted( reversePlayerStatComparator )
                .collect(Collectors.toList());

    }
}
