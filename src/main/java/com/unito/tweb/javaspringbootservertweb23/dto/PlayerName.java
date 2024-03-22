package com.unito.tweb.javaspringbootservertweb23.dto;

/**
 * Record representing player information containing only the player's ID and name.
 */
public record PlayerName(
        Long playerId,
        String playerName
) {
}
