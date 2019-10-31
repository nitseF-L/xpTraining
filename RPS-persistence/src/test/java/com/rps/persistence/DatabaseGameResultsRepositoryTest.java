package com.rps.persistence;

import com.rps.core.GameResultRepository;
import com.rps.core.GameResultRepositoryTest;
import com.rps.core.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DatabaseGameResultsRepositoryTest extends GameResultRepositoryTest {

    @Autowired
    DatabaseGameResultRepository databaseGameResultRepository;

    @Autowired
    DatabasePlayerRepository databasePlayerRepository;

    @Autowired
    DatabaseCleaner databaseCleaner;

    @BeforeEach
    public void cleanDB(){ databaseCleaner.deleteAllRows();}

    protected GameResultRepository getGameResultRepository() {
        return databaseGameResultRepository;
    }

    @Override
    protected PlayerRepository getPlayerRepository() {
        return databasePlayerRepository;
    }
}
