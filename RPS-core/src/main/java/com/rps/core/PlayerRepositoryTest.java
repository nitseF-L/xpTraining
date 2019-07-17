package com.rps.core;

import jdk.internal.dynalink.linker.LinkerServices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public abstract class PlayerRepositoryTest {

    PlayerRepository playerRepository;

    protected abstract PlayerRepository getPlayerRepository();

    @Before
    public void setup() {
        playerRepository = getPlayerRepository();
        playerRepository.save( new Player(  "Wonder Woman", 1));
        playerRepository.save( new Player( "Deadpool", 8));
    }

    @Test
    public void canGetPlayerList() {
        List<Player> playerList = playerRepository.findAll();
        Assert.assertEquals( 8, playerList.size() );
        Assert.assertEquals( "Wonder Woman", playerList.get(0).getName());
        Assert.assertEquals( 1, playerList.get(0).getId());
        Assert.assertEquals( "Deadpool", playerList.get(7).getName());
        Assert.assertEquals( 8, playerList.get(7).getId());
    }
}
