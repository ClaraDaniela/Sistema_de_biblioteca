package com.bibliotecadehogwarts.gestorDeBiblioteca.dto;

public class NivelAccesoDTO {

    private Integer id;
    private String tipo;
    private String descripcion;

    public NivelAccesoDTO() {
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
