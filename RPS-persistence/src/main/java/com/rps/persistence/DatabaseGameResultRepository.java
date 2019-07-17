package com.rps.persistence;

import com.rps.core.GameResult;
import com.rps.core.GameResultRepository;
import com.rps.core.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DatabaseGameResultRepository implements GameResultRepository {

    final JpaGameResultsRepository jpaGameResultsRepository;
    final PlayerRepository playerRepository;

    @Autowired
    public DatabaseGameResultRepository(JpaGameResultsRepository jpaGameResultsRepository, DatabasePlayerRepository playerRepository) {
        this.jpaGameResultsRepository = jpaGameResultsRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public GameResult save(GameResult gameResult) {
        return jpaGameResultsRepository
                .save( new JpaGameResultsRepository.GameResultJpaEntity( gameResult ))
                .toDomainObject( gameResult.getPlayer1().getName(), gameResult.getPlayer2().getName());
    }

    @Override
    public GameResult findById(int id) {
        JpaGameResultsRepository.GameResultJpaEntity gameResultJpaEntity = jpaGameResultsRepository.findByGameResultId( id );

        if( gameResultJpaEntity == null )
            return null;

        return gameResultJpaEntity.toDomainObject( playerRepository );
    }

    @Override
    public List<GameResult> findAll() {
        return jpaGameResultsRepository
                .findAll()
                .stream()
                .map( r -> r.toDomainObject( playerRepository ))
                .collect(Collectors.toList());
    }
}
