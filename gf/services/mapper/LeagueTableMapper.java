package com.backend.backend.mapper;

import com.backend.backend.dto.response.LeagueTableDTO;
import com.backend.backend.entity.LeagueTable;

public final class LeagueTableMapper {

    private LeagueTableMapper() {
    }

    public static LeagueTableDTO toDto(LeagueTable table) {
        if (table == null) return null;

        return new LeagueTableDTO(
                table.getTableId(),
                table.getPlace(),
                table.getTeamName(),
                table.getGamesPlayed(),
                table.getWins(),
                table.getDraws(),
                table.getLosses(),
                table.getGoalsFor(),
                table.getGoalsAgainst(),
                table.getGoalDifference(),
                table.getPoints(),
                table.getSeasonYear(),
                table.getLeagueName()
        );
    }
}