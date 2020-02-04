package com.rps.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.rps.core.Outcome.*;
import static com.rps.core.Throw.*;
import static org.junit.jupiter.api.Assertions.*;

public class DefaultPlayPracticeGameUseCaseTest {

    DefaultPlayPracticeGameUseCase defaultCreateGameResultUseCase;

    @BeforeEach
    public void setup(){

        defaultCreateGameResultUseCase = new DefaultPlayPracticeGameUseCase( );
    }

    @Test
    public void execute_returnsTheResult(){


        PlayPracticeGameUseCase.Request request = new PlayPracticeGameUseCase.Request( );

        request.player1Throw = ROCK;
        request.player2Throw = SPOCK;

        PlayPracticeGameUseCase.Response response = defaultCreateGameResultUseCase.execute( request );

        assertEquals( P1_WINS, response.outcome );

        request.player1Throw = SPOCK;
        request.player2Throw = ROCK;

        response = defaultCreateGameResultUseCase.execute( request );

        assertEquals( P2_WINS, response.outcome );

        request.player1Throw = ROCK;
        request.player2Throw = ROCK;

        response = defaultCreateGameResultUseCase.execute( request );

        assertEquals( TIE, response.outcome );
    }
}
