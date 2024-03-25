package com.unito.tweb.javaspringbootservertweb23.game_event;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

/**
 * Represent a game event entity.
 */
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

    /**
     * Constructs a new GameEvent instance with the specified attributes.
     *
     * @param gameEventId      The unique identifier of the game event
     * @param minute           The minute of the game when the event occurred
     * @param eventType        The type of the event
     * @param clubId           The ID of the club associated with the event
     * @param eventDescription The description of the event
     * @param playerInId       The ID of the player who replaces the player represented by playerId
     * @param playerAssistId   The ID of the player who assisted the goal scored by the player represented in playerId
     * @param gameId           The ID of the game associated with the event
     * @param playerId         The ID of the player associated with the event
     */
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

    /**
     * Empty constructor of a new GameEvent instance.
     */
    public GameEvent() {

    }

    // Getters and setters for the class attributes.
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
