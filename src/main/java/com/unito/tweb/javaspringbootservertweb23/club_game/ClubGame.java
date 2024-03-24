package com.unito.tweb.javaspringbootservertweb23.club_game;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

/**
 * Represents a game played by a club, including details such as game ID, club ID, goals scored, positions, and match outcome.
 */
@Entity
@Table(name = "club_games")
public class ClubGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "game_id", nullable = false)
    @JsonProperty("game_id")
    private Long gameId;

    @Column(name = "club_id", nullable = false)
    @JsonProperty("club_id")
    private Long clubId;

    @Column(name = "own_goal", nullable = false)
    @JsonProperty("own_goals")
    private Integer ownGoal;

    @Column(name = "own_position", nullable = false)
    @JsonProperty("own_position")
    private Integer ownPosition;

    @Column(name = "own_manager_name")
    @JsonProperty("own_manager_name")
    private String ownManagerName;

    @Column(name = "hosting", nullable = false)
    @JsonProperty("hosting")
    private boolean hosting;

    @Column(name = "is_win", nullable = false)
    @JsonProperty("is_win")
    private boolean isWin;

    @Column(name = "club_formation")
    @JsonProperty("club_formation")
    private String clubFormation;

    /**
     * Constructs a new CLubGame object with the specified parameters.
     *
     * @param gameId         The ID of the game
     * @param clubId         The ID of the club involved in the game
     * @param ownGoal        The number of own goals scored by the club
     * @param ownPosition    The position of the club in the tournament
     * @param ownManagerName The name of the club's manager
     * @param hosting        Indicates whether the club was the host of the game
     * @param isWin          Indicates whether the club won the game
     * @param clubFormation  The formation used by the club in the game
     */
    public ClubGame(Long gameId, Long clubId, Integer ownGoal, Integer ownPosition, String ownManagerName, boolean hosting, boolean isWin, String clubFormation) {
        this.gameId = gameId;
        this.clubId = clubId;
        this.ownGoal = ownGoal;
        this.ownPosition = ownPosition;
        this.ownManagerName = ownManagerName;
        this.hosting = hosting;
        this.isWin = isWin;
        this.clubFormation = clubFormation;
    }

    /**
     * Empty constructor of ClubGame.
     */
    public ClubGame() {

    }

    //Getters and setters for the class fields

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Integer getOwnGoal() {
        return ownGoal;
    }

    public void setOwnGoal(Integer ownGoal) {
        this.ownGoal = ownGoal;
    }

    public Integer getOwnPosition() {
        return ownPosition;
    }

    public void setOwnPosition(Integer ownPosition) {
        this.ownPosition = ownPosition;
    }

    public String getOwnManagerName() {
        return ownManagerName;
    }

    public void setOwnManagerName(String ownManagerName) {
        this.ownManagerName = ownManagerName;
    }

    public boolean isHosting() {
        return hosting;
    }

    public void setHosting(boolean hosting) {
        this.hosting = hosting;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public String getClubFormation() {
        return clubFormation;
    }

    public void setClubFormation(String clubFormation) {
        this.clubFormation = clubFormation;
    }
}