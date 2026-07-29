package com.backend.backend.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.backend.backend.dto.response.FavoriteClubDTO;
import com.backend.backend.service.FavoriteClubService;

@RestController
@RequestMapping("/favorites/club")
@CrossOrigin(origins = "http://localhost:5173")
public class FavoriteClubController {

    private final FavoriteClubService favoriteClubService;

    public FavoriteClubController(FavoriteClubService favoriteClubService) {
        this.favoriteClubService = favoriteClubService;
    }

    @PostMapping
    public String addFavorite(@RequestBody FavoriteClubDTO club, Principal principal) {
        return favoriteClubService.addFavorite(principal.getName(), club);
    }

    @GetMapping
    public List<FavoriteClubDTO> getFavorites(Principal principal) {
        return favoriteClubService.getFavorites(principal.getName());
    }

    @DeleteMapping("/{teamName}")
    public String removeFavorite(@PathVariable String teamName, Principal principal) {
        return favoriteClubService.removeFavorite(principal.getName(), teamName);
    }
}