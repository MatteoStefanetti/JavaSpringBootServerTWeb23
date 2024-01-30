package com.unito.tweb.javaspringbootservertweb23.player;

import com.unito.tweb.javaspringbootservertweb23.dto.PlayerByCitizenship;
import com.unito.tweb.javaspringbootservertweb23.dto.PlayerCard;
import com.unito.tweb.javaspringbootservertweb23.dto.PlayerName;
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

    public List<PlayerCard> getPlayersByPlayerNameIsContainingOrderByLastName(String name) {
        List<Player> players = playerRepository.getPlayersByPlayerNameIsContainingOrderByLastName(name);
        List<PlayerCard> playersCardList = new ArrayList<>();
        for (Player player : players) {
            PlayerCard playerCard = new PlayerCard(
                    player.getPlayerId(),
                    player.getPlayerName(),
                    player.getImageUrl()
            );
            playersCardList.add(playerCard);
        }
        return playersCardList;
    }

    public List<PlayerByCitizenship> getPlayersByCountryOfCitizenshipOrderByLastName(String country) {
        List<Player> players = playerRepository.getPlayersByCountryOfCitizenshipOrderByLastName(country);
        List<PlayerByCitizenship> playerByCitizenshipList = new ArrayList<>();
        for (Player player : players) {
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

    public List<PlayerName> getPlayersByIds(List<Long> ids) {
        List<Player> players = playerRepository.findAllById(ids);
        List<PlayerName> playerNameList = new ArrayList<>();
        for (Player player : players) {
            PlayerName playerName = new PlayerName(
                    player.getPlayerId(),
                    player.getPlayerName()
            );
            playerNameList.add(playerName);
        }
        return playerNameList;
    }

    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }
}
