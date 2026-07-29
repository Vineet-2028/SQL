import { useEffect, useState } from "react";

function useFavorites() {
  const [favoritePlayers, setFavoritePlayers] = useState([]);
  const [favoriteClubs, setFavoriteClubs] = useState([]);

  function getToken() {
    return localStorage.getItem("token");
  }

  function openLogin() {
    alert("Please login first to add favourites.");
    window.dispatchEvent(new Event("open-auth-modal"));
  }

  function authHeaders() {
    const token = getToken();

    return {
      "Content-Type": "application/json",
      Authorization: `Bearer ${token}`,
    };
  }

  async function loadFavorites() {
    const token = getToken();

    if (!token) {
      setFavoritePlayers([]);
      setFavoriteClubs([]);
      return;
    }

    try {
      const playerRes = await fetch("http://localhost:8080/favorites/player", {
        method: "GET",
        headers: authHeaders(),
      });

      if (playerRes.ok) {
        const playerFavs = await playerRes.json();

        const players = await Promise.all(
          playerFavs.map(async (fav) => {
            const res = await fetch(
              `http://localhost:8080/player/profile/${fav.player_id}`
            );

            if (!res.ok) return null;

            const data = await res.json();
            return data.player;
          })
        );

        setFavoritePlayers(players.filter(Boolean));
      }

      const clubRes = await fetch("http://localhost:8080/favorites/club", {
        method: "GET",
        headers: authHeaders(),
      });

      if (clubRes.ok) {
        const clubs = await clubRes.json();
        setFavoriteClubs(clubs);
      }
    } catch (err) {
      console.log("Load favorites error:", err);
    }
  }

  useEffect(() => {
    loadFavorites();

    window.addEventListener("auth-changed", loadFavorites);

    return () => {
      window.removeEventListener("auth-changed", loadFavorites);
    };
  }, []);

  async function addPlayerToFavorites(player) {
    const token = getToken();

    if (!token) {
      openLogin();
      return;
    }

    try {
      const res = await fetch(
        `http://localhost:8080/favorites/player/${player.player_id}`,
        {
          method: "POST",
          headers: authHeaders(),
        }
      );

      const text = await res.text();

      if (!res.ok) {
        alert("Could not add player favourite. Check backend.");
        console.log(text);
        return;
      }

      alert(text || "Player added to favourites");
      await loadFavorites();
    } catch (err) {
      console.log("Add player favorite error:", err);
      alert("Backend not reachable.");
    }
  }

  async function addClubToFavorites(club) {
    const token = getToken();

    if (!token) {
      openLogin();
      return;
    }

    try {
      const res = await fetch("http://localhost:8080/favorites/club", {
        method: "POST",
        headers: authHeaders(),
        body: JSON.stringify({
          teamName: club.teamName,
          leagueName: club.leagueName,
          place: club.place,
          points: club.points,
          wins: club.wins,
          goalDifference: club.goalDifference,
          seasonYear: club.seasonYear,
        }),
      });

      const text = await res.text();

      if (!res.ok) {
        alert("Could not add club favourite. Check backend.");
        console.log(text);
        return;
      }

      alert(text || "Club added to favourites");
      await loadFavorites();
    } catch (err) {
      console.log("Add club favorite error:", err);
      alert("Backend not reachable.");
    }
  }

  async function removePlayerFavorite(id) {
    const token = getToken();

    if (!token) {
      openLogin();
      return;
    }

    const res = await fetch(`http://localhost:8080/favorites/player/${id}`, {
      method: "DELETE",
      headers: authHeaders(),
    });

    if (res.ok) {
      await loadFavorites();
    }
  }

  async function removeClubFavorite(name) {
    const token = getToken();

    if (!token) {
      openLogin();
      return;
    }

    const res = await fetch(
      `http://localhost:8080/favorites/club/${encodeURIComponent(name)}`,
      {
        method: "DELETE",
        headers: authHeaders(),
      }
    );

    if (res.ok) {
      await loadFavorites();
    }
  }

  function isPlayerFavorite(id) {
    return favoritePlayers.some((p) => p.player_id === id);
  }

  function isClubFavorite(name) {
    return favoriteClubs.some((c) => c.teamName === name);
  }

  return {
    favoritePlayers,
    favoriteClubs,
    addPlayerToFavorites,
    addClubToFavorites,
    removePlayerFavorite,
    removeClubFavorite,
    isPlayerFavorite,
    isClubFavorite,
  };
}

export default useFavorites;