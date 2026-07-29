package com.backend.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.backend.entity.FavoriteClub;
import com.backend.backend.entity.User;

public interface FavoriteClubRepository extends JpaRepository<FavoriteClub, Long> {

    List<FavoriteClub> findByUser(User user);

    boolean existsByUserAndTeamName(User user, String teamName);

    void deleteByUserAndTeamName(User user, String teamName);
}