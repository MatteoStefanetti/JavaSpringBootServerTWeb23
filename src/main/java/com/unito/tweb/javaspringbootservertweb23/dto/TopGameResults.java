package com.unito.tweb.javaspringbootservertweb23.dto;

import java.sql.Timestamp;

public record TopGameResults(
        Long game_id,
        Timestamp game_date,
        String competition_id,
        String home_team,
        Integer home_team_goals,
        String away_team,
        Integer away_team_goals
) {
}
