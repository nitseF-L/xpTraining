package com.rps.core;

import java.util.List;

public class DefaultGetPlayersUseCase implements GetPlayersUseCase {

    private PlayerRepository playerRepository;

    public DefaultGetPlayersUseCase(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> execute() {
        return playerRepository.findAll();
    }
}
