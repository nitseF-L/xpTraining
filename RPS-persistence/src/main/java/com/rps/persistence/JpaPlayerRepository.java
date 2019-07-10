package com.rps.persistence;

import com.rps.core.Player;
import org.springframework.data.repository.Repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

public interface JpaPlayerRepository extends Repository<JpaPlayerRepository.PlayerJpaEntity, Integer> {

    List<PlayerJpaEntity> findAllByOrderByPlayerIdAsc();

    @Entity
    @Table(name = "players")
    class PlayerJpaEntity implements Serializable {

        public PlayerJpaEntity(){}

        @Id
        public Integer playerId;

        public String playerName;

        public PlayerJpaEntity( Player player ){
            playerId = player.getId();
            playerName = player.getName();
        }

        public Player toDomainObject(){
            return new Player(
                    playerName,
                    playerId
            );
        }


    }
}
