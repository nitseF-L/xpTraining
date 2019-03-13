package com.rps.persistence;

import com.rps.core.GameResultRepository;
import com.rps.core.GameResultRepositoryTest;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DatabaseGameResultsRepositoryTest extends GameResultRepositoryTest {

    @Autowired
    DatabaseGameResultRepository databaseGameResultRepository;

    @Autowired
    DatabaseCleaner databaseCleaner;

    @Before
    public void cleanDB(){ databaseCleaner.deleteAllRows();}

    protected GameResultRepository getGameResultRepository() {
        return databaseGameResultRepository;
    }
}
