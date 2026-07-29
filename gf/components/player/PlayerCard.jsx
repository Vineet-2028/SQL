function PlayerCard({
  player,
  index,
  openPlayerDetails,
  addPlayerToFavorites,
  isPlayerFavorite,
}) {
  return (
    <div className="card" onClick={() => openPlayerDetails(player.player_id)}>
      <div className="rating">{94 - (index % 8)}</div>

      <button
        className="heart"
        onClick={(e) => {
          e.stopPropagation();
          addPlayerToFavorites(player);
        }}
      >
        {isPlayerFavorite(player.player_id) ? "❤️" : "♡"}
      </button>

      <div className="image-wrap">
        <img src={player.player_image_url} alt={player.player_name} />
      </div>

      <div className="card-body">
        <h2>{player.player_name}</h2>
        <p className="club">{player.current_club_name}</p>

        <div className="meta">
          <span>Age: {player.age}</span>
          <span>{player.foot}</span>
        </div>

        <p className="position">{player.position}</p>
      </div>
    </div>
  );
}

export default PlayerCard;