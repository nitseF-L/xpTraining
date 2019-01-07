package com.rps.persistence;

import com.rps.core.GameResult;
import com.rps.core.GameResultRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseGameResultRepository implements GameResultRepository {
    public GameResult save(GameResult gameResult) {
        return null;
    }

    public GameResult findById(int id) {
        return null;
    }

    public List<GameResult> findAll() {
        return null;
    }
}
