package com.rps.core;

public class GameRecord {

    private int gameResultId;
    private Player player;
    private Player opponent;
    private Result result;
    private Throw playerThrow;
    private Throw opponentThrow;

    enum Result { WON, LOSS, TIE }

    public GameRecord( int playerId, GameResult gameResult ){

        gameResultId = gameResult.getGameResultId();

        if( playerId == gameResult.getPlayer1().getId() ){
            player = gameResult.getPlayer1();
            opponent = gameResult.getPlayer2();
            playerThrow = gameResult.getPlayer1Throw();
            opponentThrow = gameResult.getPlayer2Throw();
            switch ( gameResult.getOutcome() ){
                case TIE:   result = Result.TIE;
                break;
                case P1_WINS:   result = Result.WON;
                break;
                case P2_WINS:   result = Result.LOSS;
                break;
            }
        } else {
            player = gameResult.getPlayer2();
            opponent = gameResult.getPlayer1();
            playerThrow = gameResult.getPlayer2Throw();
            opponentThrow = gameResult.getPlayer1Throw();
            switch ( gameResult.getOutcome() ){
                case TIE:   result = Result.TIE;
                    break;
                case P1_WINS:   result = Result.LOSS;
                    break;
                case P2_WINS:   result = Result.WON;
                    break;
            }
        }
    }

    public int getGameResultId() {
        return gameResultId;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getOpponent() {
        return opponent;
    }

    public Result getResult() {
        return result;
    }

    public Throw getPlayerThrow() {
        return playerThrow;
    }

    public Throw getOpponentThrow() {
        return opponentThrow;
    }
}
