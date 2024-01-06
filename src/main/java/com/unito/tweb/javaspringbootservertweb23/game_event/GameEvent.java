package com.unito.tweb.javaspringbootservertweb23.game_event;

import com.unito.tweb.javaspringbootservertweb23.game.Game;
import com.unito.tweb.javaspringbootservertweb23.player.Player;
import jakarta.persistence.*;

@Entity
@Table(name = "game_events")
public class GameEvent {
    @Id
    @Column(name = "game_event_id")
    private String gameEventId;

    @Column(name = "minute")
    private Integer minute;

    @Column(name = "game_event_type")
    private String gameEventType;

    @Column(name = "club_id")
    private Long clubId;

    @Column(name = "game_event_description")
    private String gameEventDescription;

    @Column(name = "player_in_id")
    private Long playerInId;

    @Column(name = "player_assist_id")
    private Long playerAssistId;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game gameId;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player playerId;

    public GameEvent(String gameEventId, Integer minute, String gameEventType, Long clubId, String gameEventDescription, Long playerInId, Long playerAssistId, Game gameId, Player playerId) {
        this.gameEventId = gameEventId;
        this.minute = minute;
        this.gameEventType = gameEventType;
        this.clubId = clubId;
        this.gameEventDescription = gameEventDescription;
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

    public String getGameEventType() {
        return gameEventType;
    }

    public void setGameEventType(String gameEventType) {
        this.gameEventType = gameEventType;
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public String getGameEventDescription() {
        return gameEventDescription;
    }

    public void setGameEventDescription(String gameEventDescription) {
        this.gameEventDescription = gameEventDescription;
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
