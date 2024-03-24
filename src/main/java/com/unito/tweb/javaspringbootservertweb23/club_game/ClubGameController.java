package com.unito.tweb.javaspringbootservertweb23.club_game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller class for handling ClubGame entities.
 */
@RestController
@RequestMapping("/club_games")
public class ClubGameController {
    private final ClubGameService clubGameService;

    /**
     * Constructor of a new ClubGame controller with the specified ClubGameService.
     *
     * @param clubGameService The ClubGame service to be used by this controller
     */
    @Autowired
    public ClubGameController(ClubGameService clubGameService) {
        this.clubGameService = clubGameService;
    }

    /**
     * Endpoint to add multiple ClubGame instances at once.
     *
     * @param clubGames The List of ClubGame instances to be added
     * @return A ResponseEntity indicating the success or failure of the operation
     */
    @PostMapping("/add_club_games")
    public ResponseEntity<String> addClubGames(@RequestBody List<ClubGame> clubGames) {
        return clubGameService.saveClubGames(clubGames) != null ? ResponseEntity.ok("ClubGames successfully loaded!")
                : ResponseEntity.internalServerError().body("Error occurred while loading ClubGames!");
    }
}
