package com.rps.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public abstract class GameResultIdProviderTest {

    GameResultIdProvider gameResultIdProvider;

    protected abstract GameResultIdProvider getGameResultIdProvider();

    @BeforeEach
    public void setup() { gameResultIdProvider = getGameResultIdProvider(); }

    @Test
    public void returnsSequence(){
        int first = gameResultIdProvider.getId();
        int second = gameResultIdProvider.getId();
        int third = gameResultIdProvider.getId();

        assertEquals( (first + 1), second );
        assertEquals( (second + 1), third );
    }
}
