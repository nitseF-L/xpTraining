package com.rps.core;

import static com.rps.core.RPS.play;

public class DefaultPlayPracticeGameUseCase implements PlayPracticeGameUseCase {
    @Override
    public Response execute(Request request) {
        return new Response( play( request.player1Throw, request.player2Throw) );
    }
}
