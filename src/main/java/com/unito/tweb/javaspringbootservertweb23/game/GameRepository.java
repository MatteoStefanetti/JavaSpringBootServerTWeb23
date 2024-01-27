package com.unito.tweb.javaspringbootservertweb23.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findByGameId(Long id);

    @Query(value = " select G.game_id, G.game_date, G.competition_id, C1.club_name AS home_team," +
            " CG1.own_goal AS home_team_goals, C2.club_name AS away_team, CG2.own_goal AS away_team_goals " +
            "FROM GAMES G " +
            "JOIN CLUB_GAMES CG1 ON G.game_id = CG1.game_id " +
            "JOIN CLUBS C1 ON CG1.club_id = C1.club_id " +
            "JOIN CLUB_GAMES CG2 ON G.game_id = CG2.game_id AND CG1.club_id <> CG2.club_id " +
            "JOIN CLUBS C2 ON CG2.club_id = C2.club_id " +
            "WHERE CG1.club_id < CG2.club_id " +
            "ORDER BY game_date DESC LIMIT 20", nativeQuery = true)
    List<Map<String, Object>> getLastGames();
}
