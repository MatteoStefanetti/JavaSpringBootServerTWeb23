package com.unito.tweb.javaspringbootservertweb23.club_game;

import com.unito.tweb.javaspringbootservertweb23.club.Club;
import com.unito.tweb.javaspringbootservertweb23.game.Game;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ClubGameId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game gameId;

    @ManyToOne
    @JoinColumn(name = "club_id", nullable = false)
    private Club clubId;

    public ClubGameId(Game gameId, Club clubId) {
        this.gameId = gameId;
        this.clubId = clubId;
    }

    public ClubGameId() {

    }

    public Game getGameId() {
        return gameId;
    }

    public void setGameId(Game gameId) {
        this.gameId = gameId;
    }

    public Club getClubId() {
        return clubId;
    }

    public void setClubId(Club clubId) {
        this.clubId = clubId;
    }
}
