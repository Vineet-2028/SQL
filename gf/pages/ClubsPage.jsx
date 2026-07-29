import { useEffect, useState } from "react";

import Topbar from "../components/layout/Topbar";
import ClubCard from "../components/club/ClubCard";
import ClubModal from "../components/club/ClubModal";
import PlayerModal from "../components/PlayerModal";
import FavoritesModal from "../components/favorites/FavoritesModal";
import useFavorites from "../hooks/useFavorites";

import { getPlayerProfile } from "../services/playerService";

import {
  getLeagueTables,
  getClubTable,
  getClubMatches,
  getClubGoalLeaders,
  getClubAssistLeaders,
  getClubDiscipline,
  getClubPlayers,
} from "../services/clubService";

function ClubsPage() {
  const [clubs, setClubs] = useState([]);
  const [clubSearch, setClubSearch] = useState("");
  const [selectedClub, setSelectedClub] = useState(null);
  const [clubData, setClubData] = useState(null);
  const [clubTab, setClubTab] = useState("overview");

  const [selectedProfile, setSelectedProfile] = useState(null);
  const [activeTab, setActiveTab] = useState("info");

  const [showFavorites, setShowFavorites] = useState(false);
  const [favoriteTab, setFavoriteTab] = useState("clubs");

  const {
    favoritePlayers,
    favoriteClubs,
    addPlayerToFavorites,
    addClubToFavorites,
    removePlayerFavorite,
    removeClubFavorite,
    isPlayerFavorite,
    isClubFavorite,
  } = useFavorites();

  useEffect(() => {
    fetchClubs();
  }, []);

  const buildLatestClubs = (data) => {
    const latestClubs = {};

    data.forEach((club) => {
      if (
        !latestClubs[club.teamName] ||
        club.seasonYear > latestClubs[club.teamName].seasonYear
      ) {
        latestClubs[club.teamName] = club;
      }
    });

    return Object.values(latestClubs);
  };

  const fetchClubs = () => {
    getLeagueTables()
      .then((res) => {
        setClubs(buildLatestClubs(res.data));
      })
      .catch((err) => console.log(err));
  };

  const searchClubs = () => {
    if (clubSearch.trim() === "") {
      fetchClubs();
      return;
    }

    getClubTable(clubSearch)
      .then((res) => {
        setClubs(buildLatestClubs(res.data));
      })
      .catch((err) => {
        console.log(err);
        setClubs([]);
      });
  };

  const clearClubSearch = () => {
    setClubSearch("");
    fetchClubs();
  };

  const openClubDetails = (club) => {
    setSelectedClub(club);
    setClubTab("overview");
    setClubData(null);

    Promise.all([
      getClubTable(club.teamName),
      getClubMatches(club.teamName),
      getClubGoalLeaders(club.teamName),
      getClubAssistLeaders(club.teamName),
      getClubDiscipline(club.teamName),
      getClubPlayers(club.teamName),
    ])
      .then(([tables, matches, goals, assists, discipline, players]) => {
        setClubData({
          tables: tables.data || [],
          matches: matches.data || [],
          goals: goals.data || [],
          assists: assists.data || [],
          discipline: discipline.data || [],
          players: players.data || [],
        });
      })
      .catch((err) => console.log(err));
  };

  const closeClubDetails = () => {
    setSelectedClub(null);
    setClubData(null);
    setClubTab("overview");
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

  const getLatest = (arr) => {
    if (!arr || arr.length === 0) return null;
    return [...arr].sort((a, b) => b.seasonYear - a.seasonYear)[0];
  };

  return (
    <main className="main">
      <Topbar setShowFavorites={setShowFavorites} />

      <section className="hero">
        <h1>
          Explore <span>Elite</span> Clubs
        </h1>

        <p>Search clubs and view standings, matches, leaders and discipline.</p>

        <div className="club-search-box">
          <input
            value={clubSearch}
            onChange={(e) => setClubSearch(e.target.value)}
            placeholder="Search club like Arsenal, Liverpool, Barcelona..."
            onKeyDown={(e) => {
              if (e.key === "Enter") {
                searchClubs();
              }
            }}
          />

          <button onClick={searchClubs}>Search</button>

          <button onClick={clearClubSearch} className="clear">
            Clear
          </button>
        </div>
      </section>

      <section className="club-grid">
        {clubs.map((club, index) => (
          <ClubCard
            key={`${club.teamName}-${index}`}
            club={club}
            index={index}
            openClubDetails={openClubDetails}
            addClubToFavorites={addClubToFavorites}
            isClubFavorite={isClubFavorite}
          />
        ))}
      </section>

      <ClubModal
        selectedClub={selectedClub}
        clubData={clubData}
        clubTab={clubTab}
        setClubTab={setClubTab}
        closeClubDetails={closeClubDetails}
        addClubToFavorites={addClubToFavorites}
        isClubFavorite={isClubFavorite}
        addPlayerToFavorites={addPlayerToFavorites}
        isPlayerFavorite={isPlayerFavorite}
        openPlayerDetails={openPlayerDetails}
        getLatest={getLatest}
      />

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
          openClubDetails={openClubDetails}
          removePlayerFavorite={removePlayerFavorite}
          removeClubFavorite={removeClubFavorite}
        />
      )}
    </main>
  );
}

export default ClubsPage; 