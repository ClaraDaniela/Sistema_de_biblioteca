package com.bibliotecadehogwarts.gestorDeBiblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libro_autor")
public class LibroAutor {
    @EmbeddedId
    private LibroAutorId id;

    @MapsId("libroId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "libro_id", nullable = false)
    private Libro libro;

    @MapsId("autorId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    public LibroAutorId getId() {
        return id;
    }

    public void setId(LibroAutorId id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

}