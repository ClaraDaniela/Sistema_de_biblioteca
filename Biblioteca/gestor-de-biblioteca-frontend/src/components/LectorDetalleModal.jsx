import "../styles/LectorDetalleModal.css";

function LectorDetalleModal({ lector, onClose }) {
  if (!lector) return null;

  return (
    <div className="modal-overlay">
      <div className="modal modal-grande">
        <h2>Detalle del lector</h2>

        <section>
          <h3>Datos personales</h3>
          <p><strong>Nombre:</strong> {lector.nombre}</p>
          <p><strong>DNI:</strong> {lector.dni}</p>
          <p><strong>Tipo:</strong> {lector.tipo}</p>
          <p><strong>Estado:</strong> {lector.activo ? "Activo" : "Bloqueado"}</p>
        </section>

        <section>
          <h3>Libros prestados</h3>
          {lector.librosPrestados?.length > 0 ? (
            <ul>
              {lector.librosPrestados.map(lp => (
                <li key={lp.id}>
                  {lp.titulo} — vence: {lp.fechaVencimiento}
                </li>
              ))}
            </ul>
          ) : (
            <p>No tiene libros prestados</p>
          )}
        </section>

        <section>
          <h3>Multas</h3>
          {lector.multas?.length > 0 ? (
            <ul>
              {lector.multas.map(m => (
                <li key={m.id}>
                  ${m.monto} — {m.motivo}
                </li>
              ))}
            </ul>
          ) : (
            <p>No tiene multas</p>
          )}
        </section>

        <div className="modal-botones">
          <button onClick={onClose}>Cerrar</button>
        </div>
      </div>
    </div>
  );
}

export default LectorDetalleModal;
