import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import "../styles/FlechaInicio.css";
import "../styles/Tabla.css";

function Multas() {
  const [multas, setMultas] = useState([]);

  const cargarMultas = () => {
    fetch("http://localhost:8080/api/multas")
      .then(res => res.json())
      .then(setMultas);
  };

  useEffect(() => {
    cargarMultas();
  }, []);

  const eliminarMulta = (id) => {
    if (!window.confirm("¿Eliminar multa de la vista?")) return;
    setMultas(prev => prev.filter(m => m.id !== id));
  };

  const calcularMultas = () => {
    fetch("http://localhost:8080/api/prestamos/calcular-multas", {
      method: "POST"
    }).then(() => {
      alert("Multas calculadas correctamente");
      cargarMultas();
    });
  };

  return (
    <>
      <div className="volver-inicio">
        <Link to="/dashboard" title="Volver al inicio">⬆</Link>
      </div>

      <h1 className="titulito">Multas</h1>

      <button onClick={calcularMultas}>Cargar Multas</button>

      <table className="tabla">
        <thead>
          <tr>
            <th>Lector</th>
            <th>Prestamo</th>
            <th>Dias de atraso</th>
            <th>Monto</th>
            <th>Fecha de la multa</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {multas.map(m => (
            <tr key={m.id}>
              <td>{m.lector} {m.lector?.apellido}</td>
              <td>{m.prestamo}</td>
              <td>{m.diasAtraso}</td>
              <td>{m.monto}</td>
              <td>{m.fechaMulta}</td>
              <td>
                <button onClick={() => eliminarMulta(m.id)}>Eliminar</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );
}

export default Multas;

