package com.unito.tweb.javaspringbootservertweb23.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

/**
 * Represents a player entity in the system.
 */
@Entity
@Table(name = "players")
public class Player {
    /**
     * The ID of the player
     */
    @Id
    @Column(name = "player_id", nullable = false)
    @JsonProperty("player_id")
    private Long playerId;

    /**
     * The last name of the player
     */
    @Column(name = "last_name", nullable = false)
    @JsonProperty("last_name")
    private String lastName;

    /**
     * The name of the player
     */
    @Column(name = "player_name", nullable = false)
    @JsonProperty("player_name")
    private String playerName;

    /**
     * The last season the player participated in
     */
    @Column(name = "last_season", nullable = false)
    @JsonProperty("last_season")
    private Integer lastSeason;

    /**
     * The ID of the current club the player belongs to
     */
    @Column(name = "current_club_id", nullable = false)
    @JsonProperty("current_club_id")
    private Long currentClubId;

    /**
     * The country of birth of the player
     */
    @Column(name = "country_of_birth")
    @JsonProperty("country_of_birth")
    private String countryOfBirth;

    /**
     * The city of birth of the player
     */
    @Column(name = "city_of_birth")
    @JsonProperty("city_of_birth")
    private String cityOfBirth;

    /**
     * The country of citizenship of the player
     */
    @Column(name = "country_of_citizenship")
    @JsonProperty("country_of_citizenship")
    private String countryOfCitizenship;

    /**
     * The date of birth of the player
     */
    @Column(name = "date_of_birth")
    @JsonProperty("date_of_birth")
    private Date dateOfBirth;

    /**
     * The dominant foot of the player
     */
    @Column(name = "foot")
    @JsonProperty("foot")
    private String foot;

    /**
     * The height of the player in centimeters
     */
    @Column(name = "height_in_cm")
    @JsonProperty("height_in_cm")
    private Short heightInCm;

    /**
     * The sub-position of the player
     */
    @Column(name = "sub_position")
    @JsonProperty("sub_position")
    private String subPosition;

    /**
     * The main position of the player
     */
    @Column(name = "position")
    @JsonProperty("position")
    private String position;

    /**
     * The value of the player in euros
     */
    @Column(name = "value_eur")
    @JsonProperty("value_eur")
    private Integer valueEur;

    /**
     * The top value of the player in euros
     */
    @Column(name = "top_value_eur")
    @JsonProperty("top_value_eur")
    private Integer topValueEur;

    /**
     * The expiration date of the player's contract
     */
    @Column(name = "contract_expiration_date")
    @JsonProperty("contract_expiration_date")
    private Date contractExpirationDate;

    /**
     * The name of the player's agent
     */
    @Column(name = "agent_name")
    @JsonProperty("agent_name")
    private String agentName;

    /**
     * The URL of the player's image
     */
    @Column(name = "image_url", nullable = false)
    @JsonProperty("image_url")
    private String imageUrl;

    /**
     * Constructs a player with the given attributes.
     *
     * @param playerId               The ID of the player
     * @param lastName               The last name of the player
     * @param playerName             The name of the player
     * @param lastSeason             The last season the player participated in
     * @param currentClubId          The ID of the current club the player belongs to
     * @param countryOfBirth         The country of birth of the player
     * @param cityOfBirth            The city of birth of the player
     * @param countryOfCitizenship   The country of citizenship of the player
     * @param dateOfBirth            The date of birth of the player
     * @param foot                   The dominant foot of the player
     * @param heightInCm             The height of the player in centimeters
     * @param subPosition            The sub-position of the player
     * @param position               The main position of the player
     * @param valueEur               The value of the player in euros
     * @param topValueEur            The top value of the player in euros
     * @param contractExpirationDate The expiration date of the player's contract
     * @param agentName              The name of the player's agent
     * @param imageUrl               The URL of the player's image
     */
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

    /**
     * Default constructor for the player.
     */
    public Player() {

    }

    // Getters and setters omitted for brevity

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
