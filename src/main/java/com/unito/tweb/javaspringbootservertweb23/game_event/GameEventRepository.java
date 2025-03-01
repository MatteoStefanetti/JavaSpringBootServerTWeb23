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
     * @return An {@link Optional} {@link List} of {@link GameEvent} objects corresponding to the given gameID, or an empty {@link Optional} if not found
     */
    Optional<List<GameEvent>> findByGameIdOrderByMinute(Long gameId);
}
