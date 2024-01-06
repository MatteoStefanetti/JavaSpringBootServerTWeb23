package com.unito.tweb.javaspringbootservertweb23.game;

import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }
}
