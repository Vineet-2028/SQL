package com.backend.backend.dto.response;

import java.util.List;

import com.backend.backend.dto.response.PlayerNationalPerformanceDTO;
import com.backend.backend.dto.response.PlayerPerformanceDTO;
import com.backend.backend.dto.response.PlayerProfileDTO;

public class PlayerProfileResponse {

    private PlayerProfileDTO player;
    private List<PlayerPerformanceDTO> clubPerformance;
    private List<PlayerNationalPerformanceDTO> nationalPerformance;

    public PlayerProfileDTO getPlayer() {
        return player;
    }

    public void setPlayer(PlayerProfileDTO player) {
        this.player = player;
    }

    public List<PlayerPerformanceDTO> getClubPerformance() {
        return clubPerformance;
    }

    public void setClubPerformance(List<PlayerPerformanceDTO> clubPerformance) {
        this.clubPerformance = clubPerformance;
    }

    public List<PlayerNationalPerformanceDTO> getNationalPerformance() {
        return nationalPerformance;
    }

    public void setNationalPerformance(List<PlayerNationalPerformanceDTO> nationalPerformance) {
        this.nationalPerformance = nationalPerformance;
    }
}