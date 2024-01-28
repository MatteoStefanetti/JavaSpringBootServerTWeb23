package com.unito.tweb.javaspringbootservertweb23.game;

import com.unito.tweb.javaspringbootservertweb23.dto.TopGameResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<TopGameResults>> getLastGames() {
        return ResponseEntity.ok(gameService.getLastGames());
    }

    @GetMapping("/query_games_by_name")
    public ResponseEntity<List<Game>> getGamesByClubName(@RequestBody String clubName) {
        return ResponseEntity.ok(gameService.getGamesByClubName(clubName));
    }

    @GetMapping("/query_games_by_double_name")
    public ResponseEntity<List<Game>> getGamesByClubNames(@RequestParam String clubName1, @RequestParam String clubName2){
        return ResponseEntity.ok(gameService.getGamesByClubNames(clubName1, clubName2));
    }
}
