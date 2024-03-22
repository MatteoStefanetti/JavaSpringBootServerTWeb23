package com.unito.tweb.javaspringbootservertweb23.dto;

/**
 * Record representing a club filtered by nation.
 */
public record ClubByNation(
        Long clubId,
        String clubName,
        String domesticLeagueCode
) {
}
