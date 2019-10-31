package com.rps.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultGetPlayersUseCaseTest {

    DefaultGetPlayersUseCase defaultGetPlayersUseCase;
    InMemoryPlayerRepository playerRepository;

    @BeforeEach
    public void setup(){
        playerRepository = new InMemoryPlayerRepository();
        defaultGetPlayersUseCase = new DefaultGetPlayersUseCase(playerRepository);

        playerRepository.save( new Player("Wonder Woman", 41));
        playerRepository.save( new Player("Black Panther", 42));
    }

    @Test
    public void execute_returnsPlayers(){

        List<Player> players = defaultGetPlayersUseCase.execute();

        assertEquals( 2, players.size() );
        assertEquals( "Wonder Woman", players.get(0).getName());
        assertEquals( "Black Panther", players.get(1).getName());
        assertEquals( 41, players.get(0).getId());
        assertEquals( 42, players.get(1).getId());

    }

}
