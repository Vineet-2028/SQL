function ClubModal({
  selectedClub,
  clubData,
  clubTab,
  setClubTab,
  closeClubDetails,
  addClubToFavorites,
  isClubFavorite,
  addPlayerToFavorites,
  isPlayerFavorite,
  openPlayerDetails,
  getLatest,
}) {
  if (!selectedClub) return null;

  const latestTable = clubData ? getLatest(clubData.tables) : selectedClub;
  const latestDiscipline = clubData ? getLatest(clubData.discipline) : null;

  return (
    <div className="player-modal">
      <div className="club-modal-box">
        <button className="modal-close" onClick={closeClubDetails}>
          ×
        </button>

        <div className="modal-left">
          <div className="club-big-logo">
            {selectedClub.teamName
              ? selectedClub.teamName.charAt(0).toUpperCase()
              : "C"}
          </div>

          <h1>{selectedClub.teamName}</h1>
          <p>{latestTable?.leagueName || selectedClub.leagueName}</p>
          <span>Season {latestTable?.seasonYear || selectedClub.seasonYear}</span>

          <button
            className="fav-btn modal-fav-btn"
            onClick={() => addClubToFavorites(selectedClub)}
          >
            {isClubFavorite(selectedClub.teamName)
              ? "❤️ Added Favorite"
              : "❤️ Add Favorite"}
          </button>
        </div>

        <div className="modal-right">
          <h2>Club Dashboard</h2>

          <div className="tabs">
            <button
              className={clubTab === "overview" ? "tab active-tab" : "tab"}
              onClick={() => setClubTab("overview")}
            >
              Overview
            </button>

            <button
              className={clubTab === "matches" ? "tab active-tab" : "tab"}
              onClick={() => setClubTab("matches")}
            >
              Matches
            </button>

            <button
              className={clubTab === "leaders" ? "tab active-tab" : "tab"}
              onClick={() => setClubTab("leaders")}
            >
              Leaders
            </button>

            <button
              className={clubTab === "players" ? "tab active-tab" : "tab"}
              onClick={() => setClubTab("players")}
            >
              Players
            </button>
          </div>

          {!clubData && <p className="no-data">Loading club data...</p>}

          {clubData && clubTab === "overview" && (
            <>
              <div className="career-summary">
                <div className="summary-card">
                  <h3>🏆 Points</h3>
                  <p>{latestTable?.points || 0}</p>
                </div>

                <div className="summary-card">
                  <h3>✅ Wins</h3>
                  <p>{latestTable?.wins || 0}</p>
                </div>

                <div className="summary-card">
                  <h3>🤝 Draws</h3>
                  <p>{latestTable?.draws || 0}</p>
                </div>

                <div className="summary-card">
                  <h3>❌ Losses</h3>
                  <p>{latestTable?.losses || 0}</p>
                </div>

                <div className="summary-card">
                  <h3>⚽ Goals For</h3>
                  <p>{latestTable?.goalsFor || 0}</p>
                </div>

                <div className="summary-card">
                  <h3>🛡 Goals Against</h3>
                  <p>{latestTable?.goalsAgainst || 0}</p>
                </div>
              </div>

              <h3 className="section-title">Discipline</h3>

              <div className="detail-grid">
                <div>
                  <b>Yellow Cards</b>
                  <p>{latestDiscipline?.yellowCards || "N/A"}</p>
                </div>

                <div>
                  <b>Red Cards</b>
                  <p>{latestDiscipline?.redCards || "N/A"}</p>
                </div>

                <div>
                  <b>Discipline Points</b>
                  <p>{latestDiscipline?.disciplinePoints || "N/A"}</p>
                </div>

                <div>
                  <b>Matches Played</b>
                  <p>
                    {latestDiscipline?.matchesPlayed ||
                      latestTable?.gamesPlayed ||
                      "N/A"}
                  </p>
                </div>
              </div>
            </>
          )}

          {clubData && clubTab === "matches" && (
            <>
              <h3 className="section-title">Recent Matches</h3>

              <div className="club-match-list">
                {clubData.matches.slice(0, 20).map((match) => (
                  <div className="club-match-row" key={match.matchId}>
                    <div>
                      <b>{match.matchDate || "N/A"}</b>
                      <p>{match.leagueName}</p>
                    </div>

                    <div>
                      <b>
                        {match.homeTeam} vs {match.awayTeam}
                      </b>
                      <p>{match.venue || "Venue N/A"}</p>
                    </div>

                    <div>
                      <b>
                        {match.homeScore} - {match.awayScore}
                      </b>
                      <p>{match.result}</p>
                    </div>
                  </div>
                ))}
              </div>
            </>
          )}

          {clubData && clubTab === "leaders" && (
            <>
              <h3 className="section-title">Top Goal Scorers</h3>

              <div className="leader-list">
                {clubData.goals.slice(0, 8).map((item) => (
                  <div className="leader-row" key={item.goalLeaderId}>
                    <b>#{item.rankNo}</b>
                    <span>{item.playerName}</span>
                    <span>{item.goals} Goals</span>
                    <span>{item.seasonYear}</span>
                  </div>
                ))}
              </div>

              <h3 className="section-title">Top Assist Providers</h3>

              <div className="leader-list">
                {clubData.assists.slice(0, 8).map((item) => (
                  <div className="leader-row" key={item.assistLeaderId}>
                    <b>#{item.rankNo}</b>
                    <span>{item.playerName}</span>
                    <span>{item.assists} Assists</span>
                    <span>{item.seasonYear}</span>
                  </div>
                ))}
              </div>
            </>
          )}

          {clubData && clubTab === "players" && (
            <>
              <h3 className="section-title">Club Players</h3>

              <div className="similar-grid">
                {clubData.players.slice(0, 18).map((player) => (
                  <div
                    className="similar-card"
                    key={player.player_id}
                    onClick={() => openPlayerDetails(player.player_id)}
                  >
                    <img src={player.player_image_url} alt={player.player_name} />
                    <h4>{player.player_name}</h4>
                    <p>{player.position}</p>

                    <button
                      className="fav-small-btn"
                      onClick={(e) => {
                        e.stopPropagation();
                        addPlayerToFavorites(player);
                      }}
                    >
                      {isPlayerFavorite(player.player_id) ? "❤️ Added" : "❤️ Add"}
                    </button>
                  </div>
                ))}
              </div>
            </>
          )}
        </div>
      </div>
    </div>
  );
}

export default ClubModal;