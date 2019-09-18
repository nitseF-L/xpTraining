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
    public void ScissorsVsScissors() { Assert.assertEquals(TIE, RPS.play(SCISSORS, SCISSORS)); }

    @Test
    public void LizardVsSpock(){ Assert.assertEquals(P1_WINS, RPS.play(LIZARD, SPOCK)); }

    @Test
    public void SpockVsLizard(){ Assert.assertEquals(P2_WINS, RPS.play(SPOCK, LIZARD)); }

    @Test
    public void LizardVsPaper(){
        Assert.assertEquals(P1_WINS, RPS.play(LIZARD, PAPER ));
    }

    @Test
    public void PaperVsLizard(){ Assert.assertEquals(P2_WINS, RPS.play(PAPER, LIZARD)); }

    @Test
    public void RockVsLizard(){ Assert.assertEquals(P1_WINS, RPS.play(ROCK, LIZARD)); }

    @Test
    public void LizardVsRock(){ Assert.assertEquals(P2_WINS, RPS.play(LIZARD, ROCK)); }

    @Test
    public void LizardVsLizard(){
        Assert.assertEquals(TIE, RPS.play(LIZARD, LIZARD));
    }

    @Test
    public void LizardVsScissors(){ Assert.assertEquals(P2_WINS, RPS.play(LIZARD, SCISSORS)); }

    @Test
    public void ScissorsVsLizard(){ Assert.assertEquals(P1_WINS, RPS.play(SCISSORS, LIZARD)); }

    @Test
    public void SpockVsScissors() { Assert.assertEquals(P1_WINS, RPS.play(SPOCK, SCISSORS)); }

    @Test
    public void ScissorsVsSpock(){ Assert.assertEquals(P2_WINS, RPS.play(SCISSORS, SPOCK)); }

    @Test
    public void SpockVsSpock(){ Assert.assertEquals(TIE, RPS.play(SPOCK, SPOCK));  }

    @Test
    public void SpockVsRock(){ Assert.assertEquals(P1_WINS, RPS.play(SPOCK, ROCK)); }

    @Test
    public void PaperVsSpock(){ Assert.assertEquals(P1_WINS, RPS.play(PAPER, SPOCK)); }

    @Test
    public void SpockVsPaper(){ Assert.assertEquals(P2_WINS, RPS.play(SPOCK, PAPER)); }

    @Test
    public void RockVsSpock(){ Assert.assertEquals(P2_WINS, RPS.play(ROCK, SPOCK)); }
}
