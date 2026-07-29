function ClubCard({
  club,
  openClubDetails,
  addClubToFavorites,
  isClubFavorite,
}) {
  return (
    <div className="club-card" onClick={() => openClubDetails(club)}>
      <button
        className="heart"
        onClick={(e) => {
          e.stopPropagation();
          addClubToFavorites(club);
        }}
      >
        {isClubFavorite(club.teamName) ? "❤️" : "♡"}
      </button>

      <div className="club-rank">#{club.place}</div>

      <div className="club-logo">
        {club.teamName ? club.teamName.charAt(0).toUpperCase() : "C"}
      </div>

      <h2>{club.teamName}</h2>
      <p className="club">{club.leagueName}</p>

      <div className="club-mini">
        <div>
          <b>{club.points}</b>
          <span>PTS</span>
        </div>

        <div>
          <b>{club.wins}</b>
          <span>W</span>
        </div>

        <div>
          <b>{club.goalDifference}</b>
          <span>GD</span>
        </div>
      </div>

      <p className="position">Season {club.seasonYear}</p>
    </div>
  );
}

export default ClubCard;