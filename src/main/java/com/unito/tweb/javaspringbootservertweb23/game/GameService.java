package com.unito.tweb.javaspringbootservertweb23.game;

import com.unito.tweb.javaspringbootservertweb23.dto.GamesByName;
import com.unito.tweb.javaspringbootservertweb23.dto.TopGameResults;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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

    public Optional<Game> getGameById(Long id) {
        return gameRepository.findByGameId(id);
    }

    public List<GamesByName> getGamesByClubName(String clubName) {
        List<Map<String, Object>> mapList = gameRepository.getGamesByClubName(clubName);
        List<GamesByName> gamesByNameList = new ArrayList<>();
        for (Map<String, Object> map : mapList){
            GamesByName gamesByName = new GamesByName(
                    (Long) map.get("game_id"),
                    (Timestamp) map.get("game_date"),
                    (String) map.get("competition_id"),
                    (String) map.get("club1"),
                    (Integer) map.get("goal1"),
                    (String) map.get("club2"),
                    (Integer) map.get("goal2")
            );
            gamesByNameList.add(gamesByName);
        }
        return gamesByNameList;
    }

    public List<Game> getGamesByClubNames(String clubName1, String clubName2){
        return gameRepository.getGamesByClubNames(clubName1, clubName2);
    }

    public List<TopGameResults> getLastGames() {
        List<Map<String, Object>> result = gameRepository.getLastGames();
        List<TopGameResults> res = new ArrayList<>();
        for (Map<String, Object> row : result) {
            TopGameResults topGameResults = new TopGameResults(
                    (Long) row.get("game_id"),
                    (Timestamp) row.get("game_date"),
                    (String) row.get("competition_id"),
                    (String) row.get("home_team"),
                    (Integer) row.get("home_team_goals"),
                    (String) row.get("away_team"),
                    (Integer) row.get("away_team_goals")
            );
            res.add(topGameResults);
        }
        return res;
    }
}
