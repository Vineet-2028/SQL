package com.backend.backend.mapper;

import com.backend.backend.dto.response.AssistLeaderDTO;
import com.backend.backend.entity.AssistLeader;

public final class AssistLeaderMapper {

    private AssistLeaderMapper() {
    }

    public static AssistLeaderDTO toDto(AssistLeader leader) {
        if (leader == null) return null;

        return new AssistLeaderDTO(
                leader.getAssistLeaderId(),
                leader.getRankNo(),
                leader.getPlayerName(),
                leader.getTeamName(),
                leader.getAppearances(),
                leader.getAssists(),
                leader.getSeasonYear(),
                leader.getLeagueName()
        );
    }
}