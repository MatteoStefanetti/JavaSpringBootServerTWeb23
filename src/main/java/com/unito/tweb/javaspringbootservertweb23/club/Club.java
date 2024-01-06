package com.unito.tweb.javaspringbootservertweb23.club;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clubs")
public class Club {

    @Id
    private Long clubId;

    @Column(name = "club_name")
    private String clubName;

    @Column(name = "squad_size")
    private Integer squadSize;

    @Column(name = "average_age")
    private Float averageAge;

    @Column(name = "foreigners_number")
    private Integer foreignersNumber;

    @Column(name = "foreigners_percentage")
    private Float foreignersPercentage;

    @Column(name = "national_team_players")
    private Integer nationalTeamPlayer;

    @Column(name = "stadium_name")
    private String stadiumName;

    @Column(name = "stadium_seats")
    private Integer stadiumSeats;

    @Column(name = "net_transfer_record")
    private String netTransferRecord;

    @Column(name = "last_season")
    private Integer lastSeason;

    @Column(name = "club_url")
    private String clubUrl;

    @Column(name = "local_competition_code")
    private String localCompetitionCode;

    public Club(Long clubId, String clubName, Integer squadSize, Float averageAge, Integer foreignersNumber, Float foreignersPercentage, Integer nationalTeamPlayer, String stadiumName, Integer stadiumSeats, String netTransferRecord, Integer lastSeason, String clubUrl, String localCompetitionCode) {
        this.clubId = clubId;
        this.clubName = clubName;
        this.squadSize = squadSize;
        this.averageAge = averageAge;
        this.foreignersNumber = foreignersNumber;
        this.foreignersPercentage = foreignersPercentage;
        this.nationalTeamPlayer = nationalTeamPlayer;
        this.stadiumName = stadiumName;
        this.stadiumSeats = stadiumSeats;
        this.netTransferRecord = netTransferRecord;
        this.lastSeason = lastSeason;
        this.clubUrl = clubUrl;
        this.localCompetitionCode = localCompetitionCode;
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

    public String getNetTransferRecord() {
        return netTransferRecord;
    }

    public void setNetTransferRecord(String netTransferRecord) {
        this.netTransferRecord = netTransferRecord;
    }

    public Integer getLastSeason() {
        return lastSeason;
    }

    public void setLastSeason(Integer lastSeason) {
        this.lastSeason = lastSeason;
    }

    public String getClubUrl() {
        return clubUrl;
    }

    public void setClubUrl(String clubUrl) {
        this.clubUrl = clubUrl;
    }

    public String getLocalCompetitionCode() {
        return localCompetitionCode;
    }

    public void setLocalCompetitionCode(String localCompetitionCode) {
        this.localCompetitionCode = localCompetitionCode;
    }
}
