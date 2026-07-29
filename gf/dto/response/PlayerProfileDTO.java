package com.backend.backend.dto.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerProfileDTO {

    @JsonProperty("player_id")
    private Long player_id;

    @JsonProperty("player_name")
    private String player_name;

    @JsonProperty("player_image_url")
    private String player_image_url;

    @JsonProperty("date_of_birth")
    private LocalDate date_of_birth;

    private Integer age;

    @JsonProperty("place_of_birth")
    private String place_of_birth;

    @JsonProperty("country_of_birth")
    private String country_of_birth;

    private Double height;
    private String citizenship;

    @JsonProperty("is_eu")
    private Boolean is_eu;

    private String position;

    @JsonProperty("main_position")
    private String main_position;

    private String foot;

    @JsonProperty("current_club_id")
    private Long current_club_id;

    @JsonProperty("current_club_name")
    private String current_club_name;

    private LocalDate joined;

    public PlayerProfileDTO() {
    }

    public Long getPlayerId() {
        return player_id;
    }

    public void setPlayerId(Long playerId) {
        this.player_id = playerId;
    }

    public String getPlayerName() {
        return player_name;
    }

    public void setPlayerName(String playerName) {
        this.player_name = playerName;
    }

    public String getPlayerImageUrl() {
        return player_image_url;
    }

    public void setPlayerImageUrl(String playerImageUrl) {
        this.player_image_url = playerImageUrl;
    }

    public LocalDate getDateOfBirth() {
        return date_of_birth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.date_of_birth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPlaceOfBirth() {
        return place_of_birth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.place_of_birth = placeOfBirth;
    }

    public String getCountryOfBirth() {
        return country_of_birth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.country_of_birth = countryOfBirth;
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
        return is_eu;
    }

    public void setIsEu(Boolean isEu) {
        this.is_eu = isEu;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMainPosition() {
        return main_position;
    }

    public void setMainPosition(String mainPosition) {
        this.main_position = mainPosition;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public Long getCurrentClubId() {
        return current_club_id;
    }

    public void setCurrentClubId(Long currentClubId) {
        this.current_club_id = currentClubId;
    }

    public String getCurrentClubName() {
        return current_club_name;
    }

    public void setCurrentClubName(String currentClubName) {
        this.current_club_name = currentClubName;
    }

    public LocalDate getJoined() {
        return joined;
    }

    public void setJoined(LocalDate joined) {
        this.joined = joined;
    }
}