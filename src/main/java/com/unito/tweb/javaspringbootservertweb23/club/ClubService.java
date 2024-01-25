package com.unito.tweb.javaspringbootservertweb23.club;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {
    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }

    public List<Club> saveClubs(List<Club> clubs) {
        return clubRepository.saveAll(clubs);
    }

    public List<Long> findClubsByLocalCompetitionCode(String localCompetitionCode) {
        return clubRepository.findClubsByLocalCompetitionCode(localCompetitionCode);
    }

    public List<Long> findClubsByLetter(String letter) {
        return clubRepository.findClubsByLetter(letter);
    }

    public List<Long> findClubsByString(String name) {
        return clubRepository.findClubsByString(name);
    }

    public Club findClubByClubName(String name){
        return clubRepository.findClubByClubName(name);
    }
}
