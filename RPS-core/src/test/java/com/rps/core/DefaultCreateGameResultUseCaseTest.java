package com.rps.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DefaultCreateGameResultUseCaseTest {

    DefaultCreateGameResultUseCase defaultCreateGameResultUseCase;
    GameResultRepository gameResultRepository;
    GameResultIdProvider gameResultIdProvider;

    @Before
    public void setup(){
        gameResultRepository = new InMemoryGameResultRepository();
        gameResultIdProvider = new StubGameResultIdProvider();
        defaultCreateGameResultUseCase = new DefaultCreateGameResultUseCase(gameResultRepository, gameResultIdProvider );
    }

    @Test
    public void execute_persistsTheResult(){
        Player player1 = new Player( "Jane Doe", 1);
        Player player2 = new Player("John Doe", 2);

        CreateGameResultUseCase.Request request = new CreateGameResultUseCase.Request( );
        request.player1 = player1;
        request.player2 = player2;
        request.player1Throw = Throw.ROCK;
        request.player2Throw = Throw.SCISSORS;

        GameResult gameResult = defaultCreateGameResultUseCase.execute( request );

        Assert.assertEquals( gameResult.getOutcome(), Outcome.P1_WINS );

        GameResult repoGameResult = gameResultRepository.findById( gameResult.getGameResultId() );
        Assert.assertEquals( repoGameResult.getPlayer1(), player1 );
        Assert.assertEquals( repoGameResult.getPlayer2(), player2 );
        Assert.assertEquals( repoGameResult.getOutcome(), Outcome.P1_WINS );
        Assert.assertEquals( repoGameResult.getGameResultId(), gameResult.getGameResultId() );

    }
    @Test
    public void execute_samePlayerDoesNotPersistsTheResult(){
        Player player1 = new Player ("Jane Doe",1);

        CreateGameResultUseCase.Request request = new CreateGameResultUseCase.Request();
        request.player1 = player1;
        request.player2 = player1;
        request.player1Throw = Throw.ROCK;

        GameResult gameResult = defaultCreateGameResultUseCase.execute(request);

        Assert.assertEquals (gameResult.getOutcome(), Outcome.INVALID);

        List <GameResult> gameResults = gameResultRepository.findAll();

        Assert.assertEquals(0,gameResults.size());

        GameResult repoGameResult = gameResultRepository.findById( gameResult.getGameResultId() );
        Assert.assertEquals( null, repoGameResult);

    }
}
