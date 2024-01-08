package com.unito.tweb.javaspringbootservertweb23.game_event;

import com.unito.tweb.javaspringbootservertweb23.game.Game;
import com.unito.tweb.javaspringbootservertweb23.player.Player;
import jakarta.persistence.*;

@Entity
@Table(name = "game_events")
public class GameEvent {
    @Id
    @Column(name = "game_event_id", nullable = false)
    private String gameEventId;

    @Column(name = "minute", nullable = false)
    private Integer minute;

    @Column(name = "event_type", nullable = false)
    private String eventType;

    @Column(name = "club_id", nullable = false)
    private Long clubId;

    @Column(name = "event_description")
    private String eventDescription;

    @Column(name = "player_in_id")
    private Long playerInId;

    @Column(name = "player_assist_id")
    private Long playerAssistId;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game gameId;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player playerId;

    public GameEvent(String gameEventId, Integer minute, String eventType, Long clubId, String eventDescription, Long playerInId, Long playerAssistId, Game gameId, Player playerId) {
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

    public Game getGameId() {
        return gameId;
    }

    public void setGameId(Game gameId) {
        this.gameId = gameId;
    }

    public Player getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Player playerId) {
        this.playerId = playerId;
    }
}
