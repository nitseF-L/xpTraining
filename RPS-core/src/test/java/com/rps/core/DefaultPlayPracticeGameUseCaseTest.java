package com.rps.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.rps.core.Outcome.*;
import static com.rps.core.Throw.*;

public class DefaultPlayPracticeGameUseCaseTest {

    DefaultPlayPracticeGameUseCase defaultCreateGameResultUseCase;

    @Before
    public void setup(){

        defaultCreateGameResultUseCase = new DefaultPlayPracticeGameUseCase( );
    }

    @Test
    public void execute_returnsTheResult(){


        PlayPracticeGameUseCase.Request request = new PlayPracticeGameUseCase.Request( );

        request.player1Throw = ROCK;
        request.player2Throw = SCISSORS;

        Outcome outcome = defaultCreateGameResultUseCase.execute( request );

        Assert.assertEquals( P1_WINS, outcome );

        request.player1Throw = SCISSORS;
        request.player2Throw = ROCK;

        outcome = defaultCreateGameResultUseCase.execute( request );

        Assert.assertEquals( P2_WINS, outcome );

        request.player1Throw = ROCK;
        request.player2Throw = ROCK;

        outcome = defaultCreateGameResultUseCase.execute( request );

        Assert.assertEquals( TIE, outcome );





    }
}
