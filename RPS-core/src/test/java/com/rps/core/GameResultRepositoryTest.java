package com.rps.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class GameResultRepositoryTest {

    GameResultRepository gameResultRepository;
    PlayerRepository playerRepository;

    protected abstract GameResultRepository getGameResultRepository();
    protected abstract PlayerRepository getPlayerRepository();

    @BeforeEach
    public void setup() {
        gameResultRepository = getGameResultRepository();
        playerRepository = getPlayerRepository();
    }

    @Test
    public void canGetResults(){
        Player player1 = new Player("Jane Doe", 1 );
        playerRepository.save( player1 );
        Player player2 = new Player("John Doe", 2 );
        playerRepository.save( player2 );
        GameResult gameResult = new GameResult(player1, player2, Outcome.P1_WINS, Throw.ROCK, Throw.PAPER, 1 );
        gameResultRepository.save( gameResult );
        List<GameResult> gameResults = gameResultRepository.findAll();
        assertEquals( 1, gameResults.size() );
        assertEquals( true, gameResult.equals( gameResults.get(0) ) );
    }

    @Test
    public void canGetResultsById(){
        Player player1 = new Player("Jane Smith", 1 );
        playerRepository.save( player1 );
        Player player2 = new Player("John Smith", 2 );
        playerRepository.save( player2 );
        GameResult gameResult = new GameResult(player1, player2, Outcome.P1_WINS, Throw.PAPER, Throw.ROCK, 1 );
        gameResultRepository.save( gameResult );
        gameResult = new GameResult(player1, player2, Outcome.P2_WINS, Throw.PAPER, Throw.SCISSORS, 2 );
        gameResultRepository.save( gameResult );
        GameResult gameResultById = gameResultRepository.findById(2);
        assertEquals(gameResultById.getOutcome(), Outcome.P2_WINS );
        assertEquals( true, gameResult.equals( gameResultById ));
        gameResultById = gameResultRepository.findById(1);
        assertEquals(gameResultById.getOutcome(), Outcome.P1_WINS );
    }

}
