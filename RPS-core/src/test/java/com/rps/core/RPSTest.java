package com.rps.core;

import org.junit.Assert;
import org.junit.Test;

import static com.rps.core.Outcome.*;
import static com.rps.core.Throw.*;

public class RPSTest {

    @Test
    public void RockVsScissors(){ Assert.assertEquals(P1_WINS, RPS.play(ROCK, SCISSORS)); }

    @Test
    public void ScissorsVsRock(){
        Assert.assertEquals(P2_WINS, RPS.play(SCISSORS, ROCK));
    }

    @Test
    public void ScissorsVsPaper(){
        Assert.assertEquals(P1_WINS, RPS.play(SCISSORS, PAPER));
    }

    @Test
    public void PaperVsScissors(){
        Assert.assertEquals(P2_WINS, RPS.play(PAPER, SCISSORS));
    }

    @Test
    public void PaperVsRock(){
        Assert.assertEquals(P1_WINS, RPS.play(PAPER, ROCK));
    }

    @Test
    public void RockVsPaper(){
        Assert.assertEquals(P2_WINS, RPS.play(ROCK, PAPER));
    }

    @Test
    public void RockVsRock(){
        Assert.assertEquals(TIE, RPS.play(ROCK, ROCK));
    }

    @Test
    public void PaperVsPaper(){
        Assert.assertEquals(TIE, RPS.play(PAPER, PAPER));
    }

    @Test
    public void ScissorsVsScissors(){
        Assert.assertEquals(TIE, RPS.play(SCISSORS, SCISSORS));
    }
}
