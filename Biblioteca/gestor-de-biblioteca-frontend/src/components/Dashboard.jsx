import { useState, useEffect, useMemo } from "react";
import { Link, Routes, Route } from "react-router-dom";

import Libros from "./Libros";
import Lectores from "./Lectores";
import Prestamos from "./Prestamos";
import Multas from "./Multas";
import Polvito from "./Polvito";
import TarjetaEstadistica from "./TarjetaEstadistica";
import "../styles/App.css";

function Dashboard({ user }) {

  const handleLogout = () => {
    window.location.href = "/login";
  };

  const [libros, setLibros] = useState([]);
  const [lectores, setLectores] = useState([]);
  const [prestamos, setPrestamos] = useState([]);
  const [multas, setMultas] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/libros")
      .then(res => res.json())
      .then(setLibros);

    fetch("http://localhost:8080/api/lectores")
      .then(res => res.json())
      .then(setLectores);

    fetch("http://localhost:8080/api/prestamos")
      .then(res => res.json())
      .then(setPrestamos);

    fetch("http://localhost:8080/api/multas")
      .then(res => res.json())
      .then(setMultas);
  }, []);


  const lectoresActivos = useMemo(
    () => lectores.filter(l => l.activo === true).length,
    [lectores]
  );

  const prestamosActivos = useMemo(
    () => prestamos.filter(p => p.fechaDevolucionReal === null).length,
    [prestamos]
  );

  const casaMasLectora = useMemo(() => {
    if (!prestamos.length || !lectores.length) return "Sin datos";

    const contador = {};

    prestamos.forEach(p => {
      const lector = lectores.find(l => {
        const nombreCompleto = `${l.nombre} ${l.apellido}`;
        return nombreCompleto === p.lector;
      });

      if (!lector || !lector.casa) return;

      const casa = lector.casa.trim().toUpperCase();
      contador[casa] = (contador[casa] || 0) + 1;
    });

    let casaTop = "Ninguna";
    let max = 0;

    for (const casa in contador) {
      if (contador[casa] > max) {
        max = contador[casa];
        casaTop = casa;
      }
    }

    return casaTop === "Ninguna"
      ? "Sin datos"
      : casaTop.charAt(0) + casaTop.slice(1).toLowerCase();
  }, [prestamos, lectores]);

  return (
    <>
      <Polvito />

      <div className="dashboard">
        <aside className="sidebar">
          <h2>Menú</h2>
          <ul>
            <li><Link to="/dashboard/libros">Lista de libros</Link></li>
            <li><Link to="/dashboard/lectores">Lista de lectores</Link></li>
            <li><Link to="/dashboard/prestamos">Préstamos</Link></li>
            <li><Link to="/dashboard/multas">Multas</Link></li>
          </ul>
        </aside>

        <main className="main-content">
          <header className="dashboard-header">
            <span>Hola, {user?.username}</span>
            <button className="av-login" onClick={handleLogout}>Logout</button>
          </header>

          <section className="dashboard-body">
            <Routes>
              <Route path="libros" element={<Libros />} />
              <Route path="lectores" element={<Lectores />} />
              <Route path="prestamos" element={<Prestamos />} />
              <Route path="multas" element={<Multas />} />

              <Route
                index
                element={
                  <>
                    <h3>Resumen</h3>

                    <div className="contenedor-tarjetas">
                      <TarjetaEstadistica
                        tipo="stat"
                        nombre="Libros Totales"
                        valor={libros.length}
                      />

                      <TarjetaEstadistica
                        tipo="stat"
                        nombre="Lectores Activos"
                        valor={lectoresActivos}
                      />

                      <TarjetaEstadistica
                        tipo="stat"
                        nombre="Préstamos Activos"
                        valor={prestamosActivos}
                      />

                      <TarjetaEstadistica
                        tipo="stat"
                        nombre="Casa más lectora"
                        valor={casaMasLectora}
                      />
                    </div>
                  </>
                }
              />
            </Routes>
          </section>
        </main>
      </div>
    </>
  );
}

export default Dashboard;

