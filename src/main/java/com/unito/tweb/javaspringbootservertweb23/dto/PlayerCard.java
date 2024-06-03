package com.unito.tweb.javaspringbootservertweb23.dto;

/**
 * Record representing player information for display on a player card.
 *
 * @param playerId       The ID of the player
 * @param playerName     The first name of the player
 * @param playerLastName The last name (surname) of the player
 * @param imageUrl       The url where you can retrieve a picture of the player
 */
public record PlayerCard(
        Long playerId,
        String playerName,
        String playerLastName,
        String imageUrl
) {
}
