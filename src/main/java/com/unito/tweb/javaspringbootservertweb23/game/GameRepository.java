package com.unito.tweb.javaspringbootservertweb23.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findByGameId(Long id);

    @Query(value = " select G.game_id, G.game_date, G.competition_id, C1.club_name AS club1," +
            " CG1.own_goal AS goal1, C2.club_name AS club2, CG2.own_goal AS goal2 " +
            "FROM GAMES G " +
            "JOIN CLUB_GAMES CG1 ON G.game_id = CG1.game_id " +
            "JOIN CLUBS C1 ON CG1.club_id = C1.club_id " +
            "JOIN CLUB_GAMES CG2 ON G.game_id = CG2.game_id AND CG1.club_id <> CG2.club_id " +
            "JOIN CLUBS C2 ON CG2.club_id = C2.club_id " +
            "WHERE CG1.club_id < CG2.club_id " +
            "ORDER BY game_date DESC LIMIT 20", nativeQuery = true)
    List<Map<String, Object>> getLastGames();

    @Query(value = "Select g.game_id, g.game_date, g.competition_id, c1.club_name as club1, c2.club_name as club2, cg1.own_goal as goal1, cg2.own_goal as goal2 " +
            "from games g " +
            "join club_games cg1 on g.game_id = cg1.game_id " +
            "join clubs c1 on cg1.club_id = c1.club_id " +
            "join club_games cg2 on g.game_id = cg2.game_id and cg1.club_id <> cg2.club_id " +
            "join clubs c2 on cg2.club_id = c2.club_id " +
            "where cg1.club_id < cg2.club_id and g.competition_id like :competitionId and g.season = :season " +
            "order by g.game_date desc", nativeQuery = true)
    List<Map<String, Object>> getGamesByCompetitionIdAndSeason(String competitionId, Integer season);

    @Query(value = "Select g.game_id, g.game_date, g.competition_id, c1.club_name as club1, c2.club_name as club2, cg1.own_goal as goal1, cg2.own_goal as goal2 " +
            "from games g " +
            "join club_games cg1 on g.game_id = cg1.game_id " +
            "join clubs c1 on cg1.club_id = c1.club_id " +
            "join club_games cg2 on g.game_id = cg2.game_id and cg1.club_id <> cg2.club_id " +
            "join clubs c2 on cg2.club_id = c2.club_id " +
            "where cg1.club_id < cg2.club_id and g.competition_id like :competitionId and g.season <> :season " +
            "order by g.game_date desc", nativeQuery = true)
    List<Map<String, Object>> getGamesByCompetitionIdAndSeasonNot(String competitionId, Integer season);
  
    @Query(value = "select g.game_id, g.game_date, g.competition_id, c1.club_name as club1, cg1.own_goal as goal1, c2.club_name as club2, cg2.own_goal as goal2 " +
            "from games g " +
            "join club_games cg1 on g.game_id = cg1.game_id " +
            "join clubs c1 on c1.club_id = cg1.club_id " +
            "join club_games cg2 on g.game_id = cg2.game_id and cg1.club_id <> cg2.club_id " +
            "join clubs c2 on cg2.club_id = c2.club_id " +
            "where c1.club_id < c2.club_id and c1.club_name like %:clubName% " +
            "order by game_date desc", nativeQuery = true)
    List<Map<String, Object>> getGamesByClubName(String clubName);

    @Query(value = "select g.game_id, g.game_date, g.competition_id, c1.club_name as club1, cg1.own_goal as goal1, c2.club_name as club2, cg2.own_goal as goal2 " +
            "from games g " +
            "join club_games cg1 on g.game_id = cg1.game_id " +
            "join clubs c1 on c1.club_id = cg1.club_id " +
            "join club_games cg2 on g.game_id = cg2.game_id and cg1.club_id <> cg2.club_id " +
            "join clubs c2 on cg2.club_id = c2.club_id " +
            "where c1.club_id < c2.club_id and c1.club_name like %:clubName1% and c2.club_name like %:clubName2% " +
            "order by game_date desc", nativeQuery = true)
    List<Map<String, Object>> getGamesByClubNames(String clubName1, String clubName2);

    @Query(value = "select g.game_id, g.game_date, g.competition_id, c1.club_name as club1, cg1.own_goal as goal1, c2.club_name as club2, cg2.own_goal as goal2 " +
            "from games g " +
            "join club_games cg1 on g.game_id = cg1.game_id " +
            "join clubs c1 on c1.club_id = cg1.club_id " +
            "join club_games cg2 on g.game_id = cg2.game_id and cg1.club_id <> cg2.club_id " +
            "join clubs c2 on cg2.club_id = c2.club_id " +
            "where c1.club_id < c2.club_id and cast (g.game_date as date) = :gameDate", nativeQuery = true)
    List<Map<String, Object>> getGamesByGameDate(Date gameDate);

}


