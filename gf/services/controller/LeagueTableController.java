package com.backend.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.dto.response.LeagueTableDTO;
import com.backend.backend.entity.LeagueTable;
import com.backend.backend.mapper.LeagueTableMapper;
import com.backend.backend.service.LeagueTableService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class LeagueTableController {

    private final LeagueTableService leagueTableService;

    public LeagueTableController(LeagueTableService leagueTableService) {
        this.leagueTableService = leagueTableService;
    }

    @GetMapping("/league-tables")
    public List<LeagueTableDTO> getAllTables() {
        return leagueTableService.getAllTables()
                .stream()
                .map(LeagueTableMapper::toDto)
                .toList();
    }

    @GetMapping("/league-tables/league")
    public List<LeagueTableDTO> getByLeague(@RequestParam String league) {
        return leagueTableService.searchByLeague(league)
                .stream()
                .map(LeagueTableMapper::toDto)
                .toList();
    }

    @GetMapping("/league-tables/team")
    public List<LeagueTableDTO> getByTeam(@RequestParam String team) {
        return leagueTableService.searchByTeam(team)
                .stream()
                .map(LeagueTableMapper::toDto)
                .toList();
    }

    @GetMapping("/league-tables/season")
    public List<LeagueTableDTO> getLeagueTableBySeason(
            @RequestParam String league,
            @RequestParam Integer year
    ) {
        return leagueTableService.getLeagueTableBySeason(league, year)
                .stream()
                .map(LeagueTableMapper::toDto)
                .toList();
    }
}