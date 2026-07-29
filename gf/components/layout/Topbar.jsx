function Topbar({ setShowFavorites }) {
  function openFavorites() {
    const token = localStorage.getItem("token");

    if (!token) {
      alert("Please login first to view favourites.");
      window.dispatchEvent(new Event("open-auth-modal"));
      return;
    }

    setShowFavorites(true);
  }

  return (
    <div className="topbar">
      <button className="icon-btn">🌙</button>

      <button className="fav-btn" onClick={openFavorites}>
        ⭐ My Favorites
      </button>
    </div>
  );
}

export default Topbar;