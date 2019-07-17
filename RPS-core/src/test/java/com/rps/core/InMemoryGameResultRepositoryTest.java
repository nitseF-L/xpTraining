package com.rps.core;

public class InMemoryGameResultRepositoryTest extends GameResultRepositoryTest {

    private InMemoryGameResultRepository inMemoryGameRepository = new InMemoryGameResultRepository();
    private InMemoryPlayerRepository inMemoryPlayerRepository = new InMemoryPlayerRepository();

    @Override
    protected GameResultRepository getGameResultRepository() {
        return inMemoryGameRepository;
    }

    @Override
    protected PlayerRepository getPlayerRepository() {
        return inMemoryPlayerRepository;
    }
}

