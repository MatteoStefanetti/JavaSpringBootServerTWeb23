package com.unito.tweb.javaspringbootservertweb23.game;


import com.unito.tweb.javaspringbootservertweb23.dto.*;

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
    public ResponseEntity<List<VisualizeGame>> getLastGames() {
        return ResponseEntity.ok(gameService.getLastGames());
    }


    @GetMapping("/get_games_of_league/{competitionId}/{season}")
    public ResponseEntity<List<VisualizeGame>> getGamesByCompetitionIdAndSeason(@PathVariable String competitionId, @PathVariable Integer season){
        return ResponseEntity.ok(gameService.getGamesByCompetitionIdAndSeason(competitionId, season));
    }

    @GetMapping("/get_games_by_competition_id/{competitionId}/{season}")
    public ResponseEntity<List<VisualizeGame>> getGamesByCompetitionIdAndSeasonNot(@PathVariable String competitionId, @PathVariable Integer season){
        return ResponseEntity.ok(gameService.getGamesByCompetitionIdAndSeasonNot(competitionId, season));
    }
  
    @GetMapping("/query_games_by_name")
    public ResponseEntity<List<VisualizeGame>> getGamesByClubName(@RequestBody String clubName) {
        return ResponseEntity.ok(gameService.getGamesByClubName(clubName));
    }

    @GetMapping("/query_games_by_double_name")
    public ResponseEntity<List<VisualizeGame>> getGamesByClubNames(@RequestParam String clubName1, @RequestParam String clubName2) {
        return ResponseEntity.ok(gameService.getGamesByClubNames(clubName1, clubName2));
    }

    @GetMapping("/query_games_by_date")
    public ResponseEntity<List<VisualizeGame>> getGamesByGameDate(@RequestParam Date gameDate) {
        return ResponseEntity.ok(gameService.getGamesByGameDate(gameDate));
    }
}
