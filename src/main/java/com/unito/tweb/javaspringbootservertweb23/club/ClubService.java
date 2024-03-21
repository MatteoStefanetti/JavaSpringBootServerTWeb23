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

    public Optional<List<ClubName>> getRecentClubsNews() {
        List<Map<String, Object>> clubs = clubRepository.getRecentClubsNews();

        if (clubs.isEmpty())
            return Optional.empty();

        List<ClubName> clubNameList = clubs.stream()
                .map(club -> new ClubName(
                        (Long) club.get("club_id"),
                        (String) club.get("club_name")
                )).toList();

        return Optional.of(clubNameList);
    }

    public Optional<List<VisualizeClub>> findClubsByLocalCompetitionCode(String localCompetitionCode) {
        List<Club> clubList = clubRepository.getClubsByLocalCompetitionCode(localCompetitionCode);

        if (clubList.isEmpty())
            return Optional.empty();

        List<VisualizeClub> visualizeClubList = clubList.stream().
                map(club -> new VisualizeClub(
                        club.getClubId(),
                        club.getClubName()
                )).toList();

        return Optional.of(visualizeClubList);
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
