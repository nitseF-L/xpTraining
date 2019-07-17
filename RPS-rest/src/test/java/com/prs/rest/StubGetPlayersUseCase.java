package com.prs.rest;

import com.rps.core.GetPlayersUseCase;
import com.rps.core.Player;

import java.util.ArrayList;
import java.util.List;

public class StubGetPlayersUseCase implements GetPlayersUseCase {

    public List<Player> stubbedGetPlayersUseCaseResponse =
            new  ArrayList<Player>();

    @Override
    public List<Player> execute() {
        return stubbedGetPlayersUseCaseResponse;
    }
}
