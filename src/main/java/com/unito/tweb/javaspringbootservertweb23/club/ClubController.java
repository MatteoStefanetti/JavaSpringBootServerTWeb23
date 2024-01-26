package com.unito.tweb.javaspringbootservertweb23.club;

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

    @GetMapping("/club_by_letter")
    public ResponseEntity<String> findClubsByLetter(@RequestBody String letter) {
        List<Long> squad = clubService.findClubsByLetter(letter);
        return ResponseEntity.ok(squad.toString());
    }

    @GetMapping("/clubs_by_nation")
    public ResponseEntity<List<Club>> findClubsByLocalCompetitionCode(@RequestBody String localCompetitionCode) {
        List<Club> squad = clubService.findClubsByLocalCompetitionCode(localCompetitionCode);
        return ResponseEntity.ok(squad);
    }

    @GetMapping("/clubs_by_string")
    public ResponseEntity<List<Club>> findClubsByClubNameContaining(@RequestBody String name) {
        List<Club> squad = clubService.findClubsByClubNameContaining(name);
        return ResponseEntity.ok(squad);
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
    public ResponseEntity<Optional<Club>> getClubById(@RequestBody Long id){
        Optional<Club> result = clubService.getClubById(id);
        return result.map(value -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
