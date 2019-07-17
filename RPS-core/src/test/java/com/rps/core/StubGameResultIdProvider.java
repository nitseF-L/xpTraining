package com.rps.core;

public class StubGameResultIdProvider implements GameResultIdProvider{
    private int id = 0;
    @Override
    public int getId() {
        return id++;
    }
}
