package com.unito.tweb.javaspringbootservertweb23.player;

import com.unito.tweb.javaspringbootservertweb23.dto.PlayerByCitizenship;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> savePlayers(List<Player> players) {
        return playerRepository.saveAll(players);
    }

    public List<Long> getPlayersByPlayerNameIsContainingOrderByLastName(String name) {
        List<Player> players = playerRepository.getPlayersByPlayerNameIsContainingOrderByLastName(name);
        List<Long> playersIds = new ArrayList<>();
        for (Player player : players) {
            playersIds.add(player.getPlayerId());
        }
        return playersIds;
    }

    public List<PlayerByCitizenship> getPlayersByCountryOfCitizenshipOrderByLastName(String country) {
        List<Player> players = playerRepository.getPlayersByCountryOfCitizenshipOrderByLastName(country);
        List<PlayerByCitizenship> playerByCitizenshipList = new ArrayList<>();
        for (Player player : players){
            PlayerByCitizenship playerByCitizenship = new PlayerByCitizenship(
                    player.getPlayerId(),
                    player.getLastName(),
                    player.getPlayerName(),
                    player.getImageUrl()
            );
            playerByCitizenshipList.add(playerByCitizenship);
        }
        return playerByCitizenshipList;
    }

    public List<Player> getPlayersByIds(List<Long> ids) {
        return playerRepository.findAllById(ids);
    }

    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }
}
