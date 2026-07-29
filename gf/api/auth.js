export function getToken() {
  return localStorage.getItem("token");
}

export function authHeaders() {
  const token = getToken();

  return {
    "Content-Type": "application/json",
    Authorization: `Bearer ${token}`
  };
}