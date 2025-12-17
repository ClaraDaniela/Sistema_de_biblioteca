package com.bibliotecadehogwarts.gestorDeBiblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "nivel_acceso")
public class NivelAcceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String descripcion;

    public NivelAcceso() {
    }

    public NivelAcceso(String tipo, String descripcion) {
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
