package com.unito.tweb.javaspringbootservertweb23.club_game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubGameRepository extends JpaRepository<ClubGame, Long> {
}
