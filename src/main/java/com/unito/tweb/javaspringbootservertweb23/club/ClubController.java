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

    @GetMapping("/clubByLetter")
    public ResponseEntity<String> findClubsByLetter(@RequestBody String letter){
        List<Long> squad = clubService.findClubsByLetter(letter);
        return ResponseEntity.ok(squad.toString());
    }

    @GetMapping("/clubByLocal")
    public ResponseEntity<List<Long>> findClubsByLocalCompetitionCode(@RequestBody String localCompetitionCode) {
        List<Long> squad = clubService.findClubsByLocalCompetitionCode(localCompetitionCode);
        return ResponseEntity.ok(squad);
    }

    @GetMapping("/clubByName")
    public ResponseEntity<List<Long>> findClubsByClubName (@RequestBody String name){
        List<Long> squad = clubService.findClubsByClubName(name);
        return ResponseEntity.ok(squad);
    }

    @PostMapping("/addClubs")
    public ResponseEntity<String> addClubs(@RequestBody List<Club> clubs) {
        clubService.saveClubs(clubs);
        return ResponseEntity.ok("Clubs successfully loaded!");
    }
}
