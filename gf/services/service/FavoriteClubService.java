package com.backend.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.backend.dto.response.FavoriteClubDTO;
import com.backend.backend.entity.FavoriteClub;
import com.backend.backend.entity.User;
import com.backend.backend.mapper.FavoriteClubMapper;
import com.backend.backend.repository.FavoriteClubRepository;
import com.backend.backend.repository.UserRepository;

@Service
public class FavoriteClubService {

    private final FavoriteClubRepository favoriteClubRepository;
    private final UserRepository userRepository;

    public FavoriteClubService(FavoriteClubRepository favoriteClubRepository, UserRepository userRepository) {
        this.favoriteClubRepository = favoriteClubRepository;
        this.userRepository = userRepository;
    }

    public String addFavorite(String email, FavoriteClubDTO request) {
        User user = userRepository.findByEmail(email).orElseThrow();

        if (favoriteClubRepository.existsByUserAndTeamName(user, request.getTeamName())) {
            return "Club already in favorites";
        }

        FavoriteClub club = new FavoriteClub(
                request.getTeamName(),
                request.getLeagueName(),
                request.getPlace(),
                request.getPoints(),
                request.getWins(),
                request.getGoalDifference(),
                request.getSeasonYear(),
                user
        );

        favoriteClubRepository.save(club);
        return "Club added to favorites";
    }

    public List<FavoriteClubDTO> getFavorites(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();

        return favoriteClubRepository.findByUser(user)
                .stream()
                .map(FavoriteClubMapper::toDto)
                .toList();
    }

    @Transactional
    public String removeFavorite(String email, String teamName) {
        User user = userRepository.findByEmail(email).orElseThrow();
        favoriteClubRepository.deleteByUserAndTeamName(user, teamName);
        return "Club removed from favorites";
    }
}