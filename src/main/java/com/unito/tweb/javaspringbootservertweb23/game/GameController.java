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

/**
 * REST controller for mapping Game entities.
 */
@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;

    /**
     * Constructor for GameController.
     *
     * @param gameService The GameService instance to be used for handling game-related operations.
     */
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    /**
     * Endpoint for adding multiple games.
     *
     * @param games List of Game objects to be added
     * @return ResponseEntity indicating the success or failure of the operation
     */
    @PostMapping("/add_games")
    public ResponseEntity<String> addGames(@RequestBody List<Game> games) {
        return gameService.saveGames(games) != null ? ResponseEntity.ok("Games successfully loaded!")
                : ResponseEntity.internalServerError().body("Error occurred while loading Games!");
    }

    /**
     * Endpoint for retrieving a game by its ID.
     *
     * @param id The ID of the game to retrieve
     * @return ResponseEntity containing the retrieved game if found, or a NOT_FOUND response if no game was found for the specified ID
     */
    @GetMapping("/get_game_by_id")
    public ResponseEntity<Optional<Game>> getGameById(@RequestBody Long id) {
        Optional<Game> result = gameService.getGameById(id);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for retrieving the last games played.
     *
     * @return ResponseEntity containing the list of last games played if found, or a NOT_FOUND response if no games were found
     */
    @GetMapping("/get_last_games")
    public ResponseEntity<Optional<List<VisualizeGame>>> getLastGames() {
        Optional<List<VisualizeGame>> result = gameService.getLastGames();
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for retrieving games of a league for a specific season.
     *
     * @param competitionId The ID of the competition
     * @param season        The season of the games to retrieve
     * @return ResponseEntity containing the list of games matching the criteria if found, or a NOT_FOUND response if no games were found
     */
    @GetMapping("/get_games_of_league/{competitionId}/{season}")
    public ResponseEntity<Optional<List<VisualizeGame>>> getGamesByCompetitionIdAndSeason(@PathVariable String competitionId, @PathVariable Integer season) {
        Optional<List<VisualizeGame>> result = gameService.getGamesByCompetitionIdAndSeason(competitionId, season);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for retrieving games of a league for seasons other than a specific season.
     *
     * @param competitionId The ID of the competition
     * @param season        The season of the games to exclude
     * @return ResponseEntity containing the list of games matching the criteria if found, or a NOT_FOUND response if no games were found
     */
    @GetMapping("/get_games_by_competition_id/{competitionId}/{season}")
    public ResponseEntity<Optional<List<VisualizeGame>>> getGamesByCompetitionIdAndSeasonNot(@PathVariable String competitionId, @PathVariable Integer season) {
        Optional<List<VisualizeGame>> result = gameService.getGamesByCompetitionIdAndSeasonNot(competitionId, season);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for retrieving games involving a specific club.
     *
     * @param clubName The name of the club
     * @return ResponseEntity containing the list of games involving the club if found, or a NOT_FOUND response if no games were found
     */
    @GetMapping("/query_games_by_name/{clubName}")
    public ResponseEntity<Optional<List<VisualizeGame>>> getGamesByClubName(@PathVariable String clubName) {
        Optional<List<VisualizeGame>> result = gameService.getGamesByClubName(clubName);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for retrieving games involving two specific clubs.
     *
     * @param clubName1 The name of the first club
     * @param clubName2 The name of the second club
     * @return ResponseEntity containing the list of games involving both clubs if found, or a NOT_FOUND response if no games were found
     */
    @GetMapping("/query_games_by_double_name/{clubName1}/{clubName2}")
    public ResponseEntity<Optional<List<VisualizeGame>>> getGamesByClubNames(@PathVariable String clubName1, @PathVariable String clubName2) {
        Optional<List<VisualizeGame>> result = gameService.getGamesByClubNames(clubName1, clubName2);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for retrieving games by a specific game date.
     *
     * @param gameDate The date of the games to retrieve
     * @return ResponseEntity containing the list of VisualizeGame objects if found, or a NOT_FOUND response if no games were found for the specified date
     */
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
