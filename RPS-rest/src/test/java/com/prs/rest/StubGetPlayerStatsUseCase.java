package com.prs.rest;

import com.rps.core.GetPlayerStatsUseCase;
import com.rps.core.PlayerStat;

import java.util.ArrayList;
import java.util.List;

public class StubGetPlayerStatsUseCase implements GetPlayerStatsUseCase {

    public List<PlayerStat> stubbedGetPlayerStatsUseCaseResponse =
            new ArrayList<>();

    @Override
    public List<PlayerStat> execute() {
        return stubbedGetPlayerStatsUseCaseResponse;
    }
}
