package com.unito.tweb.javaspringbootservertweb23.club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClubController {
    private final ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @PostMapping("/addClubs")
    public ResponseEntity<String> addClubs(@RequestBody List<Club> clubs){
        clubService.saveClubs(clubs);
        return ResponseEntity.ok("Clubs successfully loaded!");
    }
}
