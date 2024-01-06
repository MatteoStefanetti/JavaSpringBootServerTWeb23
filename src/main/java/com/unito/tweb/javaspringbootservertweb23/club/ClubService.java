package com.unito.tweb.javaspringbootservertweb23.club;

import org.springframework.stereotype.Service;

@Service
public class ClubService {
    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }
}
