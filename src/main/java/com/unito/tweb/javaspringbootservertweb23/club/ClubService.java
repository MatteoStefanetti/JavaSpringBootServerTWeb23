package com.unito.tweb.javaspringbootservertweb23.club;

import com.unito.tweb.javaspringbootservertweb23.dto.ClubByNation;
import com.unito.tweb.javaspringbootservertweb23.dto.ClubName;
import com.unito.tweb.javaspringbootservertweb23.dto.PlayerCard;
import com.unito.tweb.javaspringbootservertweb23.player.Player;
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
     * @param clubId The starting letter of club names
     * @return A list of club IDs whose names start with the specified letter
     */
    public Optional<ClubName> findClubNameByClubId(Long clubId) {
        Map<String, Object> club = clubRepository.findClubNameByClubId(clubId);
        if (club.isEmpty())
            return Optional.empty();
        ClubName result = new ClubName(
                (Long) club.get("club_id"),
                (String) club.get("club_name")
        );
        return Optional.of(result);
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

    /**
     * Retrieves a list of Players that are active member of a certain Club.
     *
     * @param clubId The ID of the club
     * @return A list of Player Card representing the list of Player of a certain Club
     */
    public Optional<List<PlayerCard>> getCurrentPlayerOfClub(Long clubId) {
        List<Map<String, Object>> playersList = clubRepository.findPlayersByCurrentClubIdAndLastSeason(clubId);
        return getPlayerCards(playersList);
    }

    /**
     * Retrieves a list of Players that are past member of a certain Club.
     *
     * @param clubId The ID of the club
     * @return A list of Player Card representing the list of Player that played, at the end of their career, in a certain Club
     */
    public Optional<List<PlayerCard>> getPastPlayerOfClub(Long clubId) {
        List<Map<String, Object>> playersList = clubRepository.findPastPlayerByCurrentClubId(clubId);
        return getPlayerCards(playersList);
    }

    /**
     * Method to extract a List of PlayerCard dto from a List of Map object.
     *
     * @param playersList The List of Map object that contains the data of the Player Card
     * @return The List of Player Card or an Empty Optional if the initial List was empty
     */
    private Optional<List<PlayerCard>> getPlayerCards(List<Map<String, Object>> playersList) {
        if (playersList.isEmpty())
            return Optional.empty();

        List<PlayerCard> playerCardList = playersList.stream()
                .map(player -> new PlayerCard(
                        (Long) player.get("player_id"),
                        (String) player.get("player_name"),
                        (String) player.get("last_name"),
                        (String) player.get("image_url")
                ))
                .toList();

        return Optional.of(playerCardList);
    }
}
