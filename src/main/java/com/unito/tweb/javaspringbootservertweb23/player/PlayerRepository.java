package com.unito.tweb.javaspringbootservertweb23.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> getPlayersByCountryOfCitizenshipOrderByLastName(String country);
    List<Player> getPlayersByPlayerNameIsContainingOrderByLastName(String name);
}

