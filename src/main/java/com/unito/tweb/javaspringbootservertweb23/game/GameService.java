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

    public Optional<List<VisualizeGame>> getGamesByClubName(String clubName) {
        List<Map<String, Object>> mapList = gameRepository.getGamesByClubName(clubName);
        return getVisualizeGames(mapList);
    }

    public Optional<List<VisualizeGame>> getGamesByClubNames(String clubName1, String clubName2) {
        List<Map<String, Object>> mapList = gameRepository.getGamesByClubNames(clubName1, clubName2);
        return getVisualizeGames(mapList);
    }

    public Optional<List<VisualizeGame>> getLastGames() {
        List<Map<String, Object>> mapList = gameRepository.getLastGames();
        return getVisualizeGames(mapList);
    }

    public Optional<List<VisualizeGame>> getGamesByGameDate(Date gameDate) {
        List<Map<String, Object>> mapList = gameRepository.getGamesByGameDate(gameDate);
        return getVisualizeGames(mapList);
    }

    public Optional<List<VisualizeGame>> getGamesByCompetitionIdAndSeasonNot(String competitionId, Integer season) {
        List<Map<String, Object>> mapList = gameRepository.getGamesByCompetitionIdAndSeasonNot(competitionId, season);
        return getVisualizeGames(mapList);
    }

    public Optional<List<VisualizeGame>> getGamesByCompetitionIdAndSeason(String competitionId, Integer season) {
        List<Map<String, Object>> mapList = gameRepository.getGamesByCompetitionIdAndSeason(competitionId, season);
        return getVisualizeGames(mapList);
    }

    private Optional<List<VisualizeGame>> getVisualizeGames(List<Map<String, Object>> mapList) {
        if (mapList.isEmpty())
            return Optional.empty();

        List<VisualizeGame> visualizeGameList = mapList.stream()
                .map(game -> new VisualizeGame(
                        (Long) game.get("game_id"),
                        (Timestamp) game.get("game_date"),
                        (String) game.get("competition_id"),
                        (String) game.get("club1"),
                        (Integer) game.get("goal1"),
                        (String) game.get("club2"),
                        (Integer) game.get("goal2")
                )).toList();

        return Optional.of(visualizeGameList);
    }
}
