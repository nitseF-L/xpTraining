package com.rps.persistence;

import com.rps.core.PlayerRepository;
import com.rps.core.PlayerRepositoryTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DatabasePlayerRepositoryTest extends PlayerRepositoryTest {
    @Autowired
    DatabasePlayerRepository databasePlayerRepository;

    @Override
    protected PlayerRepository getPlayerRepository() {
        return databasePlayerRepository;
    }
}
