package com.backend.backend.mapper;

import com.backend.backend.dto.response.GoalLeaderDTO;
import com.backend.backend.entity.GoalLeader;

public final class GoalLeaderMapper {

    private GoalLeaderMapper() {
    }

    public static GoalLeaderDTO toDto(GoalLeader leader) {
        if (leader == null) return null;

        return new GoalLeaderDTO(
                leader.getGoalLeaderId(),
                leader.getRankNo(),
                leader.getPlayerName(),
                leader.getTeamName(),
                leader.getAppearances(),
                leader.getGoals(),
                leader.getSeasonYear(),
                leader.getLeagueName()
        );
    }
}