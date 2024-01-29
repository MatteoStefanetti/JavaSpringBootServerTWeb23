package com.unito.tweb.javaspringbootservertweb23.dto;

import java.sql.Timestamp;

public record GamesByName(
        Long gameId,
        Timestamp game_date,
        String competitionId,
        String clubName1,
        Integer goals1,
        String clubName2,
        Integer goals2
) {
}
