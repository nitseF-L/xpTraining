package com.rps.core;

public class InMemoryGameResultRepositoryTest extends GameResultRepositoryTest {

    private InMemoryGameResultRepository inMemoryGameRepository = new InMemoryGameResultRepository();

    @Override
    protected GameResultRepository getGameResultRepository() {
        return inMemoryGameRepository;
    }
}

