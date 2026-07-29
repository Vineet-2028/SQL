package com.backend.backend.mapper;

import com.backend.backend.dto.response.MatchDTO;
import com.backend.backend.entity.Match;

public final class MatchMapper {

    private MatchMapper() {
    }

    public static MatchDTO toDto(Match match) {
        if (match == null) return null;

        return new MatchDTO(
                match.getMatchId(),
                match.getMatchDate(),
                match.getSeasonYear(),
                match.getLeagueName(),
                match.getHomeTeam(),
                match.getAwayTeam(),
                match.getHomeScore(),
                match.getAwayScore(),
                match.getVenue(),
                match.getAttendance(),
                match.getGameStatus(),
                match.getResult(),
                match.getTotalGoals(),
                match.getMatchTitle()
        );
    }
}