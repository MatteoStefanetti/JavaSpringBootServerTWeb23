package com.unito.tweb.javaspringbootservertweb23.club_game;

import jakarta.persistence.*;


@Entity
@Table(name = "club_games")
public class ClubGame {
    @EmbeddedId
    private ClubGameId clubGameId;

    @Column(name = "own_goal", nullable = false)
    private Integer ownGoal;

    @Column(name = "own_position", nullable = false)
    private Integer ownPosition;

    @Column(name = "own_manager_name")
    private String ownManagerName;

    @Column(name = "hosting", nullable = false)
    private boolean hosting;

    @Column(name = "is_win", nullable = false)
    private boolean isWin;

    @Column(name = "club_formation")
    private String clubFormation;

    public ClubGame(ClubGameId clubGameId, Integer ownGoal, Integer ownPosition, String ownManagerName, boolean hosting, boolean isWin, String clubFormation) {
        this.clubGameId = clubGameId;
        this.ownGoal = ownGoal;
        this.ownPosition = ownPosition;
        this.ownManagerName = ownManagerName;
        this.hosting = hosting;
        this.isWin = isWin;
        this.clubFormation = clubFormation;
    }

    public ClubGame() {

    }

    public ClubGameId getClubGameId() {
        return clubGameId;
    }

    public void setClubGameId(ClubGameId clubGameId) {
        this.clubGameId = clubGameId;
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