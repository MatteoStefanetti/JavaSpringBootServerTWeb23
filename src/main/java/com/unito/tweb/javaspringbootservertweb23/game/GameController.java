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
     * Constructor for {@code GameController}.
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
     * @return {@link ResponseEntity} indicating the success or failure of the operation
     */
    @Operation(summary = "Add games",
            description = "Add a list of games to the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Games successfully loaded",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "500",
                    description = "Error occurred while loading games",
                    content = @Content())
    })
    @PostMapping("/add_games")
    public ResponseEntity<String> addGames(@RequestBody List<Game> games) {
        return gameService.saveGames(games) != null ? ResponseEntity.ok("Games successfully loaded!")
                : ResponseEntity.internalServerError().body("Error occurred while loading Games!");
    }

    /**
     * Endpoint for retrieving a game by its ID.
     *
     * @param id The ID of the game to retrieve
     * @return {@link ResponseEntity} containing the retrieved {@link Game} if found, or a NOT_FOUND response if no game was found for the specified ID
     */
    @Operation(summary = "Get game by ID", description = "Retrieved a game based on the specified ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved the game",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Game.class))),
            @ApiResponse(responseCode = "404",
                    description = "Game not found",
                    content = @Content())
    })
    @GetMapping("/get_game_by_id/{id}")
    public ResponseEntity<Optional<Game>> getGameById(@PathVariable Long id) {
        Optional<Game> result = gameService.getGameById(id);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for retrieving the last games played.
     *
     * @return {@link ResponseEntity} containing the {@link List} of last games played if found, or a NOT_FOUND response if no games were found
     */
    @Operation(summary = "Get last games",
            description = "Retrieve a list of last 20 games.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved the list of last games",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = VisualizeGame.class)))),
            @ApiResponse(responseCode = "404",
                    description = "No last games found",
                    content = @Content())
    })
    @GetMapping("/get_last_games")
    public ResponseEntity<Optional<List<VisualizeGame>>> getLastGames() {
        Optional<List<VisualizeGame>> result = gameService.getLastGames();
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for retrieving a game data by its game ID.
     *
     * @param id The ID of the game to retrieve
     * @return {@link ResponseEntity} containing the visualization of a game if found, or NOT_FOUND response if there isn't a game with the specified ID
     */
    @Operation(summary = "Visualize a game",
            description = "Retrieves a game data by its game ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved the Game",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VisualizeGame.class))),
            @ApiResponse(responseCode = "404",
                    description = "No game found",
                    content = @Content())
    })
    @GetMapping("/visualize_game_by_id/{id}")
    public ResponseEntity<Optional<VisualizeGame>> visualizeGameById(@PathVariable Long id) {
        Optional<VisualizeGame> result = gameService.getVisualizeGameById(id);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for retrieving game data by its game ID.
     *
     * @param id The ID of the game to retrieve
     * @return {@link ResponseEntity} containing the visualization of a game if found, or NOT_FOUND response if there isn't a game with the specified ID
     */
    @Operation(summary = "Visualize details about a game",
            description = "Retrieves game data by its game ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved game details",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GameDetails.class))),
            @ApiResponse(responseCode = "404",
                    description = "No game found",
                    content = @Content())
    })
    @GetMapping("/get_game_details_by_id/{id}")
    public ResponseEntity<Optional<GameDetails>> getGameDetailsById(@PathVariable Long id) {
        Optional<GameDetails> result = gameService.getGameDetailsById(id);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for retrieving games of a league for a specific season.
     *
     * @param competitionId The ID of the competition
     * @param season        The season of the games to retrieve
     * @return {@link ResponseEntity} containing the {@link List} of games matching the criteria if found, or a NOT_FOUND response if no games were found
     */
    @Operation(summary = "Get games by competition ID and season",
            description = "Retrieve a list of games based on the specified competition ID and season.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved the list of games",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = VisualizeGame.class)))),
            @ApiResponse(responseCode = "404",
                    description = "No games found for the specified competition ID and season",
                    content = @Content())
    })
    @GetMapping("/get_games_of_league/{competitionId}/{season}")
    public ResponseEntity<Optional<List<VisualizeGame>>> getGamesByCompetitionIdAndSeason(@PathVariable String competitionId, @PathVariable Integer season) {
        Optional<List<VisualizeGame>> result = gameService.getGamesByCompetitionIdAndSeason(competitionId, season);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for retrieving the current season of a certain competition.
     *
     * @param competitionId The ID of the competition
     * @return {@link ResponseEntity} containing an {@link Integer} representing the last season of a certain competition if found, or a NOT_FOUND response if no competition or season were found
     */
    @Operation(summary = "Get the current season year",
            description = "Retrieve a number, representing the last season of the given competition from the games table.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved the year",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Integer.class))),
            @ApiResponse(responseCode = "404",
                    description = "No games found while searching for the season",
                    content = @Content())
    })
    @GetMapping("/get_current_season_year/{competitionId}")
    public ResponseEntity<Optional<Integer>> getCurrentSeasonYear(@PathVariable String competitionId) {
        Optional<Integer> result = gameService.getSeasonYearFromGames(competitionId);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for retrieving all the seasons of a certain competition.
     *
     * @param competitionId The ID of the competition
     * @return {@link ResponseEntity} containing a {@link List} of {@link Integer} representing all the seasons of a certain competition if found, or a NOT_FOUND response if no competition or season were found
     */
    @Operation(summary = "Get the all season year",
            description = "Retrieve a list of number, representing all the season of the given competition from the games table.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved the years",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Integer.class))),
            @ApiResponse(responseCode = "404",
                    description = "No games found while searching for the season",
                    content = @Content())
    })
    @GetMapping("/get_all_seasons/{competitionId}")
    public ResponseEntity<Optional<List<Integer>>> getAllSeasonByCompetitionId(@PathVariable String competitionId) {
        Optional<List<Integer>> result = Optional.ofNullable(gameService.getAllSeasonByCompetitionId(competitionId));
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for retrieving all the placing of a competition.
     *
     * @param competitionId The ID of the competition
     * @param season        The season year of the competition
     * @return {@link ResponseEntity} containing a {@link List} of {@link ClubPlacing} representing the placing of a competition
     */
    @Operation(summary = "Get the placing of a competition",
            description = "Retrieve a list of clubs that participate in a certain competition in a certain season and their placing.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved the clubs",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(
                                    schema = @Schema(implementation = ClubPlacing.class)))),
            @ApiResponse(responseCode = "404",
                    description = "No clubs found while searching for the season",
                    content = @Content())
    })
    @GetMapping("/competition_placing/{competitionId}/{season}")
    public ResponseEntity<Optional<List<ClubPlacing>>> getPlacingClubsOfACompetitionAndSeason(@PathVariable String competitionId, @PathVariable Integer season) {
        Optional<List<ClubPlacing>> result = gameService.getPlacingClubsOfACompetitionAndSeason(competitionId, season);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for retrieving games of a league for seasons other than a specific season.
     *
     * @param competitionId The ID of the competition
     * @param season        The season of the games to exclude
     * @return {@link ResponseEntity} containing the {@link List} of games matching the criteria if found, or a NOT_FOUND response if no games were found
     */
    @Operation(summary = "Get games by competition ID but excluding a certain season",
            description = "Retrieve a list of games based on the specified competition ID and excluding a certain season.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved the list of games",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = VisualizeGame.class)))),
            @ApiResponse(responseCode = "404",
                    description = "No games found for the specified competition ID and season",
                    content = @Content())
    })
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
     * @return {@link ResponseEntity} containing the {@link List} of games involving the club if found, or a NOT_FOUND response if no games were found
     */
    @Operation(summary = "Get games by club name",
            description = "Retrieve a list of games based on the specified club name.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved the list of games",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = VisualizeGame.class)))),
            @ApiResponse(responseCode = "404",
                    description = "No games found for the specified club name",
                    content = @Content())
    })
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
     * @return {@link ResponseEntity} containing the {@link List} of games involving both clubs if found, or a NOT_FOUND response if no games were found
     */
    @Operation(summary = "get games by club names",
            description = "Retrieve a list of games based on the specified club names.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved the list of games",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = VisualizeGame.class)))),
            @ApiResponse(responseCode = "404",
                    description = "No games found for the specified club names",
                    content = @Content())
    })
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
     * @return {@link ResponseEntity} containing the {@link List} of {@link VisualizeGame} objects if found, or a NOT_FOUND response if no games were found for the specified date
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

    /**
     * Endpoint for retrieving games by a specific club ID and a specific season.
     *
     * @param id     The ID of the club
     * @param season The year of the season
     * @return A {@link ResponseEntity} containing the {@link List} of {@link VisualizeGame} objects if found, or a NOT_FOUND response if no games were found
     */
    @Operation(summary = "Get games by club ID",
            description = "Retrieve a list of games based on the specified club ID and season.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved the list of games",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = VisualizeGame.class)))),
            @ApiResponse(responseCode = "404",
                    description = "No games found for the specified date",
                    content = @Content())
    })
    @GetMapping("/get_games_by_club_id/{id}/{season}")
    public ResponseEntity<Optional<List<VisualizeGame>>> getGamesByClubId(@PathVariable Long id, @PathVariable Integer season) {
        Optional<List<VisualizeGame>> result = gameService.getGamesByClubId(id, season);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint for retrieving games by a specific club id and the last season played by the specified club.
     *
     * @param clubId The ID of the club
     * @return A {@link ResponseEntity} containing the {@link List} of {@link VisualizeGame} objects if found, or a NOT_FOUND response if no games were found
     */
    @Operation(summary = "Get last games of a club ID",
            description = "Retrieve a list of the last games of a certain club ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully retrieved the list of games",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = VisualizeGame.class)))),
            @ApiResponse(responseCode = "404",
                    description = "No games found for the specified date",
                    content = @Content())
    })
    @GetMapping("/get_last_games_by_club/{clubId}")
    public ResponseEntity<Optional<List<VisualizeGame>>> getLastGamesByClubId(@PathVariable Long clubId) {
        Optional<List<VisualizeGame>> result = gameService.getLastGamesByClubId(clubId);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
