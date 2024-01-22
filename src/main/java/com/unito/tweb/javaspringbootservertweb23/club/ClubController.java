package com.unito.tweb.javaspringbootservertweb23.club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
public class ClubController {
    private final ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/club_by_letter")
    public ResponseEntity<String> findClubsByLetter(@RequestBody String letter){
        List<Long> squad = clubService.findClubsByLetter(letter);
        return ResponseEntity.ok(squad.toString());
    }

    @GetMapping("/clubs_by_nation")
    public ResponseEntity<List<Long>> findClubsByLocalCompetitionCode(@RequestBody String localCompetitionCode) {
        List<Long> squad = clubService.findClubsByLocalCompetitionCode(localCompetitionCode);
        return ResponseEntity.ok(squad);
    }

    @GetMapping("/clubs_by_name")
    public ResponseEntity<List<Long>> findClubsByClubName (@RequestBody String name){
        List<Long> squad = clubService.findClubsByClubName(name);
        return ResponseEntity.ok(squad);
    }

    @PostMapping("/add_clubs")
    public ResponseEntity<String> addClubs(@RequestBody List<Club> clubs) {
        clubService.saveClubs(clubs);
        return ResponseEntity.ok("Clubs successfully loaded!");
    }
}
