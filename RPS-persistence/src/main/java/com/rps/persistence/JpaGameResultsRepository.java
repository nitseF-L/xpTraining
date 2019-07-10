package com.rps.persistence;

import com.rps.core.GameResult;
import com.rps.core.Outcome;
import com.rps.core.Player;
import org.springframework.data.repository.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public interface JpaGameResultsRepository extends Repository<JpaGameResultsRepository.GameResultJpaEntity, String> {

    GameResultJpaEntity save(GameResultJpaEntity gameResultJpaEntity );
    GameResultJpaEntity findByGameResultId( Integer gameResultId );
    List<GameResultJpaEntity> findAll();

    @Entity
    @Table(name = "game_results")
    class GameResultJpaEntity implements Serializable {

        public GameResultJpaEntity(){}

        @Id
        public Integer gameResultId;

        @Enumerated(EnumType.STRING)
        public Outcome outcome;

        public String player1Name;
        public int player1Id;
        public String player2Name;
        public int player2Id;

        public GameResultJpaEntity(GameResult gameResult ){
            this.gameResultId = gameResult.getGameResultId();
            this.outcome = gameResult.getOutcome();
            this.player1Id = gameResult.getPlayer1().getId();
            this.player1Name = gameResult.getPlayer1().getName();
            this.player2Id = gameResult.getPlayer2().getId();
            this.player2Name = gameResult.getPlayer2().getName();
        }

        public GameResult toDomainObject(){
            return new GameResult(
                    new Player( player1Name, player1Id ),
                    new Player( player2Name, player2Id ),
                    outcome,
                    gameResultId
            );
        }

    }

}
