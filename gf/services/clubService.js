import axios from "axios";

const BASE = "http://localhost:8080";

export const getLeagueTables = () =>
  axios.get(`${BASE}/league-tables`);

export const getClubTable = (team) =>
  axios.get(`${BASE}/league-tables/team?team=${team}`);

export const getClubMatches = (team) =>
  axios.get(`${BASE}/matches/club?name=${team}`);

export const getClubGoalLeaders = (team) =>
  axios.get(`${BASE}/goal-leaders/team?team=${team}`);

export const getClubAssistLeaders = (team) =>
  axios.get(`${BASE}/assist-leaders/team?team=${team}`);

export const getClubDiscipline = (team) =>
  axios.get(`${BASE}/team-discipline/team?team=${team}`);

export const getClubPlayers = (team) =>
  axios.get(`${BASE}/players/club?club=${team}`);