package com.rps.core;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPlayerRepository implements PlayerRepository {

    public ArrayList<Player> players = new ArrayList<>();

    @Override
    public List<Player> findAll() {
        return players;
    }
}
