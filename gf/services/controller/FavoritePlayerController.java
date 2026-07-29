package com.backend.backend.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.backend.backend.dto.response.PlayerSummaryDTO;
import com.backend.backend.service.FavoritePlayerService;

@RestController
@RequestMapping("/favorites/player")
@CrossOrigin(origins = "http://localhost:5173")
public class FavoritePlayerController {

    private final FavoritePlayerService favoritePlayerService;

    public FavoritePlayerController(FavoritePlayerService favoritePlayerService) {
        this.favoritePlayerService = favoritePlayerService;
    }

    @PostMapping("/{playerId}")
    public String addFavorite(@PathVariable Long playerId, Principal principal) {
        return favoritePlayerService.addFavorite(principal.getName(), playerId);
    }

    @GetMapping
    public List<PlayerSummaryDTO> getFavorites(Principal principal) {
        return favoritePlayerService.getFavorites(principal.getName());
    }

    @DeleteMapping("/{playerId}")
    public String removeFavorite(@PathVariable Long playerId, Principal principal) {
        return favoritePlayerService.removeFavorite(principal.getName(), playerId);
    }
}