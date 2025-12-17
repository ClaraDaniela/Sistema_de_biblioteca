import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import PrestamoModal from "./PrestamoModal";
import "../styles/FlechaInicio.css";
import "../styles/Tabla.css";

function Prestamos() {
  const [prestamos, setPrestamos] = useState([]);
  const [prestamoSeleccionado, setPrestamoSeleccionado] = useState(null);
  const [modalAbierto, setModalAbierto] = useState(false);

  const cargarPrestamos = () => {
    fetch("http://localhost:8080/api/prestamos")
      .then(res => res.json())
      .then(setPrestamos);
  };

  useEffect(() => {
    cargarPrestamos();
  }, []);

  const eliminarPrestamo = (id) => {
    if (!window.confirm("¿Eliminar préstamo?")) return;

    setPrestamos(prev => prev.filter(p => p.id !== id));
  };
  const guardarPrestamo = async (prestamo) => {
    try {
      const url = prestamoSeleccionado
        ? `http://localhost:8080/api/prestamos/${prestamoSeleccionado.id}`
        : "http://localhost:8080/api/prestamos";

      const method = prestamoSeleccionado ? "PUT" : "POST";

      const res = await fetch(url, {
        method,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(prestamo)
      });

      if (!res.ok) {
        const text = await res.text();
        throw new Error(text || "Error en la carga");
      }

      cargarPrestamos();
      setModalAbierto(false);
      setPrestamoSeleccionado(null);
    } catch (err) {
      alert("No se pudo guardar el préstamo: " + err.message);
    }
  };


  return (
    <>
      <div className="volver-inicio">
        <Link to="/dashboard" title="Volver al inicio">⬆</Link>
      </div>

      <h1 className="titulito">Préstamos</h1>

      <button onClick={() => setModalAbierto(true)}>Nuevo Préstamo</button>

      <table className="tabla">
        <thead>
          <tr>
            <th>Libro</th>
            <th>Lector</th>
            <th>Fecha préstamo</th>
            <th>Fecha estimada devolución</th>
            <th>Fecha devolución real</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {prestamos.map(p => (
            <tr key={p.id}>
              <td>{p.libro}</td>
              <td>{p.lector} {p.lector?.apellido}</td>
              <td>{p.fechaPrestamo}</td>
              <td>{p.fechaEstimadaDevolucion}</td>
              <td>{p.fechaDevolucionReal || "-"}</td>
              <td>
                <button onClick={() => { setPrestamoSeleccionado(p); setModalAbierto(true); }}>
                  Editar
                </button>
                <button onClick={() => eliminarPrestamo(p.id)}>
                  Eliminar
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      <PrestamoModal
        abierto={modalAbierto}
        prestamo={prestamoSeleccionado}
        onClose={() => { setModalAbierto(false); setPrestamoSeleccionado(null); }}
        onGuardar={guardarPrestamo}
      />
    </>
  );
}

export default Prestamos;

