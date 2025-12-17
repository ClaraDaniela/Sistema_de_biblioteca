package com.bibliotecadehogwarts.gestorDeBiblioteca.dto;

import jakarta.validation.constraints.NotNull;

public class UsuarioRequestDTO {

    @NotNull(message = "El campo disponible es obligatorio")
    private String username;

    @NotNull(message = "El campo disponible es obligatorio")
    private String password;

    private Long rolUsuario;

    public Long getRolUsuario() {
        return rolUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRolUsusario() {
        return rolUsuario;
    }

    public void setRolUsuario(Long rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

}