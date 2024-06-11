package com.unito.tweb.javaspringbootservertweb23.dto;

/**
 * Record representing the placing of a club in a certain competition.
 *
 * @param clubId       The ID of the club
 * @param clubName     The name of the club
 * @param clubPosition The position of the club in a certain competition
 */
public record ClubPlacing(
        Long clubId,
        String clubName,
        Integer clubPosition) {
}
