package com.backend.backend.mapper;

import com.backend.backend.dto.response.TeamDisciplineDTO;
import com.backend.backend.entity.TeamDiscipline;

public final class TeamDisciplineMapper {

    private TeamDisciplineMapper() {
    }

    public static TeamDisciplineDTO toDto(TeamDiscipline discipline) {
        if (discipline == null) return null;

        return new TeamDisciplineDTO(
                discipline.getDisciplineId(),
                discipline.getRankNo(),
                discipline.getTeamName(),
                discipline.getMatchesPlayed(),
                discipline.getYellowCards(),
                discipline.getRedCards(),
                discipline.getDisciplinePoints(),
                discipline.getSeasonYear(),
                discipline.getLeagueName()
        );
    }
}