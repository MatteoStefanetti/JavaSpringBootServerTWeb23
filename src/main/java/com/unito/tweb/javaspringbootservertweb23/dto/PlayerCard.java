package com.unito.tweb.javaspringbootservertweb23.dto;

/**
 * Record representing player information for display on a player card.
 */
public record PlayerCard(
        Long playerId,
        String playerName,
        String imageUrl
) {
}
