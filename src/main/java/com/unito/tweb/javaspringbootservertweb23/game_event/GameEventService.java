package com.unito.tweb.javaspringbootservertweb23.game_event;

import org.springframework.stereotype.Service;

@Service
public class GameEventService {
    private final GameEventRepository gameEventRepository;

    public GameEventService(GameEventRepository gameEventRepository) {
        this.gameEventRepository = gameEventRepository;
    }

    public GameEvent saveGameEvent(GameEvent gameEvent) {
        return gameEventRepository.save(gameEvent);
    }
}
