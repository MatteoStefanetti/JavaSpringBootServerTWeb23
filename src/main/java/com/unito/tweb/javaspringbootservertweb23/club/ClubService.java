package com.unito.tweb.javaspringbootservertweb23.club;

import com.unito.tweb.javaspringbootservertweb23.dto.ClubByNation;
import com.unito.tweb.javaspringbootservertweb23.dto.ClubName;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Service class for managing club-related operations.
 */
@Service
public class ClubService {
    private final ClubRepository clubRepository;

    /**
     * Constructor for ClubService.
     *
     * @param clubRepository Club repository to be injected
     */
    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    /**
     * Saves a club.
     *
     * @param club The club to be saved
     * @return The saved club
     */
    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }

    /**
     * Saves a list of clubs.
     *
     * @param clubs The list of clubs to be saved
     * @return The list of saved clubs
     */
    public List<Club> saveClubs(List<Club> clubs) {
        return clubRepository.saveAll(clubs);
    }

    /**
     * Retrieves a list of recent club news.
     *
     * @return A list of club names and IDs representing recent news
     */
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

    /**
     * Retrieves clubs by their local competition code.
     *
     * @param localCompetitionCode The local competition code
     * @return A list of clubs with the specified local competition code
     */
    public Optional<List<ClubName>> findClubsByLocalCompetitionCode(String localCompetitionCode) {
        List<Club> clubList = clubRepository.getClubsByLocalCompetitionCode(localCompetitionCode);

        if (clubList.isEmpty())
            return Optional.empty();

        List<ClubName> clubNameList = clubList.stream().
                map(club -> new ClubName(
                        club.getClubId(),
                        club.getClubName()
                )).toList();

        return Optional.of(clubNameList);
    }

    /**
     * Retrieves club IDs whose names start with the specified letter.
     *
     * @param letter The starting letter of club names
     * @return A list of club IDs whose names start with the specified letter
     */
    public Optional<List<Long>> findClubsByLetter(String letter) {
        List<Long> clubIds = clubRepository.findClubsByLetter(letter);
        return clubIds.isEmpty() ? Optional.empty() : Optional.of(clubIds);
    }

    /**
     * Retrieves clubs whose names contain the specified string.
     *
     * @param name The string to search for in club names
     * @return A list of clubs whose names contain the specified string
     */
    public Optional<List<ClubByNation>> findClubsByClubNameContaining(String name) {
        List<Club> clubList = clubRepository.findClubsByClubNameIgnoreCaseContaining(name);

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

    /**
     * Retrieves a club by its name.
     *
     * @param name The name of the club
     * @return An optional containing the club if found, otherwise empty
     */
    public Optional<Club> findClubByClubName(String name) {
        return clubRepository.findClubByClubName(name);
    }

    /**
     * Retrieves a club by its ID.
     *
     * @param id The ID of the club
     * @return An optional containing the club if found, otherwise empty
     */
    public Optional<Club> getClubById(Long id) {
        return clubRepository.findByClubId(id);
    }

    /**
     * Retrieves a list of competition ID that the club had take part.
     *
     * @param id The ID of the club
     * @return A list of String that represents the competition ID that the club had take part
     */
    public Optional<List<String>> getClubsCompetitionId(Long id) {
        return clubRepository.getClubsCompetitionId(id);
    }
}
