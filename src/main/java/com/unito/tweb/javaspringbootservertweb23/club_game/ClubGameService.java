package com.unito.tweb.javaspringbootservertweb23.club_game;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for handling ClubGame entities.
 * Provides methods to save individual ClubGame instances or lists of ClubGame instances.
 */
@Service
public class ClubGameService {
    private final ClubGameRepository clubGameRepository;

    /**
     * Constructs a new {@code ClubGameService} with the specified {@link ClubGameRepository}.
     *
     * @param clubGameRepository The ClubGame repository to be used by this service
     */
    public ClubGameService(ClubGameRepository clubGameRepository) {
        this.clubGameRepository = clubGameRepository;
    }

    /**
     * Saves a single ClubGame instance to the database.
     *
     * @param clubGame The ClubGame instance to be saved
     * @return The saved {@link ClubGame} instance
     */
    public ClubGame saveClubGame(ClubGame clubGame) {
        return clubGameRepository.save(clubGame);
    }

    /**
     * Saves a list of ClubGame instances to the database.
     *
     * @param clubGames The list of ClubGame instances to be saved
     * @return The {@link List} of saved {@link ClubGame} instances
     */
    public List<ClubGame> saveClubGames(List<ClubGame> clubGames) {
        return clubGameRepository.saveAll(clubGames);
    }
}
