function Sidebar({ activePage, setActivePage }) {
  return (
    <aside className="sidebar">
      <div>
        <div className="logo">
          ⚽ Foot<span>Buzz</span>
        </div>

        <nav>
          <p
            className={activePage === "players" ? "active" : ""}
            onClick={() => setActivePage("players")}
          >
            Players
          </p>

          <p
            className={activePage === "clubs" ? "active" : ""}
            onClick={() => setActivePage("clubs")}
          >
            Clubs
          </p>

          <p>Competitions</p>
          <p>Transfers</p>
          <p>Stats</p>
          <p>Favorites</p>
        </nav>
      </div>

      <div className="side-card">
        <div className="ball">⚽</div>
        <h3>Live the game.</h3>
        <h3>Love the data.</h3>
        <span>FootBuzz</span>
      </div>
    </aside>
  );
}

export default Sidebar;