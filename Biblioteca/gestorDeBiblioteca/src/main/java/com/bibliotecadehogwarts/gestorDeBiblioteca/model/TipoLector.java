package com.bibliotecadehogwarts.gestorDeBiblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_lector")
public class TipoLector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipo;

    public TipoLector() {
    }

    public TipoLector(String tipo) {
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
