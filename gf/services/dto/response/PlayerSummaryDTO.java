package com.backend.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerSummaryDTO {

    @JsonProperty("player_id")
    private Long playerId;

    @JsonProperty("player_name")
    private String playerName;

    @JsonProperty("player_image_url")
    private String playerImageUrl;

    @JsonProperty("current_club_name")
    private String currentClubName;

    private Integer age;
    private String foot;
    private String position;

    public PlayerSummaryDTO() {
    }

    public PlayerSummaryDTO(Long playerId, String playerName, String playerImageUrl,
                            String currentClubName, Integer age, String foot, String position) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerImageUrl = playerImageUrl;
        this.currentClubName = currentClubName;
        this.age = age;
        this.foot = foot;
        this.position = position;
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

    public String getCurrentClubName() {
        return currentClubName;
    }

    public void setCurrentClubName(String currentClubName) {
        this.currentClubName = currentClubName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}