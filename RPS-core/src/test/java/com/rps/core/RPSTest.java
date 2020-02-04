package com.rps.core;

import org.junit.jupiter.api.Test;

import static com.rps.core.Outcome.*;
import static com.rps.core.Throw.*;
import static org.junit.jupiter.api.Assertions.*;

public class RPSTest {

    @Test
    public void RockVsLizard(){ assertEquals(P1_WINS, RPS.play(ROCK, LIZARD)); }

    @Test
    public void RockVsSpock(){ assertEquals(P2_WINS, RPS.play(ROCK, SPOCK)); }

    @Test
    public void LizardVsSpock(){ assertEquals(P1_WINS, RPS.play(LIZARD, SPOCK));}

    @Test
    public void LizardVsRock(){ assertEquals(P2_WINS, RPS.play(LIZARD, ROCK));}

    @Test
    public void SpockVsRock() { assertEquals(P1_WINS, RPS.play(SPOCK, ROCK));}

    @Test
    public void SpockVsLizard() { assertEquals(P2_WINS, RPS.play(SPOCK, LIZARD));}

    @Test
    public void SpockVsSpock() { assertEquals(TIE, RPS.play(SPOCK, SPOCK));}

    @Test
    public void RockVsRock() { assertEquals(TIE, RPS.play(ROCK, ROCK));}

    @Test
    public void LizardVsLizard() { assertEquals(TIE, RPS.play(LIZARD, LIZARD));}

}
