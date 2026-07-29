package com.backend.backend.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backend.backend.dto.response.PlayerSummaryDTO;
import com.backend.backend.entity.Player;
import com.backend.backend.mapper.PlayerMapper;
import com.backend.backend.repository.PlayerRepository;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<PlayerSummaryDTO> getAllPlayers() {
        return playerRepository.findAll()
                .stream()
                .map(PlayerMapper::toSummaryDto)
                .toList();
    }

    public PlayerSummaryDTO getPlayerById(Long id) {
        return playerRepository.findById(id)
                .map(PlayerMapper::toSummaryDto)
                .orElse(null);
    }

    public List<PlayerSummaryDTO> searchPlayersByName(String name) {
        return playerRepository.findByPlayerNameContainingIgnoreCase(name)
                .stream()
                .map(PlayerMapper::toSummaryDto)
                .toList();
    }

    public List<PlayerSummaryDTO> searchPlayersByClub(String club) {
        return playerRepository.findByCurrentClubNameContainingIgnoreCase(club)
                .stream()
                .map(PlayerMapper::toSummaryDto)
                .toList();
    }

    public List<PlayerSummaryDTO> searchPlayersByPosition(String position) {
        return playerRepository.findByPositionContainingIgnoreCase(position)
                .stream()
                .map(PlayerMapper::toSummaryDto)
                .toList();
    }

    public Page<PlayerSummaryDTO> getPlayersPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return playerRepository.findAll(pageable)
                .map(PlayerMapper::toSummaryDto);
    }
}