package com.unito.tweb.javaspringbootservertweb23.club_game;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClubGameService {
    private final ClubGameRepository clubGameRepository;

    public ClubGameService(ClubGameRepository clubGameRepository) {
        this.clubGameRepository = clubGameRepository;
    }

    public ClubGame saveClubGame(ClubGame clubGame) {
        return clubGameRepository.save(clubGame);
    }

    public List<ClubGame> saveClubGames(List<ClubGame> clubGames) {
        return clubGameRepository.saveAll(clubGames);
    }
}
