package com.unito.tweb.javaspringbootservertweb23.club_game;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ClubGameId implements Serializable {
    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "club_id")
    private Long clubId;

    public ClubGameId(Long gameId, Long clubId) {
        this.gameId = gameId;
        this.clubId = clubId;
    }

    public ClubGameId() {

    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }
}
