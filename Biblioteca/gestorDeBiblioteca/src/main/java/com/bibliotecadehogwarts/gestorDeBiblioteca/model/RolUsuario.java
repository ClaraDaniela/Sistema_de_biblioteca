package com.bibliotecadehogwarts.gestorDeBiblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rol_usuario")
public class RolUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String rol;

    public RolUsuario() {
    }

    public RolUsuario(String rol) {
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
