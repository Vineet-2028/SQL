function FavoritesModal({
  favoritePlayers,
  favoriteClubs,
  favoriteTab,
  setFavoriteTab,
  setShowFavorites,
  openPlayerDetails,
  openClubDetails,
  removePlayerFavorite,
  removeClubFavorite,
}) {
  return (
    <div className="player-modal">
      <div className="favorites-modal-box">
        <button className="modal-close" onClick={() => setShowFavorites(false)}>
          ×
        </button>

        <div className="modal-right">
          <h2>⭐ My Favorites</h2>

          <div className="tabs">
            <button
              className={favoriteTab === "players" ? "tab active-tab" : "tab"}
              onClick={() => setFavoriteTab("players")}
            >
              Players ({favoritePlayers.length})
            </button>

            <button
              className={favoriteTab === "clubs" ? "tab active-tab" : "tab"}
              onClick={() => setFavoriteTab("clubs")}
            >
              Clubs ({favoriteClubs.length})
            </button>
          </div>

          {favoriteTab === "players" && favoritePlayers.length === 0 && (
            <p className="no-data">No favorite players added yet.</p>
          )}

          {favoriteTab === "players" && favoritePlayers.length > 0 && (
            <div className="similar-grid">
              {favoritePlayers.map((player) => (
                <div
                  key={player.player_id}
                  className="similar-card"
                  onClick={() => {
                    setShowFavorites(false);
                    openPlayerDetails(player.player_id);
                  }}
                >
                  <img src={player.player_image_url} alt={player.player_name} />
                  <h4>{player.player_name}</h4>
                  <p>{player.position}</p>

                  <button
                    className="fav-small-btn remove"
                    onClick={(e) => {
                      e.stopPropagation();
                      removePlayerFavorite(player.player_id);
                    }}
                  >
                    Remove
                  </button>
                </div>
              ))}
            </div>
          )}

          {favoriteTab === "clubs" && favoriteClubs.length === 0 && (
            <p className="no-data">No favorite clubs added yet.</p>
          )}

          {favoriteTab === "clubs" && favoriteClubs.length > 0 && (
            <div className="favorite-club-grid">
              {favoriteClubs.map((club) => (
                <div
                  key={club.teamName}
                  className="favorite-club-card"
                  onClick={() => {
                    setShowFavorites(false);
                    openClubDetails(club);
                  }}
                >
                  <div className="club-logo small">
                    {club.teamName ? club.teamName.charAt(0).toUpperCase() : "C"}
                  </div>

                  <h4>{club.teamName}</h4>
                  <p>{club.leagueName}</p>

                  <button
                    className="fav-small-btn remove"
                    onClick={(e) => {
                      e.stopPropagation();
                      removeClubFavorite(club.teamName);
                    }}
                  >
                    Remove
                  </button>
                </div>
              ))}
            </div>
          )}
        </div>
      </div>
    </div>
  );
}

export default FavoritesModal;