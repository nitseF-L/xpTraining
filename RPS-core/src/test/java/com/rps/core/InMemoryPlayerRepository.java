package com.rps.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryPlayerRepository implements PlayerRepository {

    private Map<Integer,Player> players = new HashMap<>();

    @Override
    public List<Player> findAll() {
        return new ArrayList<>( players.values() );
    }

    @Override
    public Player findById(int id) {
        return players.get( id );
    }

    @Override
    public Player save(Player player) {
        players.put( player.getId(), player );
        return players.get( player.getId() );
    }
}
