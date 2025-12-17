import "../styles/Login.css";
import Polvito from './Polvito';
import { useNavigate, useLocation } from "react-router-dom";
import { useState } from "react";

function Login({ setIsLogged, setUser }) {

  const [usuario, setUsuario] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(null);

  const navigate = useNavigate();
  const location = useLocation();
  const aviso = location.state?.aviso;

  const manejarEnvio = async (e) => {
    e.preventDefault();
    setError(null);

    try {
      const response = await fetch("http://localhost:8080/api/usuarios/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
          username: usuario,
          password: password
        })
      });

      if (!response.ok) {
        throw new Error("Usuario o contraseña incorrectos");
      }

      const data = await response.json();

      setIsLogged(true);
      setUser(data);
      navigate("/dashboard");

    } catch (err) {
      setError(err.message);
    }
  };

  return (
    <>
      <Polvito />
      <div id="formulario-login">
        <h2 className="titulo-login">Bienvenido/a a la Biblioteca de Hogwarts</h2>
        {aviso && <p style={{ color: "red" }}>{aviso}</p>}
        {error && <p style={{ color: "red" }}>{error}</p>}

        <form onSubmit={manejarEnvio}>
          <div>
            <label>Usuario:</label>
            <input
              type="text"
              value={usuario}
              onChange={(e) => setUsuario(e.target.value)}
              required
            />
          </div>

          <div>
            <label>Contraseña:</label>
            <input
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>

          <button type="submit">Ingresar</button>
        </form>
      </div>
    </>
  );
}

export default Login;
