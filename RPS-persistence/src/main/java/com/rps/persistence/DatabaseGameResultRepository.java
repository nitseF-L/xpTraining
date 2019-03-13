package com.rps.persistence;

import com.rps.core.GameResult;
import com.rps.core.GameResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DatabaseGameResultRepository implements GameResultRepository {

    final JdbcTemplate jdbcTemplate;
    final JpaGameResultsRepository jpaGameResultsRepository;

    @Autowired
    public DatabaseGameResultRepository(JdbcTemplate jdbcTemplate, JpaGameResultsRepository jpaGameResultsRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.jpaGameResultsRepository = jpaGameResultsRepository;
    }

    @Override
    public GameResult save(GameResult gameResult) {
        return jpaGameResultsRepository
                .save( new JpaGameResultsRepository.GameResultJpaEntity( gameResult ))
                .toDomainObject();
    }

    @Override
    public GameResult findById(int id) {
        JpaGameResultsRepository.GameResultJpaEntity gameResultJpaEntity = jpaGameResultsRepository.findByGameResultId( id );

        if( gameResultJpaEntity == null )
            return null;

        return gameResultJpaEntity.toDomainObject();
    }

    @Override
    public List<GameResult> findAll() {
        return jpaGameResultsRepository
                .findAll()
                .stream()
                .map( JpaGameResultsRepository.GameResultJpaEntity::toDomainObject )
                .collect(Collectors.toList());
    }
}
