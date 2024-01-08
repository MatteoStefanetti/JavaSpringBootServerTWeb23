package com.unito.tweb.javaspringbootservertweb23.game;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @Column(name = "game_id", nullable = false)
    private Long gameId;

    @Column(name = "competition_id", nullable = false)
    private String competitionId;

    @Column(name = "season", nullable = false)
    private Integer season;

    @Column(name = "round", nullable = false)
    private String round;

    @Column(name = "game_date", nullable = false)
    private Date gameDate;

    @Column(name = "stadium", nullable = false)
    private String stadium;

    @Column(name = "attendance")
    private Integer attendance;

    @Column(name = "referee", nullable = false)
    private String referee;

    @Column(name = "game_url", nullable = false)
    private String gameUrl;

    public Game(Long gameId, String competitionId, Integer season, String round, Date gameDate, String stadium, Integer attendance, String referee, String gameUrl) {
        this.gameId = gameId;
        this.competitionId = competitionId;
        this.season = season;
        this.round = round;
        this.gameDate = gameDate;
        this.stadium = stadium;
        this.attendance = attendance;
        this.referee = referee;
        this.gameUrl = gameUrl;
    }

    public Game() {

    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getGameUrl() {
        return gameUrl;
    }

    public void setGameUrl(String gameUrl) {
        this.gameUrl = gameUrl;
    }
}
