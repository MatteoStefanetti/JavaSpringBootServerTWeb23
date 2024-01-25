package com.unito.tweb.javaspringbootservertweb23.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query(value = "select * from players p where p.player_name like %:name%", nativeQuery = true)
    List<Player> getPlayerByPlayerName(String name);

    @Query(value = "select * from players p where p.country_of_citizenship like :country order by p.last_name", nativeQuery = true)
    List<Player> getPlayerByCountryOfCitizenship(String country);

}

