package com.rps.core;

import static com.rps.core.RPS.play;

public class DefaultPlayPracticeGameUseCase implements PlayPracticeGameUseCase {
    @Override
    public Outcome execute(Request request) {
        return play( request.player1Throw, request.player2Throw);
    }
}
