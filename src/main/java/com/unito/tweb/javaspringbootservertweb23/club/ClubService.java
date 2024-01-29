package com.unito.tweb.javaspringbootservertweb23.club;

import com.unito.tweb.javaspringbootservertweb23.dto.*;
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

    public List<ClubName> getRecentClubsNews(){
        List<Map<String, Object>> clubs = clubRepository.getRecentClubsNews();
        List<ClubName> clubNameList = new ArrayList<>();
        for (Map<String, Object> club : clubs ){
            ClubName clubName = new ClubName(
                    (Long) club.get("club_id"),
                    (String) club.get("club_name")
            );
            clubNameList.add(clubName);
        }
        return clubNameList;
    }

    public List<Club> findClubsByLocalCompetitionCode(String localCompetitionCode) {
        return clubRepository.getClubsByLocalCompetitionCode(localCompetitionCode);
    }

    public List<Long> findClubsByLetter(String letter) {
        return clubRepository.findClubsByLetter(letter);
    }

    public List<Club> findClubsByClubNameContaining(String name) {
        return clubRepository.findClubsByClubNameContaining(name);
    }

    public Club findClubByClubName(String name){
        return clubRepository.findClubByClubName(name);
    }

    public Optional<Club> getClubById(Long id){
        return clubRepository.findByClubId(id);
    }
}
