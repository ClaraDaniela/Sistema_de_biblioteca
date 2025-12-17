import "../styles/PrestamoModal.css";
import { useState, useEffect } from "react";

function PrestamoModal({ abierto, onClose, onGuardar, prestamo }) {
    const [form, setForm] = useState({
        libroId: "",
        lectorId: "",
        fechaPrestamo: "",
        fechaEstimadaDevolucion: "",
        fechaDevolucionReal: ""
    });

    const [libros, setLibros] = useState([]);
    const [lectores, setLectores] = useState([]);

    useEffect(() => {
        if (!abierto) return;

        fetch("http://localhost:8080/api/libros")
            .then(res => res.json())
            .then(data => {
                const disponibles = data.filter(l => l.disponible || (prestamo && prestamo.libro?.id === l.id));
                setLibros(disponibles);
            });

        fetch("http://localhost:8080/api/lectores")
            .then(res => res.json())
            .then(setLectores);
    }, [abierto, prestamo]);

    useEffect(() => {
        if (prestamo) {
            setForm({
                libroId: prestamo.libro?.id || "",
                lectorId: prestamo.lector?.id || "",
                fechaPrestamo: prestamo.fechaPrestamo || "",
                fechaEstimadaDevolucion: prestamo.fechaEstimadaDevolucion || "",
                fechaDevolucionReal: prestamo.fechaDevolucionReal || ""
            });
        } else {
            setForm({
                libroId: "",
                lectorId: "",
                fechaPrestamo: "",
                fechaEstimadaDevolucion: "",
                fechaDevolucionReal: ""
            });
        }
    }, [prestamo, abierto]);

    if (!abierto) return null;

    const handleChange = (e) => {
        const { name, value } = e.target;
        setForm({ ...form, [name]: value });
    };
    const handleSubmit = async () => {
        try {
            await onGuardar({
                libroId: Number(form.libroId),
                lectorId: Number(form.lectorId),
                fechaPrestamo: form.fechaPrestamo,
                fechaEstimadaDevolucion: form.fechaEstimadaDevolucion,
                fechaDevolucionReal: form.fechaDevolucionReal || null
            });
            onClose();
        } catch (error) {
            if (error?.message) {
                alert("Error: " + error.message);
            } else {
                alert("Error al guardar el préstamo");
            }
        }
    };

    return (
        <div className="modal-overlay">
            <div className="modal">
                <h2>{prestamo ? "Editar Préstamo" : "Nuevo Préstamo"}</h2>

                <label>Libro</label>
                <select name="libroId" value={form.libroId} onChange={handleChange}>
                    <option value="">Seleccione un libro</option>
                    {libros.map(l => (
                        <option key={l.id} value={l.id}>{l.titulo}</option>
                    ))}
                </select>

                <label>Lector</label>
                <select name="lectorId" value={form.lectorId} onChange={handleChange}>
                    <option value="">Seleccione un lector</option>
                    {lectores.map(l => (
                        <option key={l.id} value={l.id}>{l.nombre} {l.apellido}</option>
                    ))}
                </select>

                <label>Fecha de préstamo</label>
                <input type="date" name="fechaPrestamo" value={form.fechaPrestamo} onChange={handleChange} />

                <label>Fecha estimada de devolución</label>
                <input type="date" name="fechaEstimadaDevolucion" value={form.fechaEstimadaDevolucion} onChange={handleChange} />

                <label>Fecha de devolución real</label>
                <input type="date" name="fechaDevolucionReal" value={form.fechaDevolucionReal} onChange={handleChange} />

                <div className="modal-botones">
                    <button onClick={handleSubmit}>Guardar</button>
                    <button onClick={onClose}>Cancelar</button>
                </div>
            </div>
        </div>
    );
}

export default PrestamoModal;
