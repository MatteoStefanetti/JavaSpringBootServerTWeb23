package com.unito.tweb.javaspringbootservertweb23.club;

import com.unito.tweb.javaspringbootservertweb23.dto.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<ClubName> getRecentClubsNews() {
        List<Map<String, Object>> clubs = clubRepository.getRecentClubsNews();
        List<ClubName> clubNameList = new ArrayList<>();
        for (Map<String, Object> club : clubs) {
            ClubName clubName = new ClubName(
                    (Long) club.get("club_id"),
                    (String) club.get("club_name")
            );
            clubNameList.add(clubName);
        }
        return clubNameList;
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

    public Optional<List<Long>> findClubsByLetter(String letter) {
        List<Long> clubIds = clubRepository.findClubsByLetter(letter);
        return clubIds.isEmpty() ? Optional.empty() : Optional.of(clubIds);
    }

    public Optional<List<ClubByNation>> findClubsByClubNameContaining(String name) {
        List<Club> clubList = clubRepository.findClubsByClubNameContaining(name);

        if (clubList.isEmpty()) {
            return Optional.empty();
        }

        List<ClubByNation> clubByNationList = clubList.stream()
                .map(club -> new ClubByNation(
                        club.getClubId(),
                        club.getClubName(),
                        club.getLocalCompetitionCode()
                ))
                .toList();

        return Optional.of(clubByNationList);
    }

    public Optional<Club> findClubByClubName(String name) {
        return clubRepository.findClubByClubName(name);
    }

    public Optional<Club> getClubById(Long id) {
        return clubRepository.findByClubId(id);
    }
}
