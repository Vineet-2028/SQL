package com.backend.backend.dto.response;

public class AssistLeaderDTO {

    private String assistLeaderId;
    private Integer rankNo;
    private String playerName;
    private String teamName;
    private Integer appearances;
    private Integer assists;
    private Integer seasonYear;
    private String leagueName;

    public AssistLeaderDTO() {
    }

    public AssistLeaderDTO(String assistLeaderId, Integer rankNo, String playerName, String teamName,
                           Integer appearances, Integer assists, Integer seasonYear, String leagueName) {
        this.assistLeaderId = assistLeaderId;
        this.rankNo = rankNo;
        this.playerName = playerName;
        this.teamName = teamName;
        this.appearances = appearances;
        this.assists = assists;
        this.seasonYear = seasonYear;
        this.leagueName = leagueName;
    }

    public String getAssistLeaderId() { return assistLeaderId; }
    public void setAssistLeaderId(String assistLeaderId) { this.assistLeaderId = assistLeaderId; }

    public Integer getRankNo() { return rankNo; }
    public void setRankNo(Integer rankNo) { this.rankNo = rankNo; }

    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    public Integer getAppearances() { return appearances; }
    public void setAppearances(Integer appearances) { this.appearances = appearances; }

    public Integer getAssists() { return assists; }
    public void setAssists(Integer assists) { this.assists = assists; }

    public Integer getSeasonYear() { return seasonYear; }
    public void setSeasonYear(Integer seasonYear) { this.seasonYear = seasonYear; }

    public String getLeagueName() { return leagueName; }
    public void setLeagueName(String leagueName) { this.leagueName = leagueName; }
}