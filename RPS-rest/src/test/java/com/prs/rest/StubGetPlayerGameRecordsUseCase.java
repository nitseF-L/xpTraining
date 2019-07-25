package com.prs.rest;

import com.rps.core.GameRecord;
import com.rps.core.GetPlayerGameRecordsUseCase;

import java.util.ArrayList;
import java.util.List;

public class StubGetPlayerGameRecordsUseCase implements GetPlayerGameRecordsUseCase {

    public List<GameRecord> stubbedGetPlayerGameRecordsUseCase =
            new ArrayList<>();

    public int calledWith;

    @Override
    public List<GameRecord> execute(int playerId) {
        calledWith = playerId;
        return stubbedGetPlayerGameRecordsUseCase;
    }
}
