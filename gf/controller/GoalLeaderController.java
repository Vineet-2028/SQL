package com.backend.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.dto.response.GoalLeaderDTO;
import com.backend.backend.entity.GoalLeader;
import com.backend.backend.mapper.GoalLeaderMapper;
import com.backend.backend.service.GoalLeaderService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class GoalLeaderController {

    private final GoalLeaderService goalLeaderService;

    public GoalLeaderController(GoalLeaderService goalLeaderService) {
        this.goalLeaderService = goalLeaderService;
    }

    @GetMapping("/goal-leaders")
    public List<GoalLeaderDTO> getAllGoalLeaders() {
        return goalLeaderService.getAllGoalLeaders()
                .stream()
                .map(GoalLeaderMapper::toDto)
                .toList();
    }

    @GetMapping("/goal-leaders/league")
    public List<GoalLeaderDTO> getByLeague(@RequestParam String league) {
        return goalLeaderService.searchByLeague(league)
                .stream()
                .map(GoalLeaderMapper::toDto)
                .toList();
    }

    @GetMapping("/goal-leaders/player")
    public List<GoalLeaderDTO> getByPlayer(@RequestParam String player) {
        return goalLeaderService.searchByPlayer(player)
                .stream()
                .map(GoalLeaderMapper::toDto)
                .toList();
    }

    @GetMapping("/goal-leaders/team")
    public List<GoalLeaderDTO> getByTeam(@RequestParam String team) {
        return goalLeaderService.searchByTeam(team)
                .stream()
                .map(GoalLeaderMapper::toDto)
                .toList();
    }

    @GetMapping("/goal-leaders/season")
    public List<GoalLeaderDTO> getBySeason(
            @RequestParam String league,
            @RequestParam Integer year
    ) {
        return goalLeaderService.getGoalLeadersBySeason(league, year)
                .stream()
                .map(GoalLeaderMapper::toDto)
                .toList();
    }
}