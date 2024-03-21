package com.unito.tweb.javaspringbootservertweb23.game;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

/**
 * Class representing a game.
 */
@Entity
@Table(name = "games")
public class Game {

    /**
     * Unique identifier of the game
     */
    @Id
    @Column(name = "game_id", nullable = false)
    @JsonProperty("game_id")
    private Long gameId;

    /**
     * Identifier of the competition to which the game belong
     */
    @Column(name = "competition_id", nullable = false)
    @JsonProperty("competition_id")
    private String competitionId;

    /**
     * Season of the game
     */
    @Column(name = "season", nullable = false)
    @JsonProperty("season")
    private Integer season;

    /**
     * Round of the game
     */
    @Column(name = "round", nullable = false)
    @JsonProperty("round")
    private String round;

    /**
     * Date of the game
     */
    @Column(name = "game_date", nullable = false)
    @JsonProperty("date")
    private Date gameDate;

    /**
     * Stadium where the game took place
     */
    @Column(name = "stadium")
    @JsonProperty("stadium")
    private String stadium;

    /**
     * Number of spectators attending the game
     */
    @Column(name = "attendance")
    @JsonProperty("attendance")
    private Integer attendance;

    /**
     * Referee of the game
     */
    @Column(name = "referee")
    @JsonProperty("referee")
    private String referee;

    /**
     * Constructor for the Game class.
     *
     * @param gameId        Unique identifier of the game
     * @param competitionId Identifier of the competition
     * @param season        Season of the game
     * @param round         Round of the game
     * @param gameDate      Date of the game
     * @param stadium       Stadium of the game
     * @param attendance    Number of spectators present
     * @param referee       Referee of the game
     */
    public Game(Long gameId, String competitionId, Integer season, String round, Date gameDate, String stadium, Integer attendance, String referee) {
        this.gameId = gameId;
        this.competitionId = competitionId;
        this.season = season;
        this.round = round;
        this.gameDate = gameDate;
        this.stadium = stadium;
        this.attendance = attendance;
        this.referee = referee;
    }

    /**
     * Empty constructor of the Game class.
     */
    public Game() {

    }

// Getter and setter methods for the class attributes.

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
}
