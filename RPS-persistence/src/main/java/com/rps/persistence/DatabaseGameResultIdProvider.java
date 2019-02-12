package com.rps.persistence;

import com.rps.core.GameResultIdProvider;
import org.springframework.stereotype.Component;

@Component
public class DatabaseGameResultIdProvider implements GameResultIdProvider {
    public int getId() {
        return 0;
    }
}
