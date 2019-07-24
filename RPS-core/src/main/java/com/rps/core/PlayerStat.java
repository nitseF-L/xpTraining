package com.rps.core;

public class PlayerStat {

    private Player player;
    private int gamesWon;
    private int gamesLost;
    private int gamesTied;
    private int rocksThrown;
    private int paperssThrown;
    private int scissorsThrown;

    public PlayerStat (){
        player = null;
    }

    public PlayerStat(Player player, int gamesWon, int gamesLost, int gamesTied, int rocksThrown, int paperssThrown, int scissorsThrown) {
        this.player = player;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
        this.gamesTied = gamesTied;
        this.rocksThrown = rocksThrown;
        this.paperssThrown = paperssThrown;
        this.scissorsThrown = scissorsThrown;
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

    public Double getRockPercent(){
        return 100.0 * rocksThrown / getGamesPlayed();
    }

    public Double getPaperPercent(){
        return 100.0 * paperssThrown / getGamesPlayed();
    }

    public Double getScissorsPercent(){
        return 100.0 * scissorsThrown / getGamesPlayed();
    }

//    public PlayerStat merge( PlayerStat ps ){
//        gamesWon += ps.gamesWon;
//        gamesTied += ps.gamesTied;
//        gamesLost += ps.gamesLost;
//        return this;
//    }
//
//    public PlayerStat merge( GameStat gameStat ){
//        if( player == null )
//            player = gameStat.getPlayer();
//
//        switch ( gameStat.getResult() ){
//            case TIE: gamesTied++;
//                break;
//            case WON: gamesWon++;
//                break;
//            case LOSS: gamesLost++;
//                break;
//        }
//        return this;
//    }

    public long getGamesPlayed(){
        return gamesWon + gamesLost + gamesTied;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    public int getGamesTied() {
        return gamesTied;
    }

    public void setGamesTied(int gamesTied) {
        this.gamesTied = gamesTied;
    }

    public int getRocksThrown() {
        return rocksThrown;
    }

    public void setRocksThrown(int rocksThrown) {
        this.rocksThrown = rocksThrown;
    }

    public int getPaperssThrown() {
        return paperssThrown;
    }

    public void setPaperssThrown(int paperssThrown) {
        this.paperssThrown = paperssThrown;
    }

    public int getScissorsThrown() {
        return scissorsThrown;
    }

    public void setScissorsThrown(int scissorsThrown) {
        this.scissorsThrown = scissorsThrown;
    }
}
