package com.backend.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.dto.response.PlayerNationalPerformanceDTO;
import com.backend.backend.mapper.PlayerMapper;
import com.backend.backend.service.PlayerNationalPerformanceService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/national-performance")
public class PlayerNationalPerformanceController {

    private final PlayerNationalPerformanceService playerNationalPerformanceService;

    public PlayerNationalPerformanceController(PlayerNationalPerformanceService playerNationalPerformanceService) {
        this.playerNationalPerformanceService = playerNationalPerformanceService;
    }

    @GetMapping("/team/{teamId}")
    public List<PlayerNationalPerformanceDTO> getNationalPerformanceByTeamId(@PathVariable Long teamId) {
        return playerNationalPerformanceService.searchByTeamId(teamId)
                .stream()
                .map(PlayerMapper::toNationalDto)
                .toList();
    }

    @GetMapping("/player/{playerId}")
    public List<PlayerNationalPerformanceDTO> getNationalPerformanceByPlayerId(@PathVariable Long playerId) {
        return playerNationalPerformanceService.searchByPlayerId(playerId)
                .stream()
                .map(PlayerMapper::toNationalDto)
                .toList();
    }
}