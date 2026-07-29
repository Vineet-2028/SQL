package com.backend.backend.dto.response;

public class TeamDisciplineDTO {

    private String disciplineId;
    private Integer rankNo;
    private String teamName;
    private Integer matchesPlayed;
    private Integer yellowCards;
    private Integer redCards;
    private Integer disciplinePoints;
    private Integer seasonYear;
    private String leagueName;

    public TeamDisciplineDTO() {
    }

    public TeamDisciplineDTO(String disciplineId, Integer rankNo, String teamName, Integer matchesPlayed,
                             Integer yellowCards, Integer redCards, Integer disciplinePoints,
                             Integer seasonYear, String leagueName) {
        this.disciplineId = disciplineId;
        this.rankNo = rankNo;
        this.teamName = teamName;
        this.matchesPlayed = matchesPlayed;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.disciplinePoints = disciplinePoints;
        this.seasonYear = seasonYear;
        this.leagueName = leagueName;
    }

    public String getDisciplineId() { return disciplineId; }
    public void setDisciplineId(String disciplineId) { this.disciplineId = disciplineId; }

    public Integer getRankNo() { return rankNo; }
    public void setRankNo(Integer rankNo) { this.rankNo = rankNo; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    public Integer getMatchesPlayed() { return matchesPlayed; }
    public void setMatchesPlayed(Integer matchesPlayed) { this.matchesPlayed = matchesPlayed; }

    public Integer getYellowCards() { return yellowCards; }
    public void setYellowCards(Integer yellowCards) { this.yellowCards = yellowCards; }

    public Integer getRedCards() { return redCards; }
    public void setRedCards(Integer redCards) { this.redCards = redCards; }

    public Integer getDisciplinePoints() { return disciplinePoints; }
    public void setDisciplinePoints(Integer disciplinePoints) { this.disciplinePoints = disciplinePoints; }

    public Integer getSeasonYear() { return seasonYear; }
    public void setSeasonYear(Integer seasonYear) { this.seasonYear = seasonYear; }

    public String getLeagueName() { return leagueName; }
    public void setLeagueName(String leagueName) { this.leagueName = leagueName; }
}