import "../styles/LibroModal.css";
import { useState, useEffect } from "react";

function LibroModal({ abierto, onClose, onGuardar, libro }) {
  const [form, setForm] = useState({
    titulo: "",
    isbn: "",
    anioPublicacion: "",
    genero: "",
    nivelAcceso: "",
    disponible: true,
    imagen: ""
  });

  const [generos, setGeneros] = useState([]);
  const [niveles, setNiveles] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/generos")
      .then(res => res.json())
      .then(setGeneros);

    fetch("http://localhost:8080/api/niveles-acceso")
      .then(res => res.json())
      .then(setNiveles);
  }, []);

  useEffect(() => {
    if (libro) {
      setForm({
        titulo: libro.titulo || "",
        isbn: libro.isbn || "",
        anioPublicacion: libro.anioPublicacion || "",
        genero: libro.genero || "",
        nivelAcceso: libro.nivelAccesoId || "",
        disponible: libro.disponible ?? true,
        imagen: libro.imagen || ""
      });
    }
  }, [libro]);

  if (!abierto) return null;

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm({ ...form, [name]: value });
  };

  const handleSubmit = () => {
    onGuardar({
      titulo: form.titulo,
      isbn: form.isbn,
      anioPublicacion: Number(form.anioPublicacion),
      genero: Number(form.genero),
      nivelAcceso: Number(form.nivelAcceso),
      disponible: form.disponible === "true" || form.disponible === true,
      imagen: form.imagen
    });
  };

  return (
    <div className="modal-overlay">
      <div className="modal">
        <h2>{libro ? "Editar libro" : "Nuevo libro"}</h2>

        <input
          name="titulo"
          placeholder="Título"
          value={form.titulo}
          onChange={handleChange}
        />

        <input
          name="isbn"
          placeholder="ISBN"
          value={form.isbn}
          onChange={handleChange}
        />

        <input
          name="anioPublicacion"
          placeholder="Año de publicación"
          type="number"
          value={form.anioPublicacion}
          onChange={handleChange}
        />

        <select name="genero" value={form.genero} onChange={handleChange}>
          <option value="">Seleccione un género</option>
          {generos.map(g => (
            <option key={g.id} value={g.id}>
              {g.nombre}
            </option>
          ))}
        </select>

        <select name="nivelAcceso" value={form.nivelAcceso} onChange={handleChange}>
          <option value="">Seleccione nivel de acceso</option>
          {niveles.map(n => (
            <option key={n.id} value={n.id}>
              {n.tipo}
            </option>
          ))}
        </select>

        <select name="disponible" value={form.disponible} onChange={handleChange}>
          <option value={true}>Disponible</option>
          <option value={false}>Prestado</option>
        </select>

        <input
          name="imagen"
          placeholder="URL de imagen"
          value={form.imagen}
          onChange={handleChange}
        />

        <div className="modal-botones">
          <button onClick={handleSubmit}>Guardar</button>
          <button onClick={onClose}>Cancelar</button>
        </div>
      </div>
    </div>
  );
}

export default LibroModal;
