package com.backend.backend.dto.response;

public class GoalLeaderDTO {

    private String goalLeaderId;
    private Integer rankNo;
    private String playerName;
    private String teamName;
    private Integer appearances;
    private Integer goals;
    private Integer seasonYear;
    private String leagueName;

    public GoalLeaderDTO() {
    }

    public GoalLeaderDTO(String goalLeaderId, Integer rankNo, String playerName, String teamName,
                         Integer appearances, Integer goals, Integer seasonYear, String leagueName) {
        this.goalLeaderId = goalLeaderId;
        this.rankNo = rankNo;
        this.playerName = playerName;
        this.teamName = teamName;
        this.appearances = appearances;
        this.goals = goals;
        this.seasonYear = seasonYear;
        this.leagueName = leagueName;
    }

    public String getGoalLeaderId() { return goalLeaderId; }
    public void setGoalLeaderId(String goalLeaderId) { this.goalLeaderId = goalLeaderId; }

    public Integer getRankNo() { return rankNo; }
    public void setRankNo(Integer rankNo) { this.rankNo = rankNo; }

    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    public Integer getAppearances() { return appearances; }
    public void setAppearances(Integer appearances) { this.appearances = appearances; }

    public Integer getGoals() { return goals; }
    public void setGoals(Integer goals) { this.goals = goals; }

    public Integer getSeasonYear() { return seasonYear; }
    public void setSeasonYear(Integer seasonYear) { this.seasonYear = seasonYear; }

    public String getLeagueName() { return leagueName; }
    public void setLeagueName(String leagueName) { this.leagueName = leagueName; }
}