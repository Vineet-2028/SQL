package com.backend.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.dto.response.AssistLeaderDTO;
import com.backend.backend.entity.AssistLeader;
import com.backend.backend.mapper.AssistLeaderMapper;
import com.backend.backend.service.AssistLeaderService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class AssistLeaderController {

    private final AssistLeaderService assistLeaderService;

    public AssistLeaderController(AssistLeaderService assistLeaderService) {
        this.assistLeaderService = assistLeaderService;
    }

    @GetMapping("/assist-leaders")
    public List<AssistLeaderDTO> getAllAssistLeaders() {
        return assistLeaderService.getAllAssistLeaders()
                .stream()
                .map(AssistLeaderMapper::toDto)
                .toList();
    }

    @GetMapping("/assist-leaders/league")
    public List<AssistLeaderDTO> getByLeague(@RequestParam String league) {
        return assistLeaderService.searchByLeague(league)
                .stream()
                .map(AssistLeaderMapper::toDto)
                .toList();
    }

    @GetMapping("/assist-leaders/player")
    public List<AssistLeaderDTO> getByPlayer(@RequestParam String player) {
        return assistLeaderService.searchByPlayer(player)
                .stream()
                .map(AssistLeaderMapper::toDto)
                .toList();
    }

    @GetMapping("/assist-leaders/team")
    public List<AssistLeaderDTO> getByTeam(@RequestParam String team) {
        return assistLeaderService.searchByTeam(team)
                .stream()
                .map(AssistLeaderMapper::toDto)
                .toList();
    }

    @GetMapping("/assist-leaders/season")
    public List<AssistLeaderDTO> getBySeason(
            @RequestParam String league,
            @RequestParam Integer year
    ) {
        return assistLeaderService.getAssistLeadersBySeason(league, year)
                .stream()
                .map(AssistLeaderMapper::toDto)
                .toList();
    }
}