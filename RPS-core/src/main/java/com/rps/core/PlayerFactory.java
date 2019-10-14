package com.rps.core;

public class PlayerFactory {

    private static int nextId = 0;
    private static final String PlayerPrefix = "Player";

    public static Player buildPlayer(){
        nextId++;
        return new Player( getName( nextId ), nextId );
    }

    public static Player buildPlayer(int id){
        return new Player( getName( id ), id );
    }

    private static String getName( int id ){
        return PlayerPrefix + id;
    }
}
