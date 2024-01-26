package com.unito.tweb.javaspringbootservertweb23.game;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    public List<Game> saveGames(List<Game> games) {
        return gameRepository.saveAll(games);
    }

    public Optional<Game> getGameById(Long id){
        return gameRepository.findByGameId(id);
    }
}
