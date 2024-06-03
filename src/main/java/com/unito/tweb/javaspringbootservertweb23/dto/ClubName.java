package com.unito.tweb.javaspringbootservertweb23.dto;

/**
 * Record representing the name of a club.
 *
 * @param clubId   The ID of the club
 * @param clubName The name of the club
 */
public record ClubName(
        Long clubId,
        String clubName
) {
}
