package com.rps.rest;

import com.rps.core.CreateGameResultUseCase;
import com.rps.core.GameResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/gameResults")
public class GameResultsController {

    private final CreateGameResultUseCase createGameResultUseCase;

    @Autowired
    GameResultsController( CreateGameResultUseCase createGameResultUseCase ){
        this.createGameResultUseCase = createGameResultUseCase;
    }

    @PostMapping
    public GameResult CreateGameResult(@RequestBody CreateGameResultUseCase.Request request ){
        return createGameResultUseCase.execute( request );
    }
}
