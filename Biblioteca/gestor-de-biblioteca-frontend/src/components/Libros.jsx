import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import Tarjeta from "./Tarjeta.jsx";
import LibroModal from "./LibroModal.jsx";
import "../styles/FlechaInicio.css";

function Libros() {
  const [libros, setLibros] = useState([]);
  const [modalAbierto, setModalAbierto] = useState(false);
  const [libroEditar, setLibroEditar] = useState(null);

  const cargarLibros = async () => {
    try {
      const res = await fetch("http://localhost:8080/api/libros");
      const data = await res.json();
      setLibros(data);
    } catch (error) {
      console.error("Error cargando los libros:", error);
    }
  };

  useEffect(() => {
    cargarLibros();
  }, []);

  const guardarLibro = async (libro) => {
    const metodo = libroEditar ? "PUT" : "POST";
    const url = libroEditar
      ? `http://localhost:8080/api/libros/${libroEditar.id}`
      : "http://localhost:8080/api/libros";

    try {
      await fetch(url, {
        method: metodo,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(libro)
      });
      setModalAbierto(false);
      setLibroEditar(null);
      cargarLibros();
    } catch (error) {
      console.error("Error guardando el libro:", error);
    }
  };

  const eliminarLibroVista = (id) => {
    if (!window.confirm("¿Eliminar este libro de la vista?")) return;
    setLibros(prevLibros => prevLibros.filter(libro => libro.id !== id));
  };

  return (
    <>
      <div className="volver-inicio">
        <Link to="/dashboard" title="Volver al inicio">⬆</Link>
      </div>

      <h1 className="titulito">Biblioteca de Hogwarts</h1>

      <button onClick={() => setModalAbierto(true)}>Nuevo Libro</button>

      <div className="contenedor-tarjetas">
        {libros.map(libro => (
          <Tarjeta
            key={libro.id}
            nombre={libro.titulo}
            area={libro.autores?.join(", ")}
            imagen={libro.imagen}
            botonTexto={libro.disponible ? "Disponible" : "Prestado"}
            onEditar={() => {
              setLibroEditar(libro);
              setModalAbierto(true);
            }}
            onEliminar={() => eliminarLibroVista(libro.id)}
          />
        ))}
      </div>

      <LibroModal
        abierto={modalAbierto}
        libro={libroEditar}
        onClose={() => {
          setModalAbierto(false);
          setLibroEditar(null);
        }}
        onGuardar={guardarLibro}
      />
    </>
  );
}

export default Libros;
