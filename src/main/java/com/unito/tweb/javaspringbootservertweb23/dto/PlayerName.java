package com.unito.tweb.javaspringbootservertweb23.dto;

/**
 * Record representing player information containing only the player's ID and name.
 *
 * @param playerId   The ID of the player
 * @param playerName The name of the player
 */
public record PlayerName(
        Long playerId,
        String playerName
) {
}
