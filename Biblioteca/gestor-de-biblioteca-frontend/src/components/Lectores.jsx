import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import LectorDetalleModal from "./LectorDetalleModal";
import "../styles/FlechaInicio.css";
import "../styles/Tabla.css";

function Lectores() {
  const [lectores, setLectores] = useState([]);
  const [lectorSeleccionado, setLectorSeleccionado] = useState(null);

  const cargarLectores = () => {
    fetch("http://localhost:8080/api/lectores")
      .then(res => res.json())
      .then(setLectores);
  };

  useEffect(() => {
    cargarLectores();
  }, []);

  const eliminarLector = (id) => {
    if (!window.confirm("¿Eliminar lector de la vista?")) return;

    setLectores(prev => prev.filter(l => l.id !== id));
  };

  return (
    <>
      <div className="volver-inicio">
        <Link to="/dashboard" title="Volver al inicio">⬆</Link>
      </div>

      <h1 className="titulito">Lectores</h1>

      <table className="tabla">
        <thead>
          <tr>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Email</th>
            <th>Casa</th>
            <th>Tipo</th>
            <th>Bloqueado</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {lectores.map(l => (
            <tr key={l.id}>
              <td>{l.nombre}</td>
              <td>{l.apellido}</td>
              <td>{l.email}</td>
              <td>{l.casa}</td>
              <td>{l.tipo}</td>
              <td>{l.bloqueado ? "Sí" : "No"}</td>
              <td>
                <button onClick={() => setLectorSeleccionado(l)}>
                  Ver más
                </button>
                <button onClick={() => eliminarLector(l.id)}>
                  Eliminar
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      <LectorDetalleModal
        lector={lectorSeleccionado}
        onClose={() => setLectorSeleccionado(null)}
      />
    </>
  );
}

export default Lectores;

