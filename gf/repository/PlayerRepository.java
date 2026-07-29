package com.backend.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.backend.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findByPlayerNameContainingIgnoreCase(String name);

    List<Player> findByCurrentClubNameContainingIgnoreCase(String club);

    List<Player> findByPositionContainingIgnoreCase(String position);

    Player findByPlayerId(Long playerId);
}