package com.bibliotecadehogwarts.gestorDeBiblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lector")
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;
    private Boolean bloqueado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "casa_id")
    private Casa casa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_id")
    private TipoLector tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoLector getTipo() {
        return tipo;
    }

    public void setTipo(TipoLector tipoLector) {
        this.tipo = tipoLector;
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

}