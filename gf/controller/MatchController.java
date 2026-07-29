package com.backend.backend.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.dto.response.MatchDTO;
import com.backend.backend.entity.Match;
import com.backend.backend.mapper.MatchMapper;
import com.backend.backend.service.MatchService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/matches")
    public Page<MatchDTO> getAllMatches(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        Page<Match> matches = matchService.getMatchesPaginated(page, size);
        return matches.map(MatchMapper::toDto);
    }

    @GetMapping("/matches/{id}")
    public MatchDTO getMatchById(@PathVariable Long id) {
        return MatchMapper.toDto(matchService.getMatchById(id));
    }

    @GetMapping("/matches/club")
    public List<MatchDTO> getMatchesByClub(@RequestParam String name) {
        return matchService.searchByClub(name)
                .stream()
                .map(MatchMapper::toDto)
                .toList();
    }

    @GetMapping("/matches/league")
    public List<MatchDTO> getMatchesByLeague(@RequestParam String league) {
        return matchService.searchByLeague(league)
                .stream()
                .map(MatchMapper::toDto)
                .toList();
    }
}