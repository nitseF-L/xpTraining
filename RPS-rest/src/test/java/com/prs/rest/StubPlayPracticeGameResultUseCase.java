package com.prs.rest;

import com.rps.core.Outcome;
import com.rps.core.PlayPracticeGameUseCase;

public class StubPlayPracticeGameResultUseCase implements PlayPracticeGameUseCase {

    public Response stubbedPlayPracticeGameUseCaseResponse =
            new Response(
                    Outcome.P2_WINS
            );

    public Request executeCalledWith;

    @Override
    public Response execute(Request request) {
        executeCalledWith = request;
        return stubbedPlayPracticeGameUseCaseResponse;
    }
}
