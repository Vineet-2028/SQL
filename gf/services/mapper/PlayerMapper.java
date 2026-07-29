package com.backend.backend.mapper;

import com.backend.backend.dto.response.PlayerNationalPerformanceDTO;
import com.backend.backend.dto.response.PlayerPerformanceDTO;
import com.backend.backend.dto.response.PlayerProfileDTO;
import com.backend.backend.dto.response.PlayerSummaryDTO;
import com.backend.backend.entity.Player;
import com.backend.backend.entity.PlayerNationalPerformance;
import com.backend.backend.entity.PlayerPerformance;

public final class PlayerMapper {

    private PlayerMapper() {
    }

    public static PlayerSummaryDTO toSummaryDto(Player player) {
        if (player == null) return null;

        return new PlayerSummaryDTO(
                player.getPlayerId(),
                player.getPlayerName(),
                player.getPlayerImageUrl(),
                player.getCurrentClubName(),
                player.getAge(),
                player.getFoot(),
                player.getPosition()
        );
    }

    public static PlayerPerformanceDTO toPerformanceDto(PlayerPerformance p) {
        if (p == null) return null;

        return new PlayerPerformanceDTO(
                p.getId(),
                p.getPlayerId(),
                p.getMatchDate(),
                p.getCompetitionId(),
                p.getCompetitionName(),
                p.getTeamId(),
                p.getTeamName(),
                p.getNbInGroup(),
                p.getNbOnPitch(),
                p.getGoals(),
                p.getAssists(),
                p.getOwnGoals(),
                p.getSubedIn(),
                p.getSubedOut(),
                p.getYellowCards(),
                p.getSecondYellowCards(),
                p.getDirectRedCards(),
                p.getPenaltyGoals(),
                p.getMinutesPlayed(),
                p.getGoalsConceded(),
                p.getCleanSheets()
        );
    }

    public static PlayerNationalPerformanceDTO toNationalDto(PlayerNationalPerformance p) {
        if (p == null) return null;

        return new PlayerNationalPerformanceDTO(
                p.getId(),
                p.getPlayerId(),
                p.getTeamId(),
                p.getMatches(),
                p.getGoals(),
                p.getShirtNumber(),
                p.getCareerState()
        );
    }

    public static PlayerProfileDTO toProfileDto(Player player) {

        if (player == null) {
            return null;
        }

        PlayerProfileDTO dto = new PlayerProfileDTO();

        dto.setPlayerId(player.getPlayerId());
        dto.setPlayerName(player.getPlayerName());
        dto.setPlayerImageUrl(player.getPlayerImageUrl());
        dto.setDateOfBirth(player.getDateOfBirth());
        dto.setAge(player.getAge());
        dto.setPlaceOfBirth(player.getPlaceOfBirth());
        dto.setCountryOfBirth(player.getCountryOfBirth());
        dto.setHeight(player.getHeight());
        dto.setCitizenship(player.getCitizenship());
        dto.setIsEu(player.getIsEu());
        dto.setPosition(player.getPosition());
        dto.setMainPosition(player.getMainPosition());
        dto.setFoot(player.getFoot());
        dto.setCurrentClubId(player.getCurrentClubId());
        dto.setCurrentClubName(player.getCurrentClubName());
        dto.setJoined(player.getJoined());

        return dto;
    }
}