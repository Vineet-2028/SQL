package com.backend.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "favorite_clubs")
public class FavoriteClub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;
    private String leagueName;
    private Integer place;
    private Integer points;
    private Integer wins;
    private Integer goalDifference;
    private Integer seasonYear;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public FavoriteClub() {
    }

    public FavoriteClub(String teamName, String leagueName, Integer place, Integer points, Integer wins, Integer goalDifference, Integer seasonYear, User user) {
        this.teamName = teamName;
        this.leagueName = leagueName;
        this.place = place;
        this.points = points;
        this.wins = wins;
        this.goalDifference = goalDifference;
        this.seasonYear = seasonYear;
        this.user = user;
    }

    public Long getId() { return id; }
    public String getTeamName() { return teamName; }
    public String getLeagueName() { return leagueName; }
    public Integer getPlace() { return place; }
    public Integer getPoints() { return points; }
    public Integer getWins() { return wins; }
    public Integer getGoalDifference() { return goalDifference; }
    public Integer getSeasonYear() { return seasonYear; }
    public User getUser() { return user; }

    public void setId(Long id) { this.id = id; }
    public void setTeamName(String teamName) { this.teamName = teamName; }
    public void setLeagueName(String leagueName) { this.leagueName = leagueName; }
    public void setPlace(Integer place) { this.place = place; }
    public void setPoints(Integer points) { this.points = points; }
    public void setWins(Integer wins) { this.wins = wins; }
    public void setGoalDifference(Integer goalDifference) { this.goalDifference = goalDifference; }
    public void setSeasonYear(Integer seasonYear) { this.seasonYear = seasonYear; }
    public void setUser(User user) { this.user = user; }
}