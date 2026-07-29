// playerService.js
import axios from "axios";

const BASE = "http://localhost:8080";

export const getPlayers = (page = 0) =>
  axios.get(`${BASE}/players?page=${page}&size=12`);

export const searchPlayerByName = (name) =>
  axios.get(`${BASE}/players/search?name=${name}`);

export const searchPlayerByClub = (club) =>
  axios.get(`${BASE}/players/club?club=${club}`);

export const searchPlayerByPosition = (position) =>
  axios.get(`${BASE}/players/position?position=${position}`);

export const getPlayerById = (id) =>
  axios.get(`${BASE}/players/${id}`);

export const getPlayerProfile = (id) =>
  axios.get(`${BASE}/player/profile/${id}`);