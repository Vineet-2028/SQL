package com.backend.backend.dto.response;

public class LeagueTableDTO {

    private String tableId;
    private Integer place;
    private String teamName;
    private Integer gamesPlayed;
    private Integer wins;
    private Integer draws;
    private Integer losses;
    private Integer goalsFor;
    private Integer goalsAgainst;
    private Integer goalDifference;
    private Integer points;
    private Integer seasonYear;
    private String leagueName;

    public LeagueTableDTO() {
    }

    public LeagueTableDTO(String tableId, Integer place, String teamName, Integer gamesPlayed, Integer wins,
                          Integer draws, Integer losses, Integer goalsFor, Integer goalsAgainst,
                          Integer goalDifference, Integer points, Integer seasonYear, String leagueName) {
        this.tableId = tableId;
        this.place = place;
        this.teamName = teamName;
        this.gamesPlayed = gamesPlayed;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalDifference = goalDifference;
        this.points = points;
        this.seasonYear = seasonYear;
        this.leagueName = leagueName;
    }

    public String getTableId() { return tableId; }
    public void setTableId(String tableId) { this.tableId = tableId; }

    public Integer getPlace() { return place; }
    public void setPlace(Integer place) { this.place = place; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    public Integer getGamesPlayed() { return gamesPlayed; }
    public void setGamesPlayed(Integer gamesPlayed) { this.gamesPlayed = gamesPlayed; }

    public Integer getWins() { return wins; }
    public void setWins(Integer wins) { this.wins = wins; }

    public Integer getDraws() { return draws; }
    public void setDraws(Integer draws) { this.draws = draws; }

    public Integer getLosses() { return losses; }
    public void setLosses(Integer losses) { this.losses = losses; }

    public Integer getGoalsFor() { return goalsFor; }
    public void setGoalsFor(Integer goalsFor) { this.goalsFor = goalsFor; }

    public Integer getGoalsAgainst() { return goalsAgainst; }
    public void setGoalsAgainst(Integer goalsAgainst) { this.goalsAgainst = goalsAgainst; }

    public Integer getGoalDifference() { return goalDifference; }
    public void setGoalDifference(Integer goalDifference) { this.goalDifference = goalDifference; }

    public Integer getPoints() { return points; }
    public void setPoints(Integer points) { this.points = points; }

    public Integer getSeasonYear() { return seasonYear; }
    public void setSeasonYear(Integer seasonYear) { this.seasonYear = seasonYear; }

    public String getLeagueName() { return leagueName; }
    public void setLeagueName(String leagueName) { this.leagueName = leagueName; }
}