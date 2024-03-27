package com.unito.tweb.javaspringbootservertweb23.game_event;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Service class for managing game events.
 */
@Service
public class GameEventService {
    private final GameEventRepository gameEventRepository;

    /**
     * Constructs a new {@code GameEventService} with the specified {@link GameEventRepository}.
     *
     * @param gameEventRepository The repository for game events
     */
    public GameEventService(GameEventRepository gameEventRepository) {
        this.gameEventRepository = gameEventRepository;
    }

    /**
     * Saves a single game event.
     *
     * @param gameEvent The game event to save
     * @return The saved game event
     */
    public GameEvent saveGameEvent(GameEvent gameEvent) {
        return gameEventRepository.save(gameEvent);
    }

    /**
     * Saves multiple game events.
     *
     * @param gameEvents The list of game events to save
     * @return The list of saved game events
     */
    public List<GameEvent> saveGameEvents(List<GameEvent> gameEvents) {
        return gameEventRepository.saveAll(gameEvents);
    }

    /**
     * Retrieves a game event by its associated game ID.
     *
     * @param id The ID of the game
     * @return An optional {@link List<GameEvent>} object corresponding to the given game ID, or an empty optional if not found
     */
    public Optional<List<GameEvent>> getGameEventsByGameId(Long id) {
        return gameEventRepository.findByGameId(id);
    }
}
