package com.unito.tweb.javaspringbootservertweb23.dto;

import java.sql.Timestamp;

/**
 * Record representing game information for visualization, containing details such as game ID, date, participating clubs, and scores.
 */
public record VisualizeGame(
        Long gameId,
        Timestamp gameDate,
        String competitionId,
        String club1,
        Integer goal1,
        String club2,
        Integer goal2
) {
}
