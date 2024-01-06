package com.unito.tweb.javaspringbootservertweb23.club_game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClubGameController {
    private final ClubGameService clubGameService;

    @Autowired
    public ClubGameController(ClubGameService clubGameService) {
        this.clubGameService = clubGameService;
    }
}
