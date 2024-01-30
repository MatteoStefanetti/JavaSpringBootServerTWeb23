package com.unito.tweb.javaspringbootservertweb23.club;

import com.unito.tweb.javaspringbootservertweb23.dto.VisualizeClub;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public List<VisualizeClub> findClubsByLocalCompetitionCode(String localCompetitionCode) {
        List<Club> clubList = clubRepository.getClubsByLocalCompetitionCode(localCompetitionCode);
        List<VisualizeClub> visualizeClubList = new ArrayList<>();
        for (Club club : clubList) {
            VisualizeClub visualizeClub = new VisualizeClub(
                    club.getClubId(),
                    club.getClubName()
            );
            visualizeClubList.add(visualizeClub);
        }
        return visualizeClubList;
    }

    public List<Long> findClubsByLetter(String letter) {
        return clubRepository.findClubsByLetter(letter);
    }

    public List<Club> findClubsByClubNameContaining(String name) {
        return clubRepository.findClubsByClubNameContaining(name);
    }

    public Club findClubByClubName(String name) {
        return clubRepository.findClubByClubName(name);
    }

    public Optional<Club> getClubById(Long id) {
        return clubRepository.findByClubId(id);
    }
}
