package com.unito.tweb.javaspringbootservertweb23.dto;

import java.sql.Timestamp;

/**
 * Record representing game information for visualization, containing details such as game ID, date, participating clubs, and scores.
 *
 * @param gameId        The ID of the game
 * @param gameDate      The date when the game take place
 * @param competitionId The ID of the competition
 * @param season        The season year of the game
 * @param clubName1     The name of the club1
 * @param clubId1       The ID of the club1
 * @param goal1         The goals scored by the club1
 * @param clubName2     The name of the club2
 * @param clubId2       The ID of the club2
 * @param goal2         The goals scored by the club2
 */
public record VisualizeGame(
        Long gameId,
        Timestamp gameDate,
        String competitionId,
        Integer season,
        String clubName1,
        Long clubId1,
        Integer goal1,
        String clubName2,
        Long clubId2,
        Integer goal2
) {
}
