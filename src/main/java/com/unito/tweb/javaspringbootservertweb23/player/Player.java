package com.unito.tweb.javaspringbootservertweb23.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @Column(name = "player_id", nullable = false)
    @JsonProperty("player_id")
    private Long playerId;

    @Column(name = "last_name", nullable = false)
    @JsonProperty("last_name")
    private String lastName;

    @Column(name = "player_name", nullable = false)
    @JsonProperty("player_name")
    private String playerName;

    @Column(name = "last_season", nullable = false)
    @JsonProperty("last_season")
    private Integer lastSeason;

    @Column(name = "current_club_id", nullable = false)
    @JsonProperty("current_club_id")
    private Long currentClubId;

    @Column(name = "country_of_birth")
    @JsonProperty("country_of_birth")
    private String countryOfBirth;

    @Column(name = "city_of_birth")
    @JsonProperty("city_of_birth")
    private String cityOfBirth;

    @Column(name = "country_of_citizenship")
    @JsonProperty("country_of_citizenship")
    private String countryOfCitizenship;

    @Column(name = "date_of_birth")
    @JsonProperty("date_of_birth")
    private Date dateOfBirth;

    @Column(name = "foot")
    @JsonProperty("foot")
    private String foot;

    @Column(name = "height_in_cm")
    @JsonProperty("height_in_cm")
    private Short heightInCm;

    @Column(name = "sub_position")
    @JsonProperty("sub_position")
    private String subPosition;

    @Column(name = "position")
    @JsonProperty("position")
    private String position;

    @Column(name = "value_eur")
    @JsonProperty("value_eur")
    private Integer valueEur;

    @Column(name = "top_value_eur")
    @JsonProperty("top_value_eur")
    private Integer topValueEur;

    @Column(name = "contract_expiration_date")
    @JsonProperty("contract_expiration_date")
    private Date contractExpirationDate;

    @Column(name = "agent_name")
    @JsonProperty("agent_name")
    private String agentName;

    @Column(name = "image_url", nullable = false)
    @JsonProperty("image_url")
    private String imageUrl;


    public Player(Long playerId, String lastName, String playerName, Integer lastSeason, Long currentClubId, String countryOfBirth, String cityOfBirth, String countryOfCitizenship, Date dateOfBirth, String foot, Short heightInCm, String subPosition, String position, Integer valueEur, Integer topValueEur, Date contractExpirationDate, String agentName, String imageUrl) {
        this.playerId = playerId;
        this.lastName = lastName;
        this.playerName = playerName;
        this.lastSeason = lastSeason;
        this.currentClubId = currentClubId;
        this.countryOfBirth = countryOfBirth;
        this.cityOfBirth = cityOfBirth;
        this.countryOfCitizenship = countryOfCitizenship;
        this.dateOfBirth = dateOfBirth;
        this.foot = foot;
        this.heightInCm = heightInCm;
        this.subPosition = subPosition;
        this.position = position;
        this.valueEur = valueEur;
        this.topValueEur = topValueEur;
        this.contractExpirationDate = contractExpirationDate;
        this.agentName = agentName;
        this.imageUrl = imageUrl;
    }

    public Player() {

    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getLastSeason() {
        return lastSeason;
    }

    public void setLastSeason(Integer lastSeason) {
        this.lastSeason = lastSeason;
    }

    public Long getCurrentClubId() {
        return currentClubId;
    }

    public void setCurrentClubId(Long currentClubId) {
        this.currentClubId = currentClubId;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public String getCountryOfCitizenship() {
        return countryOfCitizenship;
    }

    public void setCountryOfCitizenship(String countryOfCitizenship) {
        this.countryOfCitizenship = countryOfCitizenship;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public Short getHeightInCm() {
        return heightInCm;
    }

    public void setHeightInCm(Short heightInCm) {
        this.heightInCm = heightInCm;
    }

    public String getSubPosition() {
        return subPosition;
    }

    public void setSubPosition(String subPosition) {
        this.subPosition = subPosition;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getValueEur() {
        return valueEur;
    }

    public void setValueEur(Integer valueEur) {
        this.valueEur = valueEur;
    }

    public Integer getTopValueEur() {
        return topValueEur;
    }

    public void setTopValueEur(Integer topValueEur) {
        this.topValueEur = topValueEur;
    }

    public Date getContractExpirationDate() {
        return contractExpirationDate;
    }

    public void setContractExpirationDate(Date contractExpirationDate) {
        this.contractExpirationDate = contractExpirationDate;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
