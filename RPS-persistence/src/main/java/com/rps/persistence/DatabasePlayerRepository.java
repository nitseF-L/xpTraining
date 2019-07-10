package com.rps.persistence;

import com.rps.core.Player;
import com.rps.core.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DatabasePlayerRepository implements PlayerRepository {

    final JpaPlayerRepository jpaPlayerRepository;

    @Autowired
    public DatabasePlayerRepository( JpaPlayerRepository jpaPlayerRepository ){
        this.jpaPlayerRepository = jpaPlayerRepository;
    }

    @Override
    public List<Player> findAll() {
        return jpaPlayerRepository
                .findAllByOrderByPlayerIdAsc()
                .stream()
                .map( JpaPlayerRepository.PlayerJpaEntity::toDomainObject )
                .collect(Collectors.toList());
    }
}
