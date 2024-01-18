package com.unito.tweb.javaspringbootservertweb23.appearance;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unito.tweb.javaspringbootservertweb23.player.Player;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "appearance")
public class Appearance {
    @Id
    @Column(name = "appearance_id", nullable = false)
    @JsonProperty("appearance_id")
    private String appearanceId;

    @Column(name = "yellow_cards", nullable = false)
    @JsonProperty("yellow_cards")
    private int yellowCards;

    @Column(name = "red_cards", nullable = false)
    @JsonProperty("red_cards")
    private boolean redCards;

    @Column(name = "goals", nullable = false)
    @JsonProperty("goals")
    private int goals;

    @Column(name = "assists", nullable = false)
    @JsonProperty("assists")
    private int assists;

    @Column(name = "minutes_played", nullable = false)
    @JsonProperty("minutes_played")
    private int minutesPlayed;

    @Column(name = "player_club_id", nullable = false)
    @JsonProperty("player_club_id")
    private int playerClubId;

    @Column(name = "player_current_club_id", nullable = false)
    @JsonProperty("player_current_club_id")
    private int playerCurrentClubId;

    @Column(name = "game_id", nullable = false)
    @JsonProperty("game_id")
    private Long gameId;


    @Column(name = "player_id", nullable = false)
    @JsonProperty("player_id")
    private Long playerId;

    public Appearance(String appearanceId, int yellowCards, boolean redCards, int goals, int assists, int minutesPlayed, int playerClubId, int playerCurrentClubId, Long gameId, Long playerId) {
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

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }
}
