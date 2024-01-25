package com.unito.tweb.javaspringbootservertweb23.club;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    List<Club> getClubsByLocalCompetitionCode(String localCompetitionCode);
    List<Club> findClubsByClubNameContaining(String name);
    Club findClubByClubName(String name);
    @Query(value = "select c.club_id from clubs c where c.club_name like :letter%", nativeQuery = true)
    List<Long> findClubsByLetter(String letter);
}


