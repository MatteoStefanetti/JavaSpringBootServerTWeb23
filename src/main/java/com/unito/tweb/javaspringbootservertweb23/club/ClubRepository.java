package com.unito.tweb.javaspringbootservertweb23.club;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {

    @Query(value = "select distinct c.club_id, c.club_name, g.game_id, g.game_date " +
            "from games g " +
            "join club_games cg on g.game_id = cg.game_id " +
            "join clubs c on cg.club_id = c.club_id " +
            "order by g.game_date desc limit 15", nativeQuery = true)
    List<Map<String, Object>> getRecentClubsNews();
    List<Club> getClubsByLocalCompetitionCode(String localCompetitionCode);

    List<Club> findClubsByClubNameContaining(String name);

    Club findClubByClubName(String name);

    @Query(value = "select c.club_id from clubs c where c.club_name like :letter%", nativeQuery = true)
    List<Long> findClubsByLetter(String letter);

    Optional<Club> findByClubId(Long id);
}
