package com.unito.tweb.javaspringbootservertweb23.player;

import com.unito.tweb.javaspringbootservertweb23.dto.PlayerCard;
import com.unito.tweb.javaspringbootservertweb23.dto.PlayerName;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Service class for managing Player entities.
 */
@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    /**
     * Constructs a new PlayerService with the provided PlayerRepository.
     *
     * @param playerRepository The repository used for accessing Player data
     */
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /**
     * Saves a player entity in the database.
     *
     * @param player The player entity to save
     * @return The saved {@link Player} entity
     */
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    /**
     * Saves a list of player entities in the database.
     *
     * @param players The list of player entities to save
     * @return The {@link List} of saved {@link Player} entities
     */
    public List<Player> savePlayers(List<Player> players) {
        return playerRepository.saveAll(players);
    }

    /**
     * Retrieves a list of players whose name contains the specified string, ordered by last name.
     *
     * @param name The string to search for in player names
     * @return A {@link List} of {@link PlayerCard} containing player ID, name, and image URL
     */
    public Optional<List<PlayerCard>> getPlayersByPlayerNameIsContainingOrderByLastName(String name) {
        List<Player> players = playerRepository.findPlayersByPlayerNameIgnoreCaseContainingOrderByLastName(name);

        if (players.isEmpty())
            return Optional.empty();

        List<PlayerCard> playerCardList = players.stream()
                .map(player -> new PlayerCard(
                        player.getPlayerId(),
                        player.getPlayerName(),
                        player.getLastName(),
                        player.getImageUrl()
                ))
                .toList();

        return Optional.of(playerCardList);
    }

    /**
     * Retrieves a list of players by their country of citizenship, ordered by last name.
     *
     * @param country The country of citizenship to filter players by
     * @return A {@link List} of {@link PlayerCard} by citizenship containing player ID, last name, name, and image URL
     */
    public Optional<List<PlayerCard>> getPlayersByCountryOfCitizenshipOrderByLastName(String country) {
        List<Player> players = playerRepository.getPlayersByCountryOfCitizenshipOrderByLastName(country);

        if (players.isEmpty())
            return Optional.empty();

        List<PlayerCard> playerInformationList = players.stream()
                .map(player -> new PlayerCard(
                        player.getPlayerId(),
                        player.getPlayerName(),
                        player.getLastName(),
                        player.getImageUrl()
                ))
                .toList();

        return Optional.of(playerInformationList);
    }

    /**
     * Retrieves a list of players by their IDs.
     *
     * @param ids The list of player IDs to retrieve
     * @return An {@link Optional} containing {@link List} of {@link PlayerName} if found, or an empty {@link Optional} otherwise
     */
    public Optional<List<PlayerName>> getPlayersNamesByIds(List<Long> ids) {
        List<Player> players = playerRepository.findAllById(ids);

        if (players.isEmpty())
            return Optional.empty();

        List<PlayerName> playerNameList = players.stream()
                .map(player -> new PlayerName(
                        player.getPlayerId(),
                        player.getPlayerName()
                ))
                .toList();

        return Optional.of(playerNameList);
    }

    /**
     * Retrieves a player by their ID.
     *
     * @param id The ID of the player to retrieve
     * @return An {@link Optional} containing the {@link Player} entity if found, or an empty {@link Optional} otherwise
     */
    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    /**
     * Retrieves a list of players by their IDs.
     *
     * @param ids The list of player IDs to retrieve
     * @return An {@link Optional} containing {@link List} of {@link PlayerCard} if found, or an empty {@link Optional} otherwise
     */
    public Optional<List<PlayerCard>> getPlayersByIds(List<Long> ids) {
        List<Player> players = playerRepository.findAllById(ids);

        if (players.isEmpty())
            return Optional.empty();

        List<PlayerCard> playerNameList = players.stream()
                .map(player -> new PlayerCard(
                        player.getPlayerId(),
                        player.getPlayerName(),
                        player.getLastName(),
                        player.getImageUrl()
                ))
                .toList();

        return Optional.of(playerNameList);
    }
}
