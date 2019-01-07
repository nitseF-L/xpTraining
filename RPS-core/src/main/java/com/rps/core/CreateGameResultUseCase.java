package com.rps.core;

public interface CreateGameResultUseCase {

    GameResult execute( CreateGameResultUseCase.Request request );

    public class Request {
        public Player player1;
        public Player player2;
        public Throw player1Throw;
        public Throw player2Throw;
    }
}
