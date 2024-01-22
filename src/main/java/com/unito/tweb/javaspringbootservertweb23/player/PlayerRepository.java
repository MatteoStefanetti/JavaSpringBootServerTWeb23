package com.unito.tweb.javaspringbootservertweb23.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query(value = "select p.player_id from players p where p.player_name like :letter% or p.player_name like :capitalLetter%", nativeQuery = true)
    List<Long> getPlayerByLetterInPlayerName(String capitalLetter, String letter);
}
