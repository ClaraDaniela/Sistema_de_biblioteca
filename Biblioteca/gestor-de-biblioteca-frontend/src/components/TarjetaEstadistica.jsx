import "../styles/TarjetaEstadistica.css";

function TarjetaEstadistica({ nombre, area, imagen, botonTexto, valor, tipo }) {
  return (
    <div className={`tarjeta ${tipo === "stat" ? "tarjeta-stat" : ""}`}>
      {imagen && (
        <img src={imagen} alt={nombre} className="tarjeta-imagen" />
      )}

      <h2>{nombre}</h2>

      {valor !== undefined ? (
        <p className="stat-valor">{valor}</p>
      ) : (
        <p>{area}</p>
      )}

      {botonTexto && <button>{botonTexto}</button>}
    </div>
  );
}

export default TarjetaEstadistica;
