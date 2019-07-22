package com.rps.core;

public class PlayerStat {

    private Player player;
    private long gamesWon;
    private long gamesLost;
    private long gamesTied;

    public PlayerStat (){
        player = null;
    }

    public PlayerStat(Player player, long gamesWon, long gamesLost, long gamesTied) {
        this.player = player;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
        this.gamesTied = gamesTied;
    }

    public PlayerStat( GameStat gameStat ) {
        this.player = gameStat.getPlayer();
        switch ( gameStat.getResult() ){
            case TIE: gamesTied = 1;
                    break;
            case WON: gamesWon = 1;
                    break;
            case LOSS: gamesLost =1;
                    break;
        }
    }

    public Double getWinPercentage(){
        return (gamesWon + (gamesTied * .5)) / getGamesPlayed() * 100;
    }

    public PlayerStat merge( PlayerStat ps ){
        gamesWon += ps.gamesWon;
        gamesTied += ps.gamesTied;
        gamesLost += ps.gamesLost;
        return this;
    }

    public PlayerStat merge( GameStat gameStat ){
        if( player == null )
            player = gameStat.getPlayer();

        switch ( gameStat.getResult() ){
            case TIE: gamesTied++;
                break;
            case WON: gamesWon++;
                break;
            case LOSS: gamesLost++;
                break;
        }
        return this;
    }

    public long getGamesPlayed(){
        return gamesWon + gamesLost + gamesTied;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public long getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(long gamesWon) {
        this.gamesWon = gamesWon;
    }

    public long getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(long gamesLost) {
        this.gamesLost = gamesLost;
    }

    public long getGamesTied() {
        return gamesTied;
    }

    public void setGamesTied(long gamesTied) {
        this.gamesTied = gamesTied;
    }
}
