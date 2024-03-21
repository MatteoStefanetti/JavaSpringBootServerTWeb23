package com.unito.tweb.javaspringbootservertweb23.club;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

/**
 * Entity class representing a club in the application.
 */
@Entity
@Table(name = "clubs")
public class Club {
    /**
     * The ID of the club
     */
    @Id
    @Column(name = "club_id", nullable = false)
    @JsonProperty("club_id")
    private Long clubId;

    /**
     * The name of the club
     */
    @Column(name = "club_name", nullable = false)
    @JsonProperty("club_name")
    private String clubName;


    /**
     * The local competition code of the club.
     */
    @Column(name = "local_competition_code", nullable = false)
    @JsonProperty("local_competition_code")
    private String localCompetitionCode;

    /**
     * The squad size of the club.
     */
    @Column(name = "squad_size", nullable = false)
    @JsonProperty("squad_size")
    private Integer squadSize;

    /**
     * The average age of the club's players.
     */
    @Column(name = "average_age")
    @JsonProperty("average_age")
    private Float averageAge;

    /**
     * The number of foreign players in the club.
     */
    @Column(name = "foreigners_number", nullable = false)
    @JsonProperty("foreigners_number")
    private Integer foreignersNumber;

    /**
     * The percentage of foreign players in the club.
     */
    @Column(name = "foreigners_percentage", nullable = false)
    @JsonProperty("foreigners_percentage")
    private Float foreignersPercentage;

    /**
     * The number of players in the national team.
     */
    @Column(name = "national_team_players", nullable = false)
    @JsonProperty("national_team_players")
    private Integer nationalTeamPlayer;

    /**
     * The name of the club's stadium.
     */
    @Column(name = "stadium_name", nullable = false)
    @JsonProperty("stadium_name")
    private String stadiumName;

    /**
     * The number of seats in the club's stadium.
     */
    @Column(name = "stadium_seats", nullable = false)
    @JsonProperty("stadium_seats")
    private Integer stadiumSeats;

    /**
     * The net transfer record of the club.
     */
    @Column(name = "net_transfer_record", nullable = false)
    @JsonProperty("net_transfer_record")
    private Long netTransferRecord;

    /**
     * The last season of the club.
     */
    @Column(name = "last_season", nullable = false)
    @JsonProperty("last_season")
    private Integer lastSeason;

    /**
     * Constructor for creating a Club object.
     *
     * @param clubId               The ID of the club
     * @param clubName             The name of the club
     * @param localCompetitionCode The local competition code of the club
     * @param squadSize            The squad size of the club
     * @param averageAge           The average age of the club's players
     * @param foreignersNumber     The number of foreign players in the club
     * @param foreignersPercentage The percentage of foreign players in the club
     * @param nationalTeamPlayer   The number of players in the national team
     * @param stadiumName          The name of the club's stadium
     * @param stadiumSeats         The number of seats in the club's stadium
     * @param netTransferRecord    The net transfer record of the club
     * @param lastSeason           The last season of the club
     */
    public Club(Long clubId, String clubName, String localCompetitionCode, Integer squadSize, Float averageAge, Integer foreignersNumber, Float foreignersPercentage, Integer nationalTeamPlayer, String stadiumName, Integer stadiumSeats, Long netTransferRecord, Integer lastSeason) {
        this.clubId = clubId;
        this.clubName = clubName;
        this.localCompetitionCode = localCompetitionCode;
        this.squadSize = squadSize;
        this.averageAge = averageAge;
        this.foreignersNumber = foreignersNumber;
        this.foreignersPercentage = foreignersPercentage;
        this.nationalTeamPlayer = nationalTeamPlayer;
        this.stadiumName = stadiumName;
        this.stadiumSeats = stadiumSeats;
        this.netTransferRecord = netTransferRecord;
        this.lastSeason = lastSeason;
    }

    /**
     * Default constructor for Club.
     */
    public Club() {

    }

    // Getter and setter methods for the class attributes.

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public Integer getSquadSize() {
        return squadSize;
    }

    public void setSquadSize(Integer squadSize) {
        this.squadSize = squadSize;
    }

    public Float getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(Float averageAge) {
        this.averageAge = averageAge;
    }

    public Integer getForeignersNumber() {
        return foreignersNumber;
    }

    public void setForeignersNumber(Integer foreignersNumber) {
        this.foreignersNumber = foreignersNumber;
    }

    public Float getForeignersPercentage() {
        return foreignersPercentage;
    }

    public void setForeignersPercentage(Float foreignersPercentage) {
        this.foreignersPercentage = foreignersPercentage;
    }

    public Integer getNationalTeamPlayer() {
        return nationalTeamPlayer;
    }

    public void setNationalTeamPlayer(Integer nationalTeamPlayer) {
        this.nationalTeamPlayer = nationalTeamPlayer;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public Integer getStadiumSeats() {
        return stadiumSeats;
    }

    public void setStadiumSeats(Integer stadiumSeats) {
        this.stadiumSeats = stadiumSeats;
    }

    public Long getNetTransferRecord() {
        return netTransferRecord;
    }

    public void setNetTransferRecord(Long netTransferRecord) {
        this.netTransferRecord = netTransferRecord;
    }

    public Integer getLastSeason() {
        return lastSeason;
    }

    public void setLastSeason(Integer lastSeason) {
        this.lastSeason = lastSeason;
    }

    public String getLocalCompetitionCode() {
        return localCompetitionCode;
    }

    public void setLocalCompetitionCode(String localCompetitionCode) {
        this.localCompetitionCode = localCompetitionCode;
    }
}
