package com.backend.backend.mapper;

import com.backend.backend.dto.response.FavoriteClubDTO;
import com.backend.backend.entity.FavoriteClub;

public final class FavoriteClubMapper {

    private FavoriteClubMapper() {
    }

    public static FavoriteClubDTO toDto(FavoriteClub club) {
        if (club == null) {
            return null;
        }

        return new FavoriteClubDTO(
                club.getTeamName(),
                club.getLeagueName(),
                club.getPlace(),
                club.getPoints(),
                club.getWins(),
                club.getGoalDifference(),
                club.getSeasonYear()
        );
    }
}