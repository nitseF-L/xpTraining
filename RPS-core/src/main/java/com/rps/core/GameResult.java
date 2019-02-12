package com.rps.core;


public class GameResult {
    private Player player1;
    private Player player2;
    private Outcome outcome;
    private int gameResultId;

    public GameResult(Player player1, Player player2, Outcome outcome, int gameResultId) {
        this.player1 = player1;
        this.player2 = player2;
        this.outcome = outcome;
        this.gameResultId = gameResultId;
    }

    public GameResult(GameResult gameResult) {
        this.player1 = gameResult.player1;
        this.player2 = gameResult.player2;
        this.outcome = gameResult.outcome;
        this.gameResultId = gameResult.gameResultId;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public int getGameResultId() {
        return gameResultId;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public void setGameResultId(int gameResultId) {
        this.gameResultId = gameResultId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameResult)) return false;
        GameResult that = (GameResult) o;
        return getPlayer1().equals( that.getPlayer1()) &&
                getPlayer2().equals( that.getPlayer2()) &&
                getOutcome() == that.getOutcome() &&
                getGameResultId() == that.getGameResultId();
    }

    @Override
    public int hashCode() {
        return getPlayer1().hashCode() + getPlayer2().hashCode() + getOutcome().hashCode();
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                ", outcome=" + outcome +
                '}';
    }
}
