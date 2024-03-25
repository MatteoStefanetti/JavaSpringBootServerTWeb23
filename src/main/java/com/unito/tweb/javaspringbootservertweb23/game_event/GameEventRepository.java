package com.unito.tweb.javaspringbootservertweb23.game_event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Repository interface for managing game events.
 */
@Repository
public interface GameEventRepository extends JpaRepository<GameEvent, String> {
    /**
     * Retrieves an optional GameEvent object by its game ID.
     *
     * @param gameId The ID of the game
     * @return An optional GameEvent object corresponding to the given gameID, or an empty optional if not found
     */
    Optional<GameEvent> findByGameId(Long gameId);
}
