import { useEffect, useState } from "react";

import Topbar from "../components/layout/Topbar";
import PlayerCard from "../components/player/PlayerCard";
import PlayerModal from "../components/PlayerModal";
import FavoritesModal from "../components/favorites/FavoritesModal";
import useFavorites from "../hooks/useFavorites";

import {
  getPlayers,
  searchPlayerByName,
  searchPlayerByClub,
  searchPlayerByPosition,
  getPlayerById,
  getPlayerProfile,
} from "../services/playerService";

function PlayersPage({ setActivePage }) {
  const [players, setPlayers] = useState([]);
  const [search, setSearch] = useState("");
  const [searchType, setSearchType] = useState("name");
  const [page, setPage] = useState(0);

  const [selectedProfile, setSelectedProfile] = useState(null);
  const [activeTab, setActiveTab] = useState("info");

  const [showFavorites, setShowFavorites] = useState(false);
  const [favoriteTab, setFavoriteTab] = useState("players");

  const {
    favoritePlayers,
    favoriteClubs,
    addPlayerToFavorites,
    removePlayerFavorite,
    removeClubFavorite,
    isPlayerFavorite,
  } = useFavorites();

  useEffect(() => {
    fetchPlayers(0);
  }, []);

  const fetchPlayers = (pageNumber = 0) => {
    getPlayers(pageNumber)
      .then((res) => {
        setPlayers(res.data.content);
        setPage(pageNumber);
      })
      .catch((err) => console.log(err));
  };

  const searchPlayers = () => {
    if (search.trim() === "") {
      fetchPlayers(0);
      return;
    }

    let request;

    if (searchType === "name") {
      request = searchPlayerByName(search);
    } else if (searchType === "club") {
      request = searchPlayerByClub(search);
    } else if (searchType === "position") {
      request = searchPlayerByPosition(search);
    } else if (searchType === "id") {
      request = getPlayerById(search);
    }

    request
      .then((res) => {
        if (searchType === "id") {
          setPlayers(res.data ? [res.data] : []);
        } else {
          setPlayers(res.data);
        }
      })
      .catch((err) => {
        console.log(err);
        setPlayers([]);
      });
  };

  const clearSearch = () => {
    setSearch("");
    setSearchType("name");
    fetchPlayers(0);
  };

  const openPlayerDetails = (playerId) => {
    setActiveTab("info");

    getPlayerProfile(playerId)
      .then((res) => setSelectedProfile(res.data))
      .catch((err) => console.log(err));
  };

  const closePlayerDetails = () => {
    setSelectedProfile(null);
    setActiveTab("info");
  };

  const getTotal = (arr, field) => {
    if (!arr || arr.length === 0) return 0;
    return arr.reduce((sum, item) => sum + (item[field] || 0), 0);
  };

  const openClubFromFavorites = () => {
    setShowFavorites(false);
    setActivePage("clubs");
  };

  return (
    <main className="main">
      <Topbar setShowFavorites={setShowFavorites} />

      <section className="hero">
        <h1>
          Discover <span>Amazing</span> Players
        </h1>

        <p>Search football profiles by name, ID, club, or position.</p>

        <div className="search-box">
          <select
            value={searchType}
            onChange={(e) => setSearchType(e.target.value)}
          >
            <option value="name">Name</option>
            <option value="id">ID</option>
            <option value="club">Club</option>
            <option value="position">Position</option>
          </select>

          <input
            value={search}
            onChange={(e) => setSearch(e.target.value)}
            placeholder={
              searchType === "id"
                ? "Enter player ID..."
                : `Search by ${searchType}...`
            }
            onKeyDown={(e) => {
              if (e.key === "Enter") {
                searchPlayers();
              }
            }}
          />

          <button onClick={searchPlayers}>Search</button>

          <button onClick={clearSearch} className="clear">
            Clear
          </button>
        </div>
      </section>

      <section className="grid">
        {players.map((player, index) => (
          <PlayerCard
            key={player.player_id}
            player={player}
            index={index}
            openPlayerDetails={openPlayerDetails}
            addPlayerToFavorites={addPlayerToFavorites}
            isPlayerFavorite={isPlayerFavorite}
          />
        ))}
      </section>

      <div className="pagination">
        <button onClick={() => fetchPlayers(Math.max(page - 1, 0))}>
          Prev
        </button>

        <span>Page {page + 1}</span>

        <button onClick={() => fetchPlayers(page + 1)}>Next</button>
      </div>

      <PlayerModal
        selectedProfile={selectedProfile}
        activeTab={activeTab}
        setActiveTab={setActiveTab}
        closePlayerDetails={closePlayerDetails}
        getTotal={getTotal}
        addPlayerToFavorites={addPlayerToFavorites}
        isPlayerFavorite={isPlayerFavorite}
      />

      {showFavorites && (
        <FavoritesModal
          favoritePlayers={favoritePlayers}
          favoriteClubs={favoriteClubs}
          favoriteTab={favoriteTab}
          setFavoriteTab={setFavoriteTab}
          setShowFavorites={setShowFavorites}
          openPlayerDetails={openPlayerDetails}
          openClubDetails={openClubFromFavorites}
          removePlayerFavorite={removePlayerFavorite}
          removeClubFavorite={removeClubFavorite}
        />
      )}
    </main>
  );
}

export default PlayersPage;