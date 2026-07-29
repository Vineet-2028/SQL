package com.backend.backend.dto.response;

public class PlayerPerformanceDTO {

    private Long id;
    private Long playerId;
    private String matchDate;
    private String competitionId;
    private String competitionName;
    private String teamId;
    private String teamName;
    private Long nbInGroup;
    private String nbOnPitch;
    private Integer goals;
    private Integer assists;
    private Integer ownGoals;
    private Integer subedIn;
    private Integer subedOut;
    private Integer yellowCards;
    private Integer secondYellowCards;
    private Integer directRedCards;
    private Integer penaltyGoals;
    private Integer minutesPlayed;
    private Integer goalsConceded;
    private Integer cleanSheets;

    public PlayerPerformanceDTO() {
    }

    public PlayerPerformanceDTO(Long id, Long playerId, String matchDate, String competitionId, String competitionName,
                                String teamId, String teamName, Long nbInGroup, String nbOnPitch, Integer goals,
                                Integer assists, Integer ownGoals, Integer subedIn, Integer subedOut,
                                Integer yellowCards, Integer secondYellowCards, Integer directRedCards,
                                Integer penaltyGoals, Integer minutesPlayed, Integer goalsConceded,
                                Integer cleanSheets) {
        this.id = id;
        this.playerId = playerId;
        this.matchDate = matchDate;
        this.competitionId = competitionId;
        this.competitionName = competitionName;
        this.teamId = teamId;
        this.teamName = teamName;
        this.nbInGroup = nbInGroup;
        this.nbOnPitch = nbOnPitch;
        this.goals = goals;
        this.assists = assists;
        this.ownGoals = ownGoals;
        this.subedIn = subedIn;
        this.subedOut = subedOut;
        this.yellowCards = yellowCards;
        this.secondYellowCards = secondYellowCards;
        this.directRedCards = directRedCards;
        this.penaltyGoals = penaltyGoals;
        this.minutesPlayed = minutesPlayed;
        this.goalsConceded = goalsConceded;
        this.cleanSheets = cleanSheets;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPlayerId() { return playerId; }
    public void setPlayerId(Long playerId) { this.playerId = playerId; }

    public String getMatchDate() { return matchDate; }
    public void setMatchDate(String matchDate) { this.matchDate = matchDate; }

    public String getCompetitionId() { return competitionId; }
    public void setCompetitionId(String competitionId) { this.competitionId = competitionId; }

    public String getCompetitionName() { return competitionName; }
    public void setCompetitionName(String competitionName) { this.competitionName = competitionName; }

    public String getTeamId() { return teamId; }
    public void setTeamId(String teamId) { this.teamId = teamId; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    public Long getNbInGroup() { return nbInGroup; }
    public void setNbInGroup(Long nbInGroup) { this.nbInGroup = nbInGroup; }

    public String getNbOnPitch() { return nbOnPitch; }
    public void setNbOnPitch(String nbOnPitch) { this.nbOnPitch = nbOnPitch; }

    public Integer getGoals() { return goals; }
    public void setGoals(Integer goals) { this.goals = goals; }

    public Integer getAssists() { return assists; }
    public void setAssists(Integer assists) { this.assists = assists; }

    public Integer getOwnGoals() { return ownGoals; }
    public void setOwnGoals(Integer ownGoals) { this.ownGoals = ownGoals; }

    public Integer getSubedIn() { return subedIn; }
    public void setSubedIn(Integer subedIn) { this.subedIn = subedIn; }

    public Integer getSubedOut() { return subedOut; }
    public void setSubedOut(Integer subedOut) { this.subedOut = subedOut; }

    public Integer getYellowCards() { return yellowCards; }
    public void setYellowCards(Integer yellowCards) { this.yellowCards = yellowCards; }

    public Integer getSecondYellowCards() { return secondYellowCards; }
    public void setSecondYellowCards(Integer secondYellowCards) { this.secondYellowCards = secondYellowCards; }

    public Integer getDirectRedCards() { return directRedCards; }
    public void setDirectRedCards(Integer directRedCards) { this.directRedCards = directRedCards; }

    public Integer getPenaltyGoals() { return penaltyGoals; }
    public void setPenaltyGoals(Integer penaltyGoals) { this.penaltyGoals = penaltyGoals; }

    public Integer getMinutesPlayed() { return minutesPlayed; }
    public void setMinutesPlayed(Integer minutesPlayed) { this.minutesPlayed = minutesPlayed; }

    public Integer getGoalsConceded() { return goalsConceded; }
    public void setGoalsConceded(Integer goalsConceded) { this.goalsConceded = goalsConceded; }

    public Integer getCleanSheets() { return cleanSheets; }
    public void setCleanSheets(Integer cleanSheets) { this.cleanSheets = cleanSheets; }
}