package com.rps.rest;

import com.rps.core.CreateGameResultUseCase;
import com.rps.core.DefaultCreateGameResultUseCase;
import com.rps.core.GameResultIdProvider;
import com.rps.persistence.DatabaseGameResultRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameResultsConfig {

//    @Bean
//    public GameResultIdProvider gameResultIdProvider(){
//        return null;
//    }

    @Bean
    public CreateGameResultUseCase createGameResultUseCase( DatabaseGameResultRepository databaseGameResultRepository, GameResultIdProvider gameResultIdProvider ){
        return new DefaultCreateGameResultUseCase( databaseGameResultRepository, gameResultIdProvider );

    }

}
