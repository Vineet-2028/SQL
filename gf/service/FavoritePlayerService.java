package com.backend.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.backend.dto.response.PlayerSummaryDTO;
import com.backend.backend.entity.FavoritePlayer;
import com.backend.backend.entity.Player;
import com.backend.backend.entity.User;
import com.backend.backend.mapper.PlayerMapper;
import com.backend.backend.repository.FavoritePlayerRepository;
import com.backend.backend.repository.PlayerRepository;
import com.backend.backend.repository.UserRepository;

@Service
public class FavoritePlayerService {

    private final FavoritePlayerRepository favoritePlayerRepository;
    private final UserRepository userRepository;
    private final PlayerRepository playerRepository;

    public FavoritePlayerService(
            FavoritePlayerRepository favoritePlayerRepository,
            UserRepository userRepository,
            PlayerRepository playerRepository
    ) {
        this.favoritePlayerRepository = favoritePlayerRepository;
        this.userRepository = userRepository;
        this.playerRepository = playerRepository;
    }

    public String addFavorite(String email, Long playerId) {
        User user = userRepository.findByEmail(email).orElseThrow();

        if (favoritePlayerRepository.existsByUserAndPlayerId(user, playerId)) {
            return "Player already in favorites";
        }

        favoritePlayerRepository.save(new FavoritePlayer(playerId, user));
        return "Player added to favorites";
    }

    public List<PlayerSummaryDTO> getFavorites(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();

        return favoritePlayerRepository.findByUser(user).stream()
                .map(FavoritePlayer::getPlayerId)
                .map(playerRepository::findById)
                .flatMap(opt -> opt.stream())
                .map(PlayerMapper::toSummaryDto)
                .toList();
    }

    @Transactional
    public String removeFavorite(String email, Long playerId) {
        User user = userRepository.findByEmail(email).orElseThrow();
        favoritePlayerRepository.deleteByUserAndPlayerId(user, playerId);
        return "Player removed from favorites";
    }
}