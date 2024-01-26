package com.unito.tweb.javaspringbootservertweb23.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findByGameId(Long id);
}
