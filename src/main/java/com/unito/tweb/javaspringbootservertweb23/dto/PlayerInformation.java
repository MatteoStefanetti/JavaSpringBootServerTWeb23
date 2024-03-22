package com.unito.tweb.javaspringbootservertweb23.dto;

/**
 * Record representing player information.
 */
public record PlayerInformation(
        Long playerId,
        String lastName,
        String playerName,
        String imgUrl
) {
}
