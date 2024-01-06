package com.unito.tweb.javaspringbootservertweb23.club;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository  extends JpaRepository<Club, Long> {
}
