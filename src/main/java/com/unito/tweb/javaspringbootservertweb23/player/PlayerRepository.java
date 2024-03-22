package com.unito.tweb.javaspringbootservertweb23.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for accessing and managing Player entities in the database.
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    /**
     * Retrieves a list of players by their country of citizenship, ordered by last name.
     *
     * @param country The country of citizenship to filter players by
     * @return A list of players matching the specified country of citizenship, ordered by last name
     */
    List<Player> getPlayersByCountryOfCitizenshipOrderByLastName(String country);

    /**
     * Retrieves a list of players whose name contains the specified string, ordered by last name.
     *
     * @param name The string to search for in player names
     * @return A list of players whose names contain the specified string, ordered by last name
     */
    List<Player> getPlayersByPlayerNameIsContainingOrderByLastName(String name);
}