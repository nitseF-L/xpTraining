package com.prs.rest;

import com.rps.core.*;

public class StubCreateGameResultUseCase implements CreateGameResultUseCase {

    public GameResult stubbedCreateGameResultUseCaseResponse =
            new GameResult(
                    PlayerFactory.buildPlayer(),
                    PlayerFactory.buildPlayer(),
                    Outcome.P1_WINS,
                    Throw.ROCK, Throw.SCISSORS, 42
                    );
    public Request executeCalledWith;

    @Override
    public GameResult execute(Request request) {
        executeCalledWith = request;
        return stubbedCreateGameResultUseCaseResponse;
    }
}
