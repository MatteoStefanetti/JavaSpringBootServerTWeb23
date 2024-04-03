package com.unito.tweb.javaspringbootservertweb23.club;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Repository interface for accessing and managing club data in the database.
 */
@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    /**
     * Retrieves a list of competition ID that the club had take part.
     *
     * @param id The ID of the club
     * @return A list of String that represents the competition ID that the club had take part
     */
    @Query(value = "select distinct g.competition_id " +
            "from clubs c " +
            "join club_games cg on c.club_id = cg.club_id " +
            "join games g on cg.game_id = g.game_id " +
            "where c.club_id = :id", nativeQuery = true)
    Optional<List<String>> getClubsCompetitionId(Long id);

    /**
     * Retrieves a list of recent club news.
     *
     * @return A list of maps containing club ID, club name, game ID, and game date
     */
    @Query(value = "select distinct c.club_id, c.club_name, g.game_id, g.game_date " +
            "from games g " +
            "join club_games cg on g.game_id = cg.game_id " +
            "join clubs c on cg.club_id = c.club_id " +
            "order by g.game_date desc limit 15", nativeQuery = true)
    List<Map<String, Object>> getRecentClubsNews();

    /**
     * Retrieves a list of clubs based on the local competition code.
     *
     * @param localCompetitionCode The local competition code
     * @return A list of clubs matching the provided local competition code
     */
    List<Club> getClubsByLocalCompetitionCode(String localCompetitionCode);

    /**
     * Retrieves a list of clubs whose names contain the provided string.
     *
     * @param name The string to search for in club names
     * @return A list of clubs whose names contain the provided string
     */
    List<Club> findClubsByClubNameContaining(String name);

    /**
     * Retrieves a club by its name.
     *
     * @param name The name of the club
     * @return An optional containing the club if found, otherwise empty
     */
    Optional<Club> findClubByClubName(String name);

    /**
     * Retrieves a list of club IDs whose names start with the provided letter.
     *
     * @param letter The starting letter of club name
     * @return A list of club IDs whose name start with the provided letter
     */
    @Query(value = "select c.club_id from clubs c where c.club_name like :letter%", nativeQuery = true)
    List<Long> findClubsByLetter(String letter);

    /**
     * Retrieves a club by its ID.
     *
     * @param id The ID of the club
     * @return An optional containing the club if found, otherwise empty
     */
    Optional<Club> findByClubId(Long id);
}
