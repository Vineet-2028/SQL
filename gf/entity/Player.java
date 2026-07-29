package com.backend.backend.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @Column(name = "player_id")
    private Long playerId;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "player_image_url")
    private String playerImageUrl;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    private Integer age;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "country_of_birth")
    private String countryOfBirth;

    private Double height;

    private String citizenship;

    @Column(name = "is_eu")
    private Boolean isEu;

    private String position;

    @Column(name = "main_position")
    private String mainPosition;

    private String foot;

    @Column(name = "current_club_id")
    private Long currentClubId;

    @Column(name = "current_club_name")
    private String currentClubName;

    private LocalDate joined;

    public Player() {
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerImageUrl() {
        return playerImageUrl;
    }

    public void setPlayerImageUrl(String playerImageUrl) {
        this.playerImageUrl = playerImageUrl;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public Boolean getIsEu() {
        return isEu;
    }

    public void setIsEu(Boolean isEu) {
        this.isEu = isEu;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMainPosition() {
        return mainPosition;
    }

    public void setMainPosition(String mainPosition) {
        this.mainPosition = mainPosition;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public Long getCurrentClubId() {
        return currentClubId;
    }

    public void setCurrentClubId(Long currentClubId) {
        this.currentClubId = currentClubId;
    }

    public String getCurrentClubName() {
        return currentClubName;
    }

    public void setCurrentClubName(String currentClubName) {
        this.currentClubName = currentClubName;
    }

    public LocalDate getJoined() {
        return joined;
    }

    public void setJoined(LocalDate joined) {
        this.joined = joined;
    }

    // Backward-compatible bridge methods for older code/importers
    public Long getPlayer_id() {
        return getPlayerId();
    }

    public void setPlayer_id(Long player_id) {
        setPlayerId(player_id);
    }

    public String getPlayer_name() {
        return getPlayerName();
    }

    public void setPlayer_name(String player_name) {
        setPlayerName(player_name);
    }

    public String getPlayer_image_url() {
        return getPlayerImageUrl();
    }

    public void setPlayer_image_url(String player_image_url) {
        setPlayerImageUrl(player_image_url);
    }

    public LocalDate getDate_of_birth() {
        return getDateOfBirth();
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        setDateOfBirth(date_of_birth);
    }

    public String getPlace_of_birth() {
        return getPlaceOfBirth();
    }

    public void setPlace_of_birth(String place_of_birth) {
        setPlaceOfBirth(place_of_birth);
    }

    public String getCountry_of_birth() {
        return getCountryOfBirth();
    }

    public void setCountry_of_birth(String country_of_birth) {
        setCountryOfBirth(country_of_birth);
    }

    public Boolean getIs_eu() {
        return getIsEu();
    }

    public void setIs_eu(Boolean is_eu) {
        setIsEu(is_eu);
    }

    public String getMain_position() {
        return getMainPosition();
    }

    public void setMain_position(String main_position) {
        setMainPosition(main_position);
    }

    public Long getCurrent_club_id() {
        return getCurrentClubId();
    }

    public void setCurrent_club_id(Long current_club_id) {
        setCurrentClubId(current_club_id);
    }

    public String getCurrent_club_name() {
        return getCurrentClubName();
    }

    public void setCurrent_club_name(String current_club_name) {
        setCurrentClubName(current_club_name);
    }
}