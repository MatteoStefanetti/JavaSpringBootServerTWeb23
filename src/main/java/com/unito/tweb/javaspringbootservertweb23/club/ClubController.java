package com.unito.tweb.javaspringbootservertweb23.club;


import com.unito.tweb.javaspringbootservertweb23.dto.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/clubs")
public class ClubController {
    private final ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @Operation(summary = "get recent club news", description = "Retrieves a list of the last 15 different games played")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "List of recent club news retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ClubName.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/get_recent_clubs_news")
    public ResponseEntity<List<ClubName>> getRecentClubsNews() {
        try {
            return ResponseEntity.ok(clubService.getRecentClubsNews());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @Operation(summary = "find clubs by letter", description = "Retrieves the list of clubs that has the name that begin with a certain string")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "List of clubs retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400",
                    description = "Invalid input")

    })
    @GetMapping("/club_by_letter")
    public ResponseEntity<String> findClubsByLetter(@RequestBody String letter) {
        try {
            List<Long> squad = clubService.findClubsByLetter(letter);
            return ResponseEntity.ok(squad.toString());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input");
        }
    }

    @GetMapping("/clubs_by_nation")
    public ResponseEntity<List<VisualizeClub>> findClubsByLocalCompetitionCode(@RequestBody String localCompetitionCode) {
        return ResponseEntity.ok(clubService.findClubsByLocalCompetitionCode(localCompetitionCode));
    }

    @GetMapping("/clubs_by_string")
    public ResponseEntity<List<ClubByNation>> findClubsByClubNameContaining(@RequestBody String name) {
        return ResponseEntity.ok(clubService.findClubsByClubNameContaining(name));
    }

    @PostMapping("/add_clubs")
    public ResponseEntity<String> addClubs(@RequestBody List<Club> clubs) {
        return clubService.saveClubs(clubs) != null ? ResponseEntity.ok("Clubs successfully loaded!")
                : ResponseEntity.internalServerError().body("Error occurred while loading Clubs!");
    }

    @GetMapping("/club_by_name")
    public ResponseEntity<Club> findClubByClubName(@RequestBody String name) {
        return ResponseEntity.ok(clubService.findClubByClubName(name));
    }

    @GetMapping("/get_club_by_id")
    public ResponseEntity<Optional<Club>> getClubById(@RequestBody Long id) {
        Optional<Club> result = clubService.getClubById(id);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
