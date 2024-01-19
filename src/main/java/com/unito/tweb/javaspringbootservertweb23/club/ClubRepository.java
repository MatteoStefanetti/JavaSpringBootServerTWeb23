package com.unito.tweb.javaspringbootservertweb23.club;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    @Query(value = "select c.club_id from clubs c where c.local_competition_code = :localCompetitionCode", nativeQuery = true)
    List<Long> findClubsByLocalCompetitionCode(String localCompetitionCode);
}
