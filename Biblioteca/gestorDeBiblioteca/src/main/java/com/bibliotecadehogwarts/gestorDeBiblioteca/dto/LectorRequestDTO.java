package com.bibliotecadehogwarts.gestorDeBiblioteca.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LectorRequestDTO {

    @NotBlank(message = "El título no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El título no puede estar vacío")
    private String apellido;

    @Email
    private String email;

    @NotNull(message = "El campo disponible es obligatorio")
    private Integer tipo;

    @NotNull(message = "El campo disponible es obligatorio")
    private Integer casa;

    private Boolean bloqueado;

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

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public Integer getCasa() {
        return casa;
    }

    public void setCasa(Integer casa) {
        this.casa = casa;
    }
}
