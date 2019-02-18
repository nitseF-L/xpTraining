package com.rps.core;

public interface PlayPracticeGameUseCase {

    Response execute( Request request );

    public class Request {
        public Throw player1Throw;
        public Throw player2Throw;
    }

    public class Response {
        public Outcome outcome;

        public Response(Outcome outcome) {
            this.outcome = outcome;
        }
    }

}
