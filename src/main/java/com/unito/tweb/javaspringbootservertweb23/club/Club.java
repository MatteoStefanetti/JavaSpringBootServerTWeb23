package com.unito.tweb.javaspringbootservertweb23.club;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clubs")
public class Club {

    @Id
    @Column(name = "club_id", nullable = false)
    @JsonProperty("club_id")
    private Long clubId;

    @Column(name = "club_name", nullable = false)
    @JsonProperty("club_name")
    private String clubName;

    @Column(name = "local_competition_code", nullable = false)
    @JsonProperty("local_competition_code")
    private String localCompetitionCode;

    @Column(name = "squad_size", nullable = false)
    @JsonProperty("squad_size")
    private Integer squadSize;

    @Column(name = "average_age")
    @JsonProperty("average_age")
    private Float averageAge;

    @Column(name = "foreigners_number", nullable = false)
    @JsonProperty("foreigners_number")
    private Integer foreignersNumber;

    @Column(name = "foreigners_percentage", nullable = false)
    @JsonProperty("foreigners_percentage")
    private Float foreignersPercentage;

    @Column(name = "national_team_players", nullable = false)
    @JsonProperty("national_team_players")
    private Integer nationalTeamPlayer;

    @Column(name = "stadium_name", nullable = false)
    @JsonProperty("stadium_name")
    private String stadiumName;

    @Column(name = "stadium_seats", nullable = false)
    @JsonProperty("stadium_seats")
    private Integer stadiumSeats;

    @Column(name = "net_transfer_record", nullable = false)
    @JsonProperty("net_transfer_record")
    private Long netTransferRecord;

    @Column(name = "last_season", nullable = false)
    @JsonProperty("last_season")
    private Integer lastSeason;


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

    public Club() {

    }

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
