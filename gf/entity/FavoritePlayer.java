package com.backend.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "favorite_players")
public class FavoritePlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long playerId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public FavoritePlayer() {}

    public FavoritePlayer(Long playerId, User user) {
        this.playerId = playerId;
        this.user = user;
    }

    public Long getId() { return id; }
    public Long getPlayerId() { return playerId; }
    public User getUser() { return user; }

    public void setId(Long id) { this.id = id; }
    public void setPlayerId(Long playerId) { this.playerId = playerId; }
    public void setUser(User user) { this.user = user; }
}