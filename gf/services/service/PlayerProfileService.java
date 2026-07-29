package com.backend.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.backend.dto.response.PlayerProfileResponse;
import com.backend.backend.entity.Player;
import com.backend.backend.entity.PlayerNationalPerformance;
import com.backend.backend.entity.PlayerPerformance;
import com.backend.backend.mapper.PlayerMapper;
import com.backend.backend.repository.PlayerNationalPerformanceRepository;
import com.backend.backend.repository.PlayerPerformanceRepository;
import com.backend.backend.repository.PlayerRepository;

@Service
public class PlayerProfileService {

    private final PlayerRepository playerRepository;
    private final PlayerPerformanceRepository playerPerformanceRepository;
    private final PlayerNationalPerformanceRepository playerNationalPerformanceRepository;

    public PlayerProfileService(
            PlayerRepository playerRepository,
            PlayerPerformanceRepository playerPerformanceRepository,
            PlayerNationalPerformanceRepository playerNationalPerformanceRepository) {
        this.playerRepository = playerRepository;
        this.playerPerformanceRepository = playerPerformanceRepository;
        this.playerNationalPerformanceRepository = playerNationalPerformanceRepository;
    }

    public PlayerProfileResponse getPlayerProfile(Long playerId) {
        Player player = playerRepository.findByPlayerId(playerId);

        List<PlayerPerformance> clubPerformance =
                playerPerformanceRepository.findByPlayerId(playerId);

        List<PlayerNationalPerformance> nationalPerformance =
                playerNationalPerformanceRepository.findByPlayerId(playerId);

        PlayerProfileResponse response = new PlayerProfileResponse();
        response.setPlayer(PlayerMapper.toProfileDto(player));
        response.setClubPerformance(
                clubPerformance.stream().map(PlayerMapper::toPerformanceDto).toList()
        );
        response.setNationalPerformance(
                nationalPerformance.stream().map(PlayerMapper::toNationalDto).toList()
        );

        return response;
    }
}