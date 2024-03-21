package com.unito.tweb.javaspringbootservertweb23.game;


import com.unito.tweb.javaspringbootservertweb23.dto.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.*;

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/add_games")
    public ResponseEntity<String> addGames(@RequestBody List<Game> games) {
        return gameService.saveGames(games) != null ? ResponseEntity.ok("Games successfully loaded!")
                : ResponseEntity.internalServerError().body("Error occurred while loading Games!");
    }

    @GetMapping("/get_game_by_id")
    public ResponseEntity<Optional<Game>> getGameById(@RequestBody Long id) {
        Optional<Game> result = gameService.getGameById(id);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/get_last_games")
    public ResponseEntity<Optional<List<VisualizeGame>>> getLastGames() {
        Optional<List<VisualizeGame>> result = gameService.getLastGames();
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/get_games_of_league/{competitionId}/{season}")
    public ResponseEntity<Optional<List<VisualizeGame>>> getGamesByCompetitionIdAndSeason(@PathVariable String competitionId, @PathVariable Integer season) {
        Optional<List<VisualizeGame>> result = gameService.getGamesByCompetitionIdAndSeason(competitionId, season);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/get_games_by_competition_id/{competitionId}/{season}")
    public ResponseEntity<Optional<List<VisualizeGame>>> getGamesByCompetitionIdAndSeasonNot(@PathVariable String competitionId, @PathVariable Integer season) {
        Optional<List<VisualizeGame>> result = gameService.getGamesByCompetitionIdAndSeasonNot(competitionId, season);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/query_games_by_name/{clubName}")
    public ResponseEntity<Optional<List<VisualizeGame>>> getGamesByClubName(@PathVariable String clubName) {
        Optional<List<VisualizeGame>> result = gameService.getGamesByClubName(clubName);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/query_games_by_double_name/{clubName1}/{clubName2}")
    public ResponseEntity<Optional<List<VisualizeGame>>> getGamesByClubNames(@PathVariable String clubName1, @PathVariable String clubName2) {
        Optional<List<VisualizeGame>> result = gameService.getGamesByClubNames(clubName1, clubName2);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @Operation(summary = "Get games by date",
            description = "Retrieve a list of games based on the specified game date.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved the list of games",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = VisualizeGame.class)))),
            @ApiResponse(responseCode = "404",
                    description = "No games found for the specified date",
                    content = @Content())
    })
    @GetMapping("/query_games_by_date/{gameDate}")
    public ResponseEntity<Optional<List<VisualizeGame>>> getGamesByGameDate(@PathVariable Date gameDate) {
        Optional<List<VisualizeGame>> result = gameService.getGamesByGameDate(gameDate);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
