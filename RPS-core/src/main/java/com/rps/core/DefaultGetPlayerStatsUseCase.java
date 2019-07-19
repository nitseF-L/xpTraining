package com.rps.core;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class DefaultGetPlayerStatsUseCase implements GetPlayerStatsUseCase {

    private GameResultRepository gameResultRepository;

    public DefaultGetPlayerStatsUseCase(GameResultRepository gameResultRepository) {
        this.gameResultRepository = gameResultRepository;
    }

    @Override
    public List<PlayerStat> execute() {
        List<GameResult> results = gameResultRepository.findAll();

        List<GameStat> gameStats = new ArrayList<>();

        Comparator<PlayerStat> reversePlayerStatComparator = (h1, h2) -> h2.winPercentage().compareTo(h1.winPercentage());

//        gameStats.addAll( results.stream()
//                .map( gr -> GameStat.getStats( gr ) )
//                .flatMap( gs -> Arrays.stream(gs))
//                .collect(Collectors.toList()));

//        Map<Player,PlayerStat> playerStats =
        return  results.stream()
                .map( gr -> GameStat.getStats( gr ) )
                .flatMap( gs -> Arrays.stream(gs))
                .map( gs -> new PlayerStat( gs ))
                .collect( Collectors
                        .toMap( PlayerStat::getPlayer, p -> p, (ps1, ps2) -> ps1.merge( ps2 ))
                ).values().stream()
                .sorted( reversePlayerStatComparator )
                .collect(Collectors.toList());

//        gameStats.addAll( results.stream()
//                .map( gr -> GameStat.getStats( gr ) )
//                .flatMap( gs -> Arrays.stream(gs))
//                .collect(Collectors.toList()));
//
////        Map<Player,PlayerStat> playerStats =
//          return  gameStats.stream()
//                .map( gs -> new PlayerStat( gs ))
//                .collect( Collectors
//                .toMap( PlayerStat::getPlayer, p -> p, (ps1, ps2) -> ps1.merge( ps2 ))
//                ).values().stream()
//                .sorted( reversePlayerStatComparator )
//                .collect(Collectors.toList());

//        return playerStats.values().stream().sorted( reversePlayerStatComparator )
//                .collect(Collectors.toList());

//        return playerStats.entrySet().stream()
//                .sorted( (ps1,ps2) -> Double.compare( ps1.getValue().winPercentage(), ps2.getValue().winPercentage() ) )
//                .collect(Collectors.toList());
    }
}
