package com.bibliotecadehogwarts.gestorDeBiblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LibroAutorId implements Serializable {
    private static final long serialVersionUID = 5174322934057535410L;
    @Column(name = "libro_id", nullable = false)
    private Long libroId;

    @Column(name = "autor_id", nullable = false)
    private Long autorId;

    public Long getLibroId() {
        return libroId;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LibroAutorId entity = (LibroAutorId) o;
        return Objects.equals(this.autorId, entity.autorId) &&
                Objects.equals(this.libroId, entity.libroId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autorId, libroId);
    }

}