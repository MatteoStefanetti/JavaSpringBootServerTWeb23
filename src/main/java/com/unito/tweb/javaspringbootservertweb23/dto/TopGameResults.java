package com.unito.tweb.javaspringbootservertweb23.dto;

import java.sql.Timestamp;

public class TopGameResults {
    private Long game_id;
    private Timestamp game_date;
    private String competition_id;
    private String home_team;
    private Integer home_team_goals;
    private String away_team;
    private Integer away_team_goals;

    public TopGameResults(Long game_id, Timestamp game_date, String competition_id, String home_team, Integer home_team_goals, String away_team, Integer away_team_goals) {
        this.game_id = game_id;
        this.game_date = game_date;
        this.competition_id = competition_id;
        this.home_team = home_team;
        this.home_team_goals = home_team_goals;
        this.away_team = away_team;
        this.away_team_goals = away_team_goals;
    }

    public TopGameResults(){}

    public Long getGame_id() {
        return game_id;
    }

    public void setGame_id(Long game_id) {
        this.game_id = game_id;
    }

    public Timestamp getGame_date() {
        return game_date;
    }

    public void setGame_date(Timestamp game_date) {
        this.game_date = game_date;
    }

    public String getCompetition_id() {
        return competition_id;
    }

    public void setCompetition_id(String competition_id) {
        this.competition_id = competition_id;
    }

    public String getHome_team() {
        return home_team;
    }

    public void setHome_team(String home_team) {
        this.home_team = home_team;
    }

    public Integer getHome_team_goals() {
        return home_team_goals;
    }

    public void setHome_team_goals(Integer home_team_goals) {
        this.home_team_goals = home_team_goals;
    }

    public String getAway_team() {
        return away_team;
    }

    public void setAway_team(String away_team) {
        this.away_team = away_team;
    }

    public Integer getAway_team_goals() {
        return away_team_goals;
    }

    public void setAway_team_goals(Integer away_team_goals) {
        this.away_team_goals = away_team_goals;
    }


}
