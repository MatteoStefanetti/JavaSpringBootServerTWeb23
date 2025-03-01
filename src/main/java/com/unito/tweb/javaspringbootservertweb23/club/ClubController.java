package com.unito.tweb.javaspringbootservertweb23.club;


import com.unito.tweb.javaspringbootservertweb23.dto.ClubByNation;
import com.unito.tweb.javaspringbootservertweb23.dto.ClubName;
import com.unito.tweb.javaspringbootservertweb23.dto.PlayerCard;
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

import java.util.List;
import java.util.Optional;

/**
 * REST controller for mapping Club entities.
 */
@RestController
@RequestMapping("/clubs")
public class ClubController {
    private final ClubService clubService;

    /**
     * Constructor for {@code ClubController}.
     *
     * @param clubService Club service to be injected
     */
    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    /**
     * Retrieves a list of recent club news.
     *
     * @return {@link ResponseEntity} containing a {@link List} of {@link ClubName} representing recent news
     */
    @Operation(summary = "get recent club news", description = "Retrieves a list of the last 15 different games played")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "List of recent club news retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ClubName.class)))),
            @ApiResponse(responseCode = "404",
                    description = "No club news found",
                    content = @Content())
    })
    @GetMapping("/get_recent_clubs_news")
    public ResponseEntity<Optional<List<ClubName>>> getRecentClubsNews() {
        Optional<List<ClubName>> result = clubService.getRecentClubsNews();
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Retrieves a list of club IDs whose names start with the specified letter.
     *
     * @param letter The starting letter of club names
     * @return {@link ResponseEntity} containing a {@link List} of {@link Long}(club IDs) whose names start with the specified letter
     */
    @Operation(summary = "find clubs by letter", description = "Retrieves the list of clubs that has the name that begin with a certain string")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "List of clubs retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Long.class)))),
            @ApiResponse(responseCode = "404",
                    description = "No clubs found with the specified capital letter",
                    content = @Content())
    })
    @GetMapping("/club_by_letter/{letter}")
    public ResponseEntity<Optional<List<Long>>> findClubsByLetter(@PathVariable String letter) {
        Optional<List<Long>> result = clubService.findClubsByLetter(letter);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Retrieves a list of clubs by their local competition code.
     *
     * @param localCompetitionCode The local competition code
     * @return {@link ResponseEntity} containing a {@link List} of {@link ClubName} with the specified local competition code
     */
    @Operation(summary = "find clubs by local competition code", description = "Retrieves the list of clubs that come from a certain nation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "List of clubs retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ClubName.class)))),
            @ApiResponse(responseCode = "404",
                    description = "No clubs found with the specified localCompetitionCode",
                    content = @Content())
    })
    @GetMapping("/clubs_by_nation/{localCompetitionCode}")
    public ResponseEntity<Optional<List<ClubName>>> findClubsByLocalCompetitionCode(@PathVariable String localCompetitionCode) {
        Optional<List<ClubName>> result = clubService.findClubsByLocalCompetitionCode(localCompetitionCode);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Retrieves a list of clubs whose names contain the specified string.
     *
     * @param name The string to search for in club names
     * @return {@link ResponseEntity} containing a {@link List} of {@link ClubByNation} with names containing the specified string
     */
    @Operation(description = "Retrieves the list of clubs whose name contains a certain string")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "List of clubs retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ClubByNation.class)))),
            @ApiResponse(responseCode = "404",
                    description = "No clubs found with the specified name",
                    content = @Content())
    })
    @GetMapping("/clubs_by_string/{name}")
    public ResponseEntity<Optional<List<ClubByNation>>> findClubsByClubNameContaining(@PathVariable String name) {
        Optional<List<ClubByNation>> result = clubService.findClubsByClubNameContaining(name);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Endpoint to add multiple clubs at once.
     *
     * @param clubs List of clubs to be added
     * @return {@link ResponseEntity} indicating success or failure of club addition
     */
    @Operation(summary = "Add multiple clubs", description = "Endpoint to add multiple clubs at once.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Clubs successfully loaded.",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Club.class)))),
            @ApiResponse(responseCode = "500",
                    description = "Error occurred while loading clubs",
                    content = @Content(mediaType = "application/json"))
    })
    @PostMapping("/add_clubs")
    public ResponseEntity<String> addClubs(@RequestBody List<Club> clubs) {
        return clubService.saveClubs(clubs) != null ? ResponseEntity.ok("Clubs successfully loaded!")
                : ResponseEntity.internalServerError().body("Error occurred while loading Clubs!");
    }

    /**
     * Retrieves a club with a certain name.
     *
     * @param name The name of the club to retrieve
     * @return {@link ResponseEntity} containing the {@link Club} with the specified name, if found
     */
    @Operation(summary = "find club by name", description = "Retrieves a club with a certain name")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "club retrieved successfully",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Club.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "No club found with specified name",
                    content = @Content)
    })
    @GetMapping("/club_by_name/{name}")
    public ResponseEntity<Optional<Club>> findClubByClubName(@PathVariable String name) {
        Optional<Club> result = clubService.findClubByClubName(name);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Retrieve a club with a certain id.
     *
     * @param id The ID of the club to retrieve
     * @return {@link ResponseEntity} containing the {@link Club} with the specified ID, if found
     */
    @Operation(description = "Retrieve a club with a certain id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Club found successfully",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Club.class))),
            @ApiResponse(
                    responseCode = "404",
                    description = "Club not found",
                    content = @Content
            )
    })
    @GetMapping("/get_club_by_id/{id}")
    public ResponseEntity<Optional<Club>> getClubById(@PathVariable Long id) {
        Optional<Club> result = clubService.getClubById(id);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Retrieve a club name with a certain ID.
     *
     * @param id The ID of the club to retrieve
     * @return {@link ResponseEntity} containing the {@link ClubName} with the specified ID, if found
     */
    @Operation(description = "Retrieve a club name with a certain id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Club name found successfully",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ClubName.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Club ID not found",
                    content = @Content
            )
    })
    @GetMapping("/get_club_name_by_id/{id}")
    public ResponseEntity<Optional<ClubName>> getClubNameById(@PathVariable Long id) {
        Optional<ClubName> result = clubService.findClubNameByClubId(id);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Retrieves a list of competition ID that a club had take part.
     *
     * @param id The ID of the club
     * @return {@link ResponseEntity} containing a {@link List} of {@link String} that represents the competition ID
     */
    @Operation(summary = "Get the list of competition of a club",
            description = "Retrieve a list of competition IDs representing the competitions that a certain club as participated in.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "List of competition IDs found successfully",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = String.class)))),
            @ApiResponse(responseCode = "404",
                    description = "No Competition ID found",
                    content = @Content())
    })
    @GetMapping("/get_club_competitions_id/{id}")
    public ResponseEntity<Optional<List<String>>> getClubsCompetitionId(@PathVariable Long id) {
        Optional<List<String>> result = clubService.getClubsCompetitionId(id);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Retrieves a list of Player Cards representing the active member of a certain club.
     *
     * @param clubId The ID of the club
     * @return {@link ResponseEntity} containing a {@link List} of {@link PlayerCard} representing the list of Player of a certain Club
     */
    @Operation(summary = "Get the list of players of a club",
            description = "Retrieves a list of Player Cards representing the active member of a certain club.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "List of Player's Card retrieved successfully",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PlayerCard.class)))),
            @ApiResponse(responseCode = "404",
                    description = "No Players found or no Club found",
                    content = @Content())
    })
    @GetMapping("/get_current_players/{clubId}")
    public ResponseEntity<Optional<List<PlayerCard>>> getPlayersOfClub(@PathVariable Long clubId) {
        Optional<List<PlayerCard>> result = clubService.getCurrentPlayerOfClub(clubId);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Retrieves a list of Player Cards representing the past member of a certain club.
     *
     * @param clubId The ID of the club
     * @return {@link ResponseEntity} containing a {@link List} of {@link PlayerCard} representing the list of the past Player of a certain Club
     */
    @Operation(summary = "Get the list of past players of a club",
            description = "Retrieves a list of Player Cards representing the past member of a certain club.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "List of Player's Card successfully",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PlayerCard.class)))),
            @ApiResponse(responseCode = "404",
                    description = "No Players found or no Club found",
                    content = @Content())
    })
    @GetMapping("/get_past_players/{clubId}")
    public ResponseEntity<Optional<List<PlayerCard>>> getPastPlayersOfClub(@PathVariable Long clubId) {
        Optional<List<PlayerCard>> result = clubService.getPastPlayerOfClub(clubId);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
