package com.rps.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DefaultGetPlayerStatsUseCaseTest {

    DefaultGetPlayerStatsUseCase defaultGetPlayerStatsUseCase;
    DefaultCreateGameResultUseCase defaultCreateGameResultUseCase;
    InMemoryGameResultRepository gameResultRepository;
    InMemoryPlayerRepository playerRepository;
    GameResultIdProvider gameResultIdProvider;

    @Before
    public void setup() {
        gameResultRepository = new InMemoryGameResultRepository();
        gameResultIdProvider = new StubGameResultIdProvider();
        playerRepository = new InMemoryPlayerRepository();
        defaultGetPlayerStatsUseCase = new DefaultGetPlayerStatsUseCase(gameResultRepository, playerRepository);
        defaultCreateGameResultUseCase = new DefaultCreateGameResultUseCase(gameResultRepository, gameResultIdProvider);

        Player player1 = new Player("Wonder Woman", 41);
        Player player2 = new Player("Black Panther", 42);
        Player player3 = new Player("Iron Man", 43);
        Player player4 = new Player("Deadpool", 44);
        playerRepository.save(player1);
        playerRepository.save(player2);
        playerRepository.save(player3);
        playerRepository.save(player4);
        defaultCreateGameResultUseCase.execute(new CreateGameResultUseCase.Request(player1, player2, Throw.ROCK, Throw.SCISSORS));
        defaultCreateGameResultUseCase.execute(new CreateGameResultUseCase.Request(player2, player1, Throw.SCISSORS, Throw.ROCK));
        defaultCreateGameResultUseCase.execute(new CreateGameResultUseCase.Request(player1, player3, Throw.ROCK, Throw.SCISSORS));
        defaultCreateGameResultUseCase.execute(new CreateGameResultUseCase.Request(player2, player3, Throw.ROCK, Throw.PAPER));
        defaultCreateGameResultUseCase.execute(new CreateGameResultUseCase.Request(player2, player4, Throw.SCISSORS, Throw.SCISSORS));
        defaultCreateGameResultUseCase.execute(new CreateGameResultUseCase.Request(player2, player3, Throw.ROCK, Throw.SCISSORS));
        defaultCreateGameResultUseCase.execute(new CreateGameResultUseCase.Request(player4, player2, Throw.ROCK, Throw.PAPER));
        defaultCreateGameResultUseCase.execute(new CreateGameResultUseCase.Request(player4, player3, Throw.PAPER, Throw.SCISSORS));

        }

    @Test
    public void execute_returnsPlayerStats() {

        List<PlayerStat> stats = defaultGetPlayerStatsUseCase.execute();
        Assert.assertEquals(4, stats.size());
        Assert.assertEquals(41, stats.get(0).getPlayer().getId());
        Assert.assertEquals(43, stats.get(1).getPlayer().getId());
        Assert.assertEquals(42, stats.get(2).getPlayer().getId());
        Assert.assertEquals(44, stats.get(3).getPlayer().getId());
        Assert.assertEquals(100.0, stats.get(0).getWinPercentage(), 0.001);
        Assert.assertEquals(50.0, stats.get(1).getWinPercentage(), 0.001);
        Assert.assertEquals(41.666, stats.get(2).getWinPercentage(), 0.001);
        Assert.assertEquals(16.666, stats.get(3).getWinPercentage(), 0.001);
        Assert.assertEquals(100.0, stats.get(0).getRockPercent(), 0.001);
        Assert.assertEquals(0.0, stats.get(0).getPaperPercent(), 0.001);
        Assert.assertEquals(0.0, stats.get(0).getScissorsPercent(), 0.001);
        Assert.assertEquals(33.333, stats.get(2).getRockPercent(), 0.001);
        Assert.assertEquals(16.666, stats.get(2).getPaperPercent(), 0.001);
        Assert.assertEquals(50.0, stats.get(2).getScissorsPercent(), 0.001);

        }
}

