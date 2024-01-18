package com.unito.tweb.javaspringbootservertweb23.game_event;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "game_events")
public class GameEvent {
    @Id
    @Column(name = "game_event_id", nullable = false)
    @JsonProperty("game_event_id")
    private String gameEventId;

    @Column(name = "minute", nullable = false)
    @JsonProperty("minute")
    private Integer minute;

    @Column(name = "event_type", nullable = false)
    @JsonProperty("event_type")
    private String eventType;

    @Column(name = "club_id", nullable = false)
    @JsonProperty("club_id")
    private Long clubId;

    @Column(name = "event_description")
    @JsonProperty("event_description")
    private String eventDescription;

    @Column(name = "player_in_id")
    @JsonProperty("player_in_id")
    private Long playerInId;

    @Column(name = "player_assist_id")
    @JsonProperty("player_assist_id")
    private Long playerAssistId;

    @Column(name = "game_id", nullable = false)
    @JsonProperty("game_id")
    private Long gameId;

    @Column(name = "player_id", nullable = false)
    @JsonProperty("player_id")
    private Long playerId;

    public GameEvent(String gameEventId, Integer minute, String eventType, Long clubId, String eventDescription, Long playerInId, Long playerAssistId, Long gameId, Long playerId) {
        this.gameEventId = gameEventId;
        this.minute = minute;
        this.eventType = eventType;
        this.clubId = clubId;
        this.eventDescription = eventDescription;
        this.playerInId = playerInId;
        this.playerAssistId = playerAssistId;
        this.gameId = gameId;
        this.playerId = playerId;
    }

    public GameEvent() {

    }

    public String getGameEventId() {
        return gameEventId;
    }

    public void setGameEventId(String gameEventId) {
        this.gameEventId = gameEventId;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Long getPlayerInId() {
        return playerInId;
    }

    public void setPlayerInId(Long playerInId) {
        this.playerInId = playerInId;
    }

    public Long getPlayerAssistId() {
        return playerAssistId;
    }

    public void setPlayerAssistId(Long playerAssistId) {
        this.playerAssistId = playerAssistId;
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
