package com.unito.tweb.javaspringbootservertweb23.dto;

/**
 * Record representing a club filtered by nation.
 *
 * @param clubId             The ID of the club
 * @param clubName           The name of the club
 * @param domesticLeagueCode The code that tells the nation of the club
 */
public record ClubByNation(
        Long clubId,
        String clubName,
        String domesticLeagueCode
) {
}
