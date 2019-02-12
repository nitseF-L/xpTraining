package com.rps.core;

public interface PlayPracticeGameUseCase {

    Outcome execute( Request request );

    public class Request {
        public Throw player1Throw;
        public Throw player2Throw;
    }

}
