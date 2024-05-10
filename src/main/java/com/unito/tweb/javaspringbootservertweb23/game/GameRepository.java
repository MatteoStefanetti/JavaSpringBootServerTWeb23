package com.unito.tweb.javaspringbootservertweb23.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Repository interface for mapping Game entities.
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    /**
     * Retrieves a game by its ID.
     *
     * @param id The ID of the game to retrieve
     * @return An optional containing the retrieved game entity, if found
     */
    Optional<Game> findByGameId(Long id);

    /**
     * Retrieves the last 20 games played.
     *
     * @return A list of maps representing the last 20 games played, each containing game data
     */
    @Query(value = "select g.game_id, g.game_date, g.competition_id, c1.club_name as clubName1, c1.club_id as clubId1, cg1.own_goal as goal1, c2.club_name as clubName2, c2.club_id as clubId2, cg2.own_goal as goal2 " +
            "FROM GAMES G " +
            "JOIN CLUB_GAMES CG1 ON G.game_id = CG1.game_id " +
            "JOIN CLUBS C1 ON CG1.club_id = C1.club_id " +
            "JOIN CLUB_GAMES CG2 ON G.game_id = CG2.game_id AND CG1.club_id <> CG2.club_id " +
            "JOIN CLUBS C2 ON CG2.club_id = C2.club_id " +
            "WHERE CG1.club_id < CG2.club_id " +
            "ORDER BY game_date DESC LIMIT 24", nativeQuery = true)
    List<Map<String, Object>> getLastGames();

    /**
     * Retrieves games by competition ID and season.
     *
     * @param competitionId The ID of the competition
     * @param season        The season of the games to retrieve
     * @return A list of maps representing the games matching the criteria, each containing game data
     */
    @Query(value = "select g.game_id, g.game_date, g.competition_id, c1.club_name as clubName1, c1.club_id as clubId1, cg1.own_goal as goal1, c2.club_name as clubName2, c2.club_id as clubId2, cg2.own_goal as goal2 " +
            "from games g " +
            "join club_games cg1 on g.game_id = cg1.game_id " +
            "join clubs c1 on cg1.club_id = c1.club_id " +
            "join club_games cg2 on g.game_id = cg2.game_id and cg1.club_id <> cg2.club_id " +
            "join clubs c2 on cg2.club_id = c2.club_id " +
            "where cg1.club_id < cg2.club_id and g.competition_id like :competitionId and g.season = :season " +
            "order by g.game_date desc", nativeQuery = true)
    List<Map<String, Object>> getGamesByCompetitionIdAndSeason(String competitionId, Integer season);

    /**
     * @return an Integer for the last season found in the database for the given competition_id.
     */
    @Query(value = "select g.season from games g " +
            "where g.competition_id like :competitionId " +
            "order by g.season desc LIMIT 1", nativeQuery = true)
    Map<String, Object> getLastSeason(String competitionId);

    /**
     * Retrieves games by competition ID and season, excluding a specific season.
     *
     * @param competitionId The ID of the competition
     * @param season        The season of the games to exclude
     * @return A list of maps representing the games matching the criteria, each containing game data
     */
    @Query(value = "select g.game_id, g.game_date, g.competition_id, c1.club_name as clubName1, c1.club_id as clubId1, cg1.own_goal as goal1, c2.club_name as clubName2, c2.club_id as clubId2, cg2.own_goal as goal2 " +
            "from games g " +
            "join club_games cg1 on g.game_id = cg1.game_id " +
            "join clubs c1 on cg1.club_id = c1.club_id " +
            "join club_games cg2 on g.game_id = cg2.game_id and cg1.club_id <> cg2.club_id " +
            "join clubs c2 on cg2.club_id = c2.club_id " +
            "where cg1.club_id < cg2.club_id and g.competition_id like :competitionId and g.season <> :season " +
            "order by g.game_date desc", nativeQuery = true)
    List<Map<String, Object>> getGamesByCompetitionIdAndSeasonNot(String competitionId, Integer season);

    /**
     * Retrieves games by the name of a club.
     *
     * @param clubName The name of the club
     * @return A list of maps representing the games involving the club, each containing game data
     */
    @Query(value = "select g.game_id, g.game_date, g.competition_id, c1.club_name as clubName1, c1.club_id as clubId1, cg1.own_goal as goal1, c2.club_name as clubName2, c2.club_id as clubId2, cg2.own_goal as goal2 " +
            "from games g " +
            "join club_games cg1 on g.game_id = cg1.game_id " +
            "join clubs c1 on c1.club_id = cg1.club_id " +
            "join club_games cg2 on g.game_id = cg2.game_id and cg1.club_id <> cg2.club_id " +
            "join clubs c2 on cg2.club_id = c2.club_id " +
            "where c1.club_id < c2.club_id and (c1.club_name like %:clubName% or c2.club_name like %:clubName%)" +
            "order by game_date desc", nativeQuery = true)
    List<Map<String, Object>> getGamesByClubName(String clubName);

    /**
     * Retrieves games involving two clubs.
     *
     * @param clubName1 The name of the first club
     * @param clubName2 The name of the second club
     * @return A list of maps representing the games involving both clubs, each containing game data
     */
    @Query(value = "select g.game_id, g.game_date, g.competition_id, c1.club_name as clubName1, c1.club_id as clubId1, cg1.own_goal as goal1, c2.club_name as clubName2, c2.club_id as clubId2, cg2.own_goal as goal2 " +
            "from games g " +
            "join club_games cg1 on g.game_id = cg1.game_id " +
            "join clubs c1 on c1.club_id = cg1.club_id " +
            "join club_games cg2 on g.game_id = cg2.game_id and cg1.club_id <> cg2.club_id " +
            "join clubs c2 on cg2.club_id = c2.club_id " +
            "where c1.club_id < c2.club_id and ((c1.club_name like %:clubName1% and c2.club_name like %:clubName2%) or " +
            "(c1.club_name like %:clubName2% and c2.club_name like %:clubName1%)) " +
            "order by game_date desc", nativeQuery = true)
    List<Map<String, Object>> getGamesByClubNames(String clubName1, String clubName2);

    /**
     * Retrieves games by a specific game date.
     *
     * @param gameDate The date of the games
     * @return A list of maps representing the games played on the specified date, each containing game data
     */
    @Query(value = "select g.game_id, g.game_date, g.competition_id, c1.club_name as clubName1, c1.club_id as clubId1, cg1.own_goal as goal1, c2.club_name as clubName2, c2.club_id as clubId2, cg2.own_goal as goal2 " +
            "from games g " +
            "join club_games cg1 on g.game_id = cg1.game_id " +
            "join clubs c1 on c1.club_id = cg1.club_id " +
            "join club_games cg2 on g.game_id = cg2.game_id and cg1.club_id <> cg2.club_id " +
            "join clubs c2 on cg2.club_id = c2.club_id " +
            "where c1.club_id < c2.club_id and cast (g.game_date as date) = :gameDate", nativeQuery = true)
    List<Map<String, Object>> getGamesByGameDate(Date gameDate);

    /**
     * Retrieves games by a club ID and a season year.
     *
     * @param id     The ID of the club
     * @param season The year of the season
     * @return A list of information relative to games that were played in the specified season by the specified club
     */
    @Query(value = "select g.game_id, g.game_date, g.competition_id, c1.club_name as clubName1, c1.club_id as clubId1, cg1.own_goal as goal1, c2.club_name as clubName2, c2.club_id as clubId2, cg2.own_goal as goal2 " +
            "from games g " +
            "join club_games cg1 on g.game_id = cg1.game_id " +
            "join clubs c1 on c1.club_id = cg1.club_id " +
            "join club_games cg2 on g.game_id = cg2.game_id and cg1.club_id <> cg2.club_id " +
            "join clubs c2 on cg2.club_id = c2.club_id " +
            "where c1.club_id < c2.club_id and (c1.club_id = :id or c2.club_id = :id) and g.season = :season", nativeQuery = true)
    List<Map<String, Object>> getGamesByGameIdAndSeason(Long id, Integer season);
}


