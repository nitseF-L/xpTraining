package com.rps.rest;

import com.rps.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/gameResults")
public class RpsRestController {

    private final CreateGameResultUseCase createGameResultUseCase;
    private final PlayPracticeGameUseCase playPracticeGameUseCase;
    private final GetPlayersUseCase getPlayersUseCase;

    @Autowired
    RpsRestController(CreateGameResultUseCase createGameResultUseCase, PlayPracticeGameUseCase playPracticeGameUseCase, GetPlayersUseCase getPlayersUseCase){
        this.createGameResultUseCase = createGameResultUseCase;
        this.playPracticeGameUseCase = playPracticeGameUseCase;
        this.getPlayersUseCase = getPlayersUseCase;
    }

    @PostMapping
    public GameResult createGameResult(@RequestBody CreateGameResultUseCase.Request request ){
        System.out.println("Player 1 throw: " + request.player1Throw );
        System.out.println("Player 2 throw: " + request.player2Throw );
        return createGameResultUseCase.execute( request );
    }


    @PostMapping("/practice")
    public PlayPracticeGameUseCase.Response playPracticeGameResult(@RequestBody PlayPracticeGameUseCase.Request request ){
        System.out.println("Player 1 throw: " + request.player1Throw );
        System.out.println("Player 2 throw: " + request.player2Throw );
        return playPracticeGameUseCase.execute( request );
    }

    @GetMapping("/playerList")
    public List<Player> getPlayerList( ){
        return getPlayersUseCase.execute();
    }
}
