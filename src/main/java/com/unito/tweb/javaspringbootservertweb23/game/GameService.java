package com.unito.tweb.javaspringbootservertweb23.game;

import com.unito.tweb.javaspringbootservertweb23.dto.*;


import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

/**
 * Service class for handling Game entities.
 */
@Service
public class GameService {
    private final GameRepository gameRepository;

    /**
     * Constructor for GameService.
     *
     * @param gameRepository Repository for Game entities
     */
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    /**
     * Saves a single game entity.
     *
     * @param game The game to be saved
     * @return The saved game entity
     */
    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    /**
     * Saves a list of game entities.
     *
     * @param games The list of games to be saved
     * @return The list of saved game entities
     */
    public List<Game> saveGames(List<Game> games) {
        return gameRepository.saveAll(games);
    }

    /**
     * Retrieves a game by its ID.
     *
     * @param id The ID of the game to retrieve
     * @return An optional containing the retrieved entity, if found
     */
    public Optional<Game> getGameById(Long id) {
        return gameRepository.findByGameId(id);
    }

    /**
     * Retrieves a game's data by its ID.
     *
     * @param id The ID of the game to retrieve
     * @return An Optional containing the VisualizeGame object with the specified game ID, if found
     */
    public Optional<VisualizeGame> getVisualizeGameById(Long id) {
        Map<String, Object> map = gameRepository.getGameById(id);

        if (map.isEmpty()) {
            return Optional.empty();
        }

        VisualizeGame visualizeGame = new VisualizeGame(
                (Long) map.get("game_id"),
                (Timestamp) map.get("game_date"),
                (String) map.get("competition_id"),
                (String) map.get("clubName1"),
                (Long) map.get("clubId1"),
                (Integer) map.get("goal1"),
                (String) map.get("clubName2"),
                (Long) map.get("clubId2"),
                (Integer) map.get("goal2")
        );

        return Optional.of(visualizeGame);
    }

    /**
     * Retrieves games by the name of a club.
     *
     * @param clubName The name of the club
     * @return An optional containing a list of VisualizeGame objects representing the games involving the club, if found
     */
    public Optional<List<VisualizeGame>> getGamesByClubName(String clubName) {
        List<Map<String, Object>> mapList = gameRepository.getGamesByClubName(clubName);
        return getVisualizeGames(mapList);
    }

    /**
     * Retrieves games involving two clubs.
     *
     * @param clubName1 The name of the first club
     * @param clubName2 The name of the second club
     * @return An optional containing a list of VisualizeGame objects representing the games involving both clubs, if found
     */
    public Optional<List<VisualizeGame>> getGamesByClubNames(String clubName1, String clubName2) {
        List<Map<String, Object>> mapList = gameRepository.getGamesByClubNames(clubName1, clubName2);
        return getVisualizeGames(mapList);
    }

    /**
     * Retrieves the last games played.
     *
     * @return An optional containing a list of VisualizeGame objects representing the last games played, if found
     */
    public Optional<List<VisualizeGame>> getLastGames() {
        List<Map<String, Object>> mapList = gameRepository.getLastGames();
        return getVisualizeGames(mapList);
    }

    /**
     * Retrieves games by a specific game date.
     *
     * @param gameDate The date of the games
     * @return An optional containing a list of VisualizeGame objects representing the games played on the specified date, if found
     */
    public Optional<List<VisualizeGame>> getGamesByGameDate(Date gameDate) {
        List<Map<String, Object>> mapList = gameRepository.getGamesByGameDate(gameDate);
        return getVisualizeGames(mapList);
    }

    /**
     * Retrieves games by competition ID and season, excluding a specific season.
     *
     * @param competitionId The ID of the competition
     * @param season        The season of the games to exclude
     * @return An optional containing a list of VisualizeGame objects representing the games matching the criteria, if found
     */
    public Optional<List<VisualizeGame>> getGamesByCompetitionIdAndSeasonNot(String competitionId, Integer season) {
        List<Map<String, Object>> mapList = gameRepository.getGamesByCompetitionIdAndSeasonNot(competitionId, season);
        return getVisualizeGames(mapList);
    }

    /**
     * Retrieves games by competition ID and season.
     *
     * @param competitionId The ID of the competition
     * @param season        The season of the games to retrieve
     * @return An optional containing a list of VisualizeGame objects representing the games matching the criteria, if found
     */
    public Optional<List<VisualizeGame>> getGamesByCompetitionIdAndSeason(String competitionId, Integer season) {
        List<Map<String, Object>> mapList = gameRepository.getGamesByCompetitionIdAndSeason(competitionId, season);
        return getVisualizeGames(mapList);
    }

    /**
     * Retrieves an integer from the games representing the current season of the database.
     *
     * @param competitionId The ID of the competition
     * @return An optional containing an Integer, representing the current season, if found.
     */
    public Optional<Integer> getSeasonYearFromGames(String competitionId) {
        Map<String, Object> obj = gameRepository.getLastSeason(competitionId);
        return retrieveLastSeasonInteger(obj);
    }

    /**
     * Retrieves games by club ID and season.
     *
     * @param id     The ID of the club
     * @param season The year of the season
     * @return An {@link Optional} containing a list of {@link VisualizeGame} objects representing the games matching the criteria, if found
     */
    public Optional<List<VisualizeGame>> getGamesByClubId(Long id, Integer season) {
        List<Map<String, Object>> mapList = gameRepository.getGamesByGameIdAndSeason(id, season);
        return getVisualizeGames(mapList);
    }

    /**
     * Converts a list of maps representing game data into a list of VisualizeGame objects.
     *
     * @param mapList The list of maps containing game data. Must not be null.
     * @return An optional containing a list of VisualizeGame objects representing the games, if the input list is not empty; otherwise, an empty optional
     */
    private Optional<List<VisualizeGame>> getVisualizeGames(List<Map<String, Object>> mapList) {
        if (mapList.isEmpty())
            return Optional.empty();

        List<VisualizeGame> visualizeGameList = mapList.stream()
                .map(game -> new VisualizeGame(
                        (Long) game.get("game_id"),
                        (Timestamp) game.get("game_date"),
                        (String) game.get("competition_id"),
                        (String) game.get("clubName1"),
                        (Long) game.get("clubId1"),
                        (Integer) game.get("goal1"),
                        (String) game.get("clubName2"),
                        (Long) game.get("clubId2"),
                        (Integer) game.get("goal2")
                )).toList();

        return Optional.of(visualizeGameList);
    }

    /**
     * Converts a map representing the last season into an Integer.
     *
     * @param obj The map containing season. Must not be null.
     * @return An optional containing an Integer, if the input is not empty; otherwise, an empty optional
     */
    private Optional<Integer> retrieveLastSeasonInteger(Map<String, Object> obj) {
        if (obj.isEmpty())
            return Optional.empty();

        Integer result = (Integer) obj.get("season");
        return Optional.of(result);
    }

}
