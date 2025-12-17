function Tarjeta({ 
  nombre, 
  area, 
  imagen, 
  botonTexto,
  onEditar,
  onEliminar
}) {
  return (
    <div className="tarjeta">
      <img src={imagen} alt={nombre} className="tarjeta-imagen" />
      <h2>{nombre}</h2>
      <p>{area}</p>

      {botonTexto && <button>{botonTexto}</button>}

      <div className="acciones-tarjeta">
        <button onClick={onEditar}>Editar</button>
        <button onClick={onEliminar}>Eliminar</button>
      </div>
    </div>
  );
}

export default Tarjeta;
