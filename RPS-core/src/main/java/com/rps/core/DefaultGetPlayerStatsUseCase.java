package com.rps.core;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DefaultGetPlayerStatsUseCase implements GetPlayerStatsUseCase {

    private GameResultRepository gameResultRepository;
    private PlayerRepository playerRepository;

    public DefaultGetPlayerStatsUseCase(GameResultRepository gameResultRepository, PlayerRepository playerRepository) {
        this.gameResultRepository = gameResultRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public List<PlayerStat> execute() {

        Comparator<PlayerStat> reversePlayerStatComparator = (h1, h2) -> h2.getWinPercentage().compareTo(h1.getWinPercentage());

        Stream<PlayerStat> allPlayers = playerRepository.findAll().stream()
                .map( p -> new PlayerStat( p ));

        Stream<PlayerStat> games = gameResultRepository.findAll().stream()
                .flatMap( gr -> Stream.of(  new GameRecord( gr.getPlayer1().getId(), gr),
                                            new GameRecord( gr.getPlayer2().getId(), gr)) )
                .collect(Collectors.groupingBy(GameRecord::getPlayer))
                .entrySet().stream()
                .map( x -> {
                    int sumWins = x.getValue().stream().mapToInt( gr -> (gr.getResult() == GameRecord.Result.WON) ? 1 : 0).sum();
                    int sumLoses = x.getValue().stream().mapToInt( gr -> (gr.getResult() == GameRecord.Result.LOSS) ? 1 : 0).sum();
                    int sumTies = x.getValue().stream().mapToInt( gr -> (gr.getResult() == GameRecord.Result.TIE) ? 1 : 0).sum();
                    int sumRocks = x.getValue().stream().mapToInt( gr -> (gr.getPlayerThrow() == Throw.ROCK) ? 1 : 0).sum();
                    int sumPapers = x.getValue().stream().mapToInt( gr -> (gr.getPlayerThrow() == Throw.PAPER) ? 1 : 0).sum();
                    int sumScissors = x.getValue().stream().mapToInt( gr -> (gr.getPlayerThrow() == Throw.SCISSORS) ? 1 : 0).sum();
                    return new PlayerStat(x.getKey(), sumWins, sumLoses, sumTies, sumRocks, sumPapers, sumScissors);
                } );

        return Stream.concat( games, allPlayers )
                .filter(distinctByKey(PlayerStat::getPlayer))
                .sorted( reversePlayerStatComparator )
                .collect( Collectors.toList())
                ;

    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}
