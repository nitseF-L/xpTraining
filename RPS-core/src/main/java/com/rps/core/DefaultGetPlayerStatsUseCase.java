package com.rps.core;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DefaultGetPlayerStatsUseCase implements GetPlayerStatsUseCase {

    private GameResultRepository gameResultRepository;

    public DefaultGetPlayerStatsUseCase(GameResultRepository gameResultRepository) {
        this.gameResultRepository = gameResultRepository;
    }

    @Override
    public List<PlayerStat> execute() {

        Comparator<PlayerStat> reversePlayerStatComparator = (h1, h2) -> h2.getWinPercentage().compareTo(h1.getWinPercentage());

        Object xxx = gameResultRepository.findAll().stream()
                .flatMap( gr -> Stream.of( new GameRecord( gr.getPlayer1().getId(), gr),
                        new GameRecord( gr.getPlayer2().getId(), gr)) ).collect(Collectors.groupingBy(GameRecord::getPlayer))
                .entrySet().stream()
                .collect(Collectors.toMap( x -> {
                    int sumWins = x.getValue().stream().mapToInt( gr -> (gr.getResult() == GameRecord.Result.WON) ? 1 : 0).sum();
                    int sumLoses = x.getValue().stream().mapToInt( gr -> (gr.getResult() == GameRecord.Result.LOSS) ? 1 : 0).sum();
                    int sumTies = x.getValue().stream().mapToInt( gr -> (gr.getResult() == GameRecord.Result.TIE) ? 1 : 0).sum();
                    return new PlayerStat(x.getKey(), sumWins, sumLoses, sumTies);
                }, Map.Entry::getValue))
                .keySet()
                ;

        Map<Player, Map<GameRecord.Result,Long>> stats =  gameResultRepository.findAll().stream()
                .flatMap( gr -> Stream.of( new GameRecord( gr.getPlayer1().getId(), gr),
                                            new GameRecord( gr.getPlayer2().getId(), gr)) )
                .collect(Collectors.groupingBy( GameRecord::getPlayer,
                                Collectors.groupingBy( GameRecord::getResult, Collectors.counting() )
                ));

        return stats.entrySet().stream()
                .map( e -> new PlayerStat( e.getKey(),
                            Optional.ofNullable(e.getValue().get( GameRecord.Result.WON)).orElse( 0L ),
                            Optional.ofNullable(e.getValue().get( GameRecord.Result.LOSS)).orElse( 0L ),
                            Optional.ofNullable(e.getValue().get( GameRecord.Result.TIE)).orElse( 0L ) ) )
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

//    private long getValue( Map<GameStat.Result,Long> map, GameStat.Result gameResult ) {
//        if( map.containsKey(gameResult)) {
//            return map.get(gameResult);
//        }
//        return 0;
//    }
}
