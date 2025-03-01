package com.unito.tweb.javaspringbootservertweb23.club_game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing and managing ClubGame entities in the database.
 */
@Repository
public interface ClubGameRepository extends JpaRepository<ClubGame, Long> {
}
