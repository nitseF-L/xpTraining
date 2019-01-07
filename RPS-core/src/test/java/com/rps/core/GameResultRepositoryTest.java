package com.rps.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public abstract class GameResultRepositoryTest {

    GameResultRepository gameResultRepository;

    protected abstract GameResultRepository getGameResultRepository();

    @Before
    public void setup() { gameResultRepository = getGameResultRepository(); }

    @Test
    public void canGetResults(){
        Player player1 = new Player("Jane Doe", "001" );
        Player player2 = new Player("John Doe", "002" );
        GameResult gameResult = new GameResult(player1, player2, Outcome.P1_WINS, 1 );
        gameResultRepository.save( gameResult );
        List<GameResult> gameResults = gameResultRepository.findAll();
        Assert.assertEquals(gameResults.size(), 1 );
        Assert.assertEquals( gameResults.get(0), gameResult );
    }

    @Test
    public void canGetResultsById(){
        Player player1 = new Player("Jane Doe", "001" );
        Player player2 = new Player("John Doe", "002" );
        GameResult gameResult = new GameResult(player1, player2, Outcome.P1_WINS, 1 );
        gameResultRepository.save( gameResult );
        gameResult = new GameResult(player1, player2, Outcome.P2_WINS, 2 );
        gameResultRepository.save( gameResult );
        GameResult gameResultById = gameResultRepository.findById(2);
        Assert.assertEquals(gameResultById.getOutcome(), Outcome.P2_WINS );
        gameResultById = gameResultRepository.findById(1);
        Assert.assertEquals(gameResultById.getOutcome(), Outcome.P1_WINS );
    }

}
