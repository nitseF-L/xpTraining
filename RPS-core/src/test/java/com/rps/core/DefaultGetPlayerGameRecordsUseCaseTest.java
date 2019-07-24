package com.rps.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DefaultGetPlayerGameRecordsUseCaseTest {

    DefaultGetPlayerGameRecordsUseCase defaultGetPlayerGameRecordsUseCase;
    DefaultCreateGameResultUseCase defaultCreateGameResultUseCase;
    InMemoryGameResultRepository gameResultRepository;
    GameResultIdProvider gameResultIdProvider;

    @Before
    public void setup() {
        gameResultRepository = new InMemoryGameResultRepository();
        gameResultIdProvider = new StubGameResultIdProvider();
        defaultGetPlayerGameRecordsUseCase = new DefaultGetPlayerGameRecordsUseCase(gameResultRepository);
        defaultCreateGameResultUseCase = new DefaultCreateGameResultUseCase(gameResultRepository, gameResultIdProvider);

        Player player1 = new Player("Wonder Woman", 41);
        Player player2 = new Player("Black Panther", 42);
        Player player3 = new Player("Iron Man", 43);
        Player player4 = new Player("Deadpool", 44);
        defaultCreateGameResultUseCase.execute(new CreateGameResultUseCase.Request(player1, player2, Throw.ROCK, Throw.SCISSORS));
        defaultCreateGameResultUseCase.execute(new CreateGameResultUseCase.Request(player2, player1, Throw.ROCK, Throw.PAPER));
        defaultCreateGameResultUseCase.execute(new CreateGameResultUseCase.Request(player1, player3, Throw.SCISSORS, Throw.PAPER));
        defaultCreateGameResultUseCase.execute(new CreateGameResultUseCase.Request(player2, player3, Throw.ROCK, Throw.PAPER));
        defaultCreateGameResultUseCase.execute(new CreateGameResultUseCase.Request(player2, player4, Throw.SCISSORS, Throw.SCISSORS));
        defaultCreateGameResultUseCase.execute(new CreateGameResultUseCase.Request(player2, player3, Throw.ROCK, Throw.SCISSORS));
        defaultCreateGameResultUseCase.execute(new CreateGameResultUseCase.Request(player4, player2, Throw.ROCK, Throw.PAPER));
        defaultCreateGameResultUseCase.execute(new CreateGameResultUseCase.Request(player4, player3, Throw.PAPER, Throw.SCISSORS));

    }

    @Test
    public void execute_returnsPlayerStats() {

        List<GameRecord> records = defaultGetPlayerGameRecordsUseCase.execute( 42 );
        Assert.assertEquals(6, records.size());
        Assert.assertEquals(41, records.get(0).getOpponent().getId());
        Assert.assertEquals(41, records.get(1).getOpponent().getId());
        Assert.assertEquals(43, records.get(2).getOpponent().getId());
        Assert.assertEquals(44, records.get(3).getOpponent().getId());
        Assert.assertEquals(43, records.get(4).getOpponent().getId());
        Assert.assertEquals(44, records.get(5).getOpponent().getId());
        Assert.assertEquals(Throw.ROCK, records.get(0).getOpponentThrow());
        Assert.assertEquals(Throw.PAPER, records.get(1).getOpponentThrow());
        Assert.assertEquals(Throw.SCISSORS, records.get(0).getPlayerThrow());
        Assert.assertEquals(Throw.ROCK, records.get(1).getPlayerThrow());

    }
}
