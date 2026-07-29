import { useState } from "react";

function AuthModal({ setAuthOpen, setUser }) {
  const [mode, setMode] = useState("login");
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  async function handleSubmit(e) {
    e.preventDefault();

    const url =
      mode === "login"
        ? "http://localhost:8080/auth/login"
        : "http://localhost:8080/auth/register";

    const body =
      mode === "login"
        ? { email, password }
        : { name, email, password };

    const res = await fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(body),
    });

    if (!res.ok) {
      alert("Something went wrong");
      return;
    }

    if (mode === "register") {
      alert("Registered successfully. Now login.");
      setMode("login");
      return;
    }

    const data = await res.json();

    localStorage.setItem("token", data.token);
    localStorage.setItem("email", data.email);
    localStorage.setItem("role", data.role);

    setUser({
      email: data.email,
      role: data.role,
    });

    window.dispatchEvent(new Event("auth-changed"));

    setAuthOpen(false);
  }

  return (
    <div className="player-modal">
      <div className="auth-modal-box">
        <button className="modal-close" onClick={() => setAuthOpen(false)}>
          ×
        </button>

        <h2>{mode === "login" ? "Login to FootBuzz" : "Create Account"}</h2>

        <form onSubmit={handleSubmit} className="auth-form">
          {mode === "register" && (
            <input
              placeholder="Name"
              value={name}
              onChange={(e) => setName(e.target.value)}
            />
          )}

          <input
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />

          <input
            placeholder="Password"
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />

          <button type="submit" className="fav-btn">
            {mode === "login" ? "Login" : "Register"}
          </button>
        </form>

        <p className="auth-switch">
          {mode === "login" ? "New user?" : "Already have account?"}

          <button
            onClick={() => setMode(mode === "login" ? "register" : "login")}
          >
            {mode === "login" ? " Register" : " Login"}
          </button>
        </p>
      </div>
    </div>
  );
}

export default AuthModal;