package com.rps.core;

public interface CreateGameResultUseCase {

    GameResult execute( CreateGameResultUseCase.Request request );

    public class Request {
        public Player player1;
        public Player player2;
        public Throw player1Throw;
        public Throw player2Throw;

        public Request(){}

        public Request(Player player1, Player player2, Throw player1Throw, Throw player2Throw) {
            this.player1 = player1;
            this.player2 = player2;
            this.player1Throw = player1Throw;
            this.player2Throw = player2Throw;
        }
    }
}
