package com.rps.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DefaultGetPlayersUseCaseTest {

    DefaultGetPlayersUseCase defaultGetPlayersUseCase;
    InMemoryPlayerRepository playerRepository;

    @Before
    public void setup(){
        playerRepository = new InMemoryPlayerRepository();
        defaultGetPlayersUseCase = new DefaultGetPlayersUseCase(playerRepository);

        playerRepository.players.add( new Player("Wonder Woman", 41));
        playerRepository.players.add( new Player("Black Panther", 42));
    }

    @Test
    public void execute_returnsPlayers(){

        List<Player> players = defaultGetPlayersUseCase.execute();

        Assert.assertEquals( 2, players.size() );
        Assert.assertEquals( "Wonder Woman", players.get(0).getName());
        Assert.assertEquals( 42, players.get(1).getId());

    }

}
