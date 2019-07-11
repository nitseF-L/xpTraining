package com.prs.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rps.core.*;
import com.rps.rest.RestApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static com.rps.core.Outcome.*;
import static com.rps.core.Throw.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class RpsRestControllerTest {

    private GameResult stubbedCreateGameUseCaseResponse;
    private PlayPracticeGameUseCase.Response stubbedPlayPracticeGameUseCaseResponse;
    private List<Player> stubbedGetPlayersUseCaseResponse;

    @Configuration
    @Import(RestApplication.class)
    public static class Config{
        public static StubCreateGameResultUseCase stubCreateGameResultUseCase;
        public static StubPlayPracticeGameResultUseCase stubPlayPracticeGameResultUseCase;
        public static StubGetPlayersUseCase stubGetPlayersUseCase;

        @Bean
        @Primary
        public CreateGameResultUseCase createStubGameResultUseCase(){
            stubCreateGameResultUseCase = new StubCreateGameResultUseCase();
            return stubCreateGameResultUseCase;
        }

        @Bean
        @Primary
        public PlayPracticeGameUseCase playPracticeStubGameUseCase(){
            stubPlayPracticeGameResultUseCase = new StubPlayPracticeGameResultUseCase();
            return stubPlayPracticeGameResultUseCase;
        }

        @Bean
        @Primary
        public GetPlayersUseCase getStubPlayersUseCase(){
            stubGetPlayersUseCase = new StubGetPlayersUseCase();
            return stubGetPlayersUseCase;
        }

    }

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mvc;

    @Before
    public void setup(){

        stubbedCreateGameUseCaseResponse = Config.stubCreateGameResultUseCase.stubbedCreateGameResultUseCaseResponse;
        stubbedCreateGameUseCaseResponse.setOutcome( P1_WINS);
        stubbedPlayPracticeGameUseCaseResponse = Config.stubPlayPracticeGameResultUseCase.stubbedPlayPracticeGameUseCaseResponse;
        stubbedPlayPracticeGameUseCaseResponse.outcome = P2_WINS;
        stubbedGetPlayersUseCaseResponse = Config.stubGetPlayersUseCase.stubbedGetPlayersUseCaseResponse;
        stubbedGetPlayersUseCaseResponse.add( new Player("player1", 11));
        stubbedGetPlayersUseCaseResponse.add( new Player("player2", 12));


        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();

    }

    @Test
    public void postCreateGameResult_returnsGameResult() throws Exception {
        CreateGameResultUseCase.Request request = buildCreateGameResultRequest();
        System.out.println( "Request: " + objectMapper.writeValueAsString(request));


        mvc
                .perform(post("/api/gameResults" )
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.outcome",
                        is(Config.stubCreateGameResultUseCase.stubbedCreateGameResultUseCaseResponse.getOutcome().toString() )));

        assertThat( Config.stubCreateGameResultUseCase.executeCalledWith).isEqualToComparingFieldByFieldRecursively(request);
    }

    private CreateGameResultUseCase.Request buildCreateGameResultRequest() {
        CreateGameResultUseCase.Request request = new CreateGameResultUseCase.Request();
        request.player1 = new Player( "Jane Doe", 1);
        request.player2 = new Player("John Doe", 2);
        request.player1Throw = ROCK;
        request.player2Throw = SCISSORS;
        return request;
    }

    @Test
    public void playPracticeGameUseCase() throws Exception {
        PlayPracticeGameUseCase.Request request = buildPracticeGameResultRequest();
        System.out.println( "Request: " + objectMapper.writeValueAsString(request));


        mvc
                .perform(post("/api/gameResults/practice" )
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.outcome",
                        is(Config.stubPlayPracticeGameResultUseCase.stubbedPlayPracticeGameUseCaseResponse.outcome.toString() )));

        assertThat( Config.stubPlayPracticeGameResultUseCase.executeCalledWith).isEqualToComparingFieldByFieldRecursively(request);
    }

    private PlayPracticeGameUseCase.Request buildPracticeGameResultRequest() {
        PlayPracticeGameUseCase.Request request = new PlayPracticeGameUseCase.Request();
        request.player1Throw = PAPER;
        request.player2Throw = SCISSORS;
        return request;
    }

    @Test
    public void getPlayersUseCase() throws Exception {


        mvc
                .perform(get("/api/gameResults/playerList" )
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name",
                        is(Config.stubGetPlayersUseCase.stubbedGetPlayersUseCaseResponse.get(0).getName() ) ))
                .andExpect(jsonPath("$[0].id",
                        is(Config.stubGetPlayersUseCase.stubbedGetPlayersUseCaseResponse.get(0).getId() ) ))
                .andExpect(jsonPath("$[1].name",
                        is(Config.stubGetPlayersUseCase.stubbedGetPlayersUseCaseResponse.get(1).getName() ) ))
                .andExpect(jsonPath("$[1].id",
                        is(Config.stubGetPlayersUseCase.stubbedGetPlayersUseCaseResponse.get(1).getId() ) ));

    }
}
