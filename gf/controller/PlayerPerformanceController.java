package com.backend.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.dto.response.PlayerPerformanceDTO;
import com.backend.backend.mapper.PlayerMapper;
import com.backend.backend.service.PlayerPerformanceService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/performance")
public class PlayerPerformanceController {

    private final PlayerPerformanceService playerPerformanceService;

    public PlayerPerformanceController(PlayerPerformanceService playerPerformanceService) {
        this.playerPerformanceService = playerPerformanceService;
    }

    @GetMapping("/team/{teamName}")
    public List<PlayerPerformanceDTO> getPerformanceByTeamName(@PathVariable String teamName) {
        return playerPerformanceService.searchPerformanceByName(teamName)
                .stream()
                .map(PlayerMapper::toPerformanceDto)
                .toList();
    }

    @GetMapping("/competition/{competitionId}")
    public List<PlayerPerformanceDTO> getPerformanceByCompetitionId(@PathVariable String competitionId) {
        return playerPerformanceService.findByCompetitionId(competitionId)
                .stream()
                .map(PlayerMapper::toPerformanceDto)
                .toList();
    }
}