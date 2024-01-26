package com.unito.tweb.javaspringbootservertweb23.game_event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface GameEventRepository extends JpaRepository<GameEvent, String> {
    Optional<GameEvent> findByGameId(Long gameId);
}
