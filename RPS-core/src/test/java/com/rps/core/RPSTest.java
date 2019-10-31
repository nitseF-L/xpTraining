package com.rps.core;

import org.junit.jupiter.api.Test;

import static com.rps.core.Outcome.*;
import static com.rps.core.Throw.*;
import static org.junit.jupiter.api.Assertions.*;

public class RPSTest {

    @Test
    public void RockVsScissors(){ assertEquals(P1_WINS, RPS.play(ROCK, SCISSORS)); }

    @Test
    public void ScissorsVsRock(){
        assertEquals(P2_WINS, RPS.play(SCISSORS, ROCK));
    }

    @Test
    public void ScissorsVsPaper(){
        assertEquals(P1_WINS, RPS.play(SCISSORS, PAPER));
    }

    @Test
    public void PaperVsScissors(){ assertEquals(P2_WINS, RPS.play(PAPER, SCISSORS)); }

    @Test
    public void PaperVsRock(){
        assertEquals(P1_WINS, RPS.play(PAPER, ROCK));
    }

    @Test
    public void RockVsPaper(){
        assertEquals(P2_WINS, RPS.play(ROCK, PAPER));
    }

    @Test
    public void RockVsRock(){
        assertEquals(TIE, RPS.play(ROCK, ROCK));
    }

    @Test
    public void PaperVsPaper(){
        assertEquals(TIE, RPS.play(PAPER, PAPER));
    }

    @Test
    public void ScissorsVsScissors(){
        assertEquals(TIE, RPS.play(SCISSORS, SCISSORS));
    }
}
