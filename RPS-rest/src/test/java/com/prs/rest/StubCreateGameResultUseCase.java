package com.prs.rest;

import com.rps.core.CreateGameResultUseCase;
import com.rps.core.GameResult;
import com.rps.core.Outcome;
import com.rps.core.Player;

public class StubCreateGameResultUseCase implements CreateGameResultUseCase {

    public GameResult stubbedCreateGameResultUseCaseResponse =
            new GameResult(
                    new Player("Jane Doe", "1"),
                    new Player("John Doe", "2"),
                    Outcome.P1_WINS,
                    42
                    );
    public Request executeCalledWith;

    @Override
    public GameResult execute(Request request) {
        executeCalledWith = request;
        return stubbedCreateGameResultUseCaseResponse;
    }
}
