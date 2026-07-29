package com.backend.backend.dto.response;

public class PlayerNationalPerformanceDTO {

    private Long id;
    private Long playerId;
    private Long teamId;
    private Integer matches;
    private Integer goals;
    private Integer shirtNumber;
    private String careerState;

    public PlayerNationalPerformanceDTO() {
    }

    public PlayerNationalPerformanceDTO(Long id, Long playerId, Long teamId, Integer matches, Integer goals,
                                        Integer shirtNumber, String careerState) {
        this.id = id;
        this.playerId = playerId;
        this.teamId = teamId;
        this.matches = matches;
        this.goals = goals;
        this.shirtNumber = shirtNumber;
        this.careerState = careerState;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPlayerId() { return playerId; }
    public void setPlayerId(Long playerId) { this.playerId = playerId; }

    public Long getTeamId() { return teamId; }
    public void setTeamId(Long teamId) { this.teamId = teamId; }

    public Integer getMatches() { return matches; }
    public void setMatches(Integer matches) { this.matches = matches; }

    public Integer getGoals() { return goals; }
    public void setGoals(Integer goals) { this.goals = goals; }

    public Integer getShirtNumber() { return shirtNumber; }
    public void setShirtNumber(Integer shirtNumber) { this.shirtNumber = shirtNumber; }

    public String getCareerState() { return careerState; }
    public void setCareerState(String careerState) { this.careerState = careerState; }
}