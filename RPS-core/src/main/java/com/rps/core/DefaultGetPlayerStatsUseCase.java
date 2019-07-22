package com.rps.core;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DefaultGetPlayerStatsUseCase implements GetPlayerStatsUseCase {

    private GameResultRepository gameResultRepository;

    public DefaultGetPlayerStatsUseCase(GameResultRepository gameResultRepository) {
        this.gameResultRepository = gameResultRepository;
    }

    @Override
    public List<PlayerStat> execute() {

        Comparator<PlayerStat> reversePlayerStatComparator = (h1, h2) -> h2.winPercentage().compareTo(h1.winPercentage());

//        Supplier< PlayerStat > supplier = () -> {
//            return new PlayerStat();
//        };
        Map<Player, Map<GameStat.Result,Long>> stats =  gameResultRepository.findAll().stream()
                .flatMap( gr -> Stream.of( new GameStat( gr, true), new GameStat( gr, false)) )
                .collect(Collectors.groupingBy( GameStat::getPlayer,
                                Collectors.groupingBy( GameStat::getResult, Collectors.counting() )
                ));

        return stats.entrySet().stream().map( e -> new PlayerStat( e.getKey(),
                getValue( e.getValue(), GameStat.Result.WON),
                getValue(e.getValue(), GameStat.Result.LOSS),
                getValue(e.getValue(), GameStat.Result.TIE)) )
                .sorted( reversePlayerStatComparator )
                .collect(Collectors.toList());



//        return  gameResultRepository.findAll().stream()
//                .flatMap( gr -> Stream.of( new GameStat( gr, true), new GameStat( gr, false)) )
//                .collect( Collectors
//                        .toMap( GameStat::getPlayer, gs -> new PlayerStat(gs), (ps1, ps2) -> ps1.merge( ps2 ))
//                ).values().stream()
//                .sorted( reversePlayerStatComparator )
//                .collect(Collectors.toList());


//        return  gameResultRepository.findAll().stream()
//                .map( gr -> GameStat.getStats( gr ) )
//                .flatMap( gs -> Arrays.stream(gs))
//                .map( gs -> new PlayerStat( gs ))
//                .collect( Collectors
//                        .toMap( PlayerStat::getPlayer, p -> p, (ps1, ps2) -> ps1.merge( ps2 ))
//                ).values().stream()
//                .sorted( reversePlayerStatComparator )
//                .collect(Collectors.toList());

    }

    private long getValue( Map<GameStat.Result,Long> map, GameStat.Result gameResult ) {
        if( map.containsKey(gameResult)) {
            return map.get(gameResult);
        }
        return 0;
    }
}
