package com.unito.tweb.javaspringbootservertweb23.club_game;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


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

    public ClubGame( Long gameId, Long clubId, Integer ownGoal, Integer ownPosition, String ownManagerName, boolean hosting, boolean isWin, String clubFormation) {
        this.gameId = gameId;
        this.clubId = clubId;
        this.ownGoal = ownGoal;
        this.ownPosition = ownPosition;
        this.ownManagerName = ownManagerName;
        this.hosting = hosting;
        this.isWin = isWin;
        this.clubFormation = clubFormation;
    }

    public ClubGame() {

    }

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