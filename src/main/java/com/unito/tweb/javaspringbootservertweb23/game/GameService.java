package com.unito.tweb.javaspringbootservertweb23.game;

import com.unito.tweb.javaspringbootservertweb23.dto.*;

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

    public List<VisualizeGame> getGamesByClubName(String clubName) {
        List<Map<String, Object>> mapList = gameRepository.getGamesByClubName(clubName);
        return getVisualizeGameList(mapList);
    }

    public List<VisualizeGame> getGamesByClubNames(String clubName1, String clubName2) {
        List<Map<String, Object>> mapList = gameRepository.getGamesByClubNames(clubName1, clubName2);
        return getVisualizeGameList(mapList);
    }

    public List<VisualizeGame> getLastGames() {
        List<Map<String, Object>> mapList = gameRepository.getLastGames();
        return getVisualizeGameList(mapList);
    }

    public List<VisualizeGame> getGamesByGameDate(Date gameDate) {
        List<Map<String, Object>> mapList = gameRepository.getGamesByGameDate(gameDate);
        return getVisualizeGameList(mapList);
    }

    private List<VisualizeGame> getVisualizeGameList(List<Map<String, Object>> mapList) {
        List<VisualizeGame> visualizeGameList = new ArrayList<>();
        for (Map<String, Object> map : mapList) {
            VisualizeGame visualizeGame = new VisualizeGame(
                    (Long) map.get("game_id"),
                    (Timestamp) map.get("game_date"),
                    (String) map.get("competition_id"),
                    (String) map.get("club1"),
                    (Integer) map.get("goal1"),
                    (String) map.get("club2"),
                    (Integer) map.get("goal2")
            );
            visualizeGameList.add(visualizeGame);
        }
        return visualizeGameList;
    }

    public List<GamesByCompetitionAndSeason> getGamesByCompetitionIdAndSeason(String competitionId, Integer season){
        List<Map<String, Object>> mapList = gameRepository.getGamesByCompetitionIdAndSeason(competitionId, season);
        List<GamesByCompetitionAndSeason> gamesByCompetitionAndSeasonList = new ArrayList<>();
        for (Map<String, Object> map : mapList){
            GamesByCompetitionAndSeason gamesByCompetitionAndSeason = new GamesByCompetitionAndSeason(
                    (Long) map.get("game_id"),
                    (Timestamp) map.get("game_date"),
                    (String) map.get("club1"),
                    (Integer) map.get("goal1"),
                    (String) map.get("club2"),
                    (Integer) map.get("goal2")
            );
            gamesByCompetitionAndSeasonList.add(gamesByCompetitionAndSeason);
        }
        return gamesByCompetitionAndSeasonList;
    }
}
