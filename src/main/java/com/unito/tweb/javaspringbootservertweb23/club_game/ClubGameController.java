package com.unito.tweb.javaspringbootservertweb23.club_game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/club_games")
public class ClubGameController {
    private final ClubGameService clubGameService;

    @Autowired
    public ClubGameController(ClubGameService clubGameService) {
        this.clubGameService = clubGameService;
    }

    @PostMapping("/add_club_games")
    public ResponseEntity<String> addClubGames(@RequestBody List<ClubGame> clubGames){
        return clubGameService.saveClubGames(clubGames) != null ? ResponseEntity.ok("ClubGames successfully loaded!")
                : ResponseEntity.internalServerError().body("Error occurred while loading ClubGames!");
    }
}
