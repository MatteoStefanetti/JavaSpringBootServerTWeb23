package com.unito.tweb.javaspringbootservertweb23.player;

import com.unito.tweb.javaspringbootservertweb23.dto.PlayerByCitizenship;
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
     * @return The saved player entity
     */
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    /**
     * Saves a list of player entities in the database.
     *
     * @param players The list of player entities to save
     * @return The list of saved player entities
     */
    public List<Player> savePlayers(List<Player> players) {
        return playerRepository.saveAll(players);
    }

    /**
     * Retrieves a list of players whose name contains the specified string, ordered by last name.
     *
     * @param name The string to search for in player names
     * @return A list of player cards containing player ID, name, and image URL
     */
    public Optional<List<PlayerCard>> getPlayersByPlayerNameIsContainingOrderByLastName(String name) {
        List<Player> players = playerRepository.getPlayersByPlayerNameIsContainingOrderByLastName(name);

        if (players.isEmpty())
            return Optional.empty();

        List<PlayerCard> playerCardList = players.stream()
                .map(player -> new PlayerCard(
                        player.getPlayerId(),
                        player.getPlayerName(),
                        player.getImageUrl()
                ))
                .toList();

        return Optional.of(playerCardList);
    }

    /**
     * Retrieves a list of players by their country of citizenship, ordered by last name.
     *
     * @param country The country of citizenship to filter players by
     * @return A list of players by citizenship containing player ID, last name, name, and image URL
     */
    public Optional<List<PlayerByCitizenship>> getPlayersByCountryOfCitizenshipOrderByLastName(String country) {
        List<Player> players = playerRepository.getPlayersByCountryOfCitizenshipOrderByLastName(country);

        if (players.isEmpty())
            return Optional.empty();

        List<PlayerByCitizenship> playerByCitizenshipList = players.stream()
                .map(player -> new PlayerByCitizenship(
                        player.getPlayerId(),
                        player.getLastName(),
                        player.getPlayerName(),
                        player.getImageUrl()
                ))
                .toList();

        return Optional.of(playerByCitizenshipList);
    }

    /**
     * Retrieves a list of players by their IDs.
     *
     * @param ids The list of player IDs to retrieve
     * @return A list of player names containing player ID and name
     */
    public Optional<List<PlayerName>> getPlayersByIds(List<Long> ids) {
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
     * @return An Optional containing the player entity if found, or an empty Optional otherwise
     */
    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }
}
