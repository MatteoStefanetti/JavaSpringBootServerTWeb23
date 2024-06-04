package com.unito.tweb.javaspringbootservertweb23.club_game;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
     * Constructor of a new {@code ClubGameController} with the specified {@link ClubGameService}.
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
     * @return A {@link ResponseEntity} indicating the success or failure of the operation
     */
    @Operation(summary = "Add club games",
            description = "Add a list of information related to club and games to the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Club games successfully loaded",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "500",
                    description = "Error occurred while loading club games",
                    content = @Content())
    })
    @PostMapping("/add_club_games")
    public ResponseEntity<String> addClubGames(@RequestBody List<ClubGame> clubGames) {
        return clubGameService.saveClubGames(clubGames) != null ? ResponseEntity.ok("ClubGames successfully loaded!")
                : ResponseEntity.internalServerError().body("Error occurred while loading ClubGames!");
    }
}
