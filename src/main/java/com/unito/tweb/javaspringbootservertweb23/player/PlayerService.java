package com.unito.tweb.javaspringbootservertweb23.player;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Player> getPlayerByPlayerName(String name) {
        return playerRepository.getPlayerByPlayerName(name);
    }

    public List<Player> getPlayerByCountryOfCitizenship(String country){
        return playerRepository.getPlayerByCountryOfCitizenship(country);
    }

    public List<Player> getPlayersByIds(List<Long> ids){
        return playerRepository.findAllById(ids);
    }

    public Optional<Player> getPlayerById(Long id){
        return playerRepository.findById(id);
    }
}
