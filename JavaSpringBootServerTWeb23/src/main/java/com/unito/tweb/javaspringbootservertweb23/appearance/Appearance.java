package com.unito.tweb.javaspringbootservertweb23.appearance;

import jakarta.persistence.*;

@Entity
@Table(name = "appearance")
public class Appearance {
    @Id
    private String appearanceId;

    @Column(name = "yellow_cards")
    private int yellowCards;

    @Column(name = "red_cards")
    private boolean redCards;

    @Column(name = "goals")
    private int goals;

    @Column(name = "assists")
    private int assists;

    @Column(name = "minutes_played")
    private int minutesPlayed;

    @Column(name = "player_club_id")
    private int playerClubId;

    @Column(name = "player_current_club_id")
    private int playerCurrentClubId;

    @Column(name = "game_id")
    private int gameId;

    @Column(name = "player_id")
    private int playerId;

    public Appearance(String appearanceId, int yellowCards, boolean redCards, int goals, int assists, int minutesPlayed, int playerClubId, int playerCurrentClubId, int gameId, int playerId) {
        this.appearanceId = appearanceId;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.goals = goals;
        this.assists = assists;
        this.minutesPlayed = minutesPlayed;
        this.playerClubId = playerClubId;
        this.playerCurrentClubId = playerCurrentClubId;
        this.gameId = gameId;
        this.playerId = playerId;
    }

    public Appearance() {

    }

    public String getAppearanceId() {
        return appearanceId;
    }

    public void setAppearanceId(String appearanceId) {
        this.appearanceId = appearanceId;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public boolean isRedCards() {
        return redCards;
    }

    public void setRedCards(boolean redCards) {
        this.redCards = redCards;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(int minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public int getPlayerClubId() {
        return playerClubId;
    }

    public void setPlayerClubId(int playerClubId) {
        this.playerClubId = playerClubId;
    }

    public int getPlayerCurrentClubId() {
        return playerCurrentClubId;
    }

    public void setPlayerCurrentClubId(int playerCurrentClubId) {
        this.playerCurrentClubId = playerCurrentClubId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}
