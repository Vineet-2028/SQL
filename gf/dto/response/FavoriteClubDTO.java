package com.backend.backend.dto.response;

public class FavoriteClubDTO {

    private String teamName;
    private String leagueName;
    private Integer place;
    private Integer points;
    private Integer wins;
    private Integer goalDifference;
    private Integer seasonYear;

    public FavoriteClubDTO() {
    }

    public FavoriteClubDTO(String teamName, String leagueName, Integer place, Integer points,
                           Integer wins, Integer goalDifference, Integer seasonYear) {
        this.teamName = teamName;
        this.leagueName = leagueName;
        this.place = place;
        this.points = points;
        this.wins = wins;
        this.goalDifference = goalDifference;
        this.seasonYear = seasonYear;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(Integer goalDifference) {
        this.goalDifference = goalDifference;
    }

    public Integer getSeasonYear() {
        return seasonYear;
    }

    public void setSeasonYear(Integer seasonYear) {
        this.seasonYear = seasonYear;
    }
}