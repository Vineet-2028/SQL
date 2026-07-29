package com.backend.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.backend.entity.FavoritePlayer;
import com.backend.backend.entity.User;

public interface FavoritePlayerRepository extends JpaRepository<FavoritePlayer, Long> {

    List<FavoritePlayer> findByUser(User user);

    Optional<FavoritePlayer> findByUserAndPlayerId(User user, Long playerId);

    boolean existsByUserAndPlayerId(User user, Long playerId);

    void deleteByUserAndPlayerId(User user, Long playerId);
}