package com.unito.tweb.javaspringbootservertweb23.dto;

import java.sql.Timestamp;

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
