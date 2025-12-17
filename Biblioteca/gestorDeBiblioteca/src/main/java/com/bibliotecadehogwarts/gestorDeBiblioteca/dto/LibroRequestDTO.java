package com.bibliotecadehogwarts.gestorDeBiblioteca.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LibroRequestDTO {

    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;

    @Size(max = 20, message = "El ISBN no puede tener más de 20 caracteres")
    private String isbn;

    private Integer anioPublicacion;

    @NotNull(message = "El campo disponible es obligatorio")
    private Boolean disponible;

    @NotNull(message = "El ID del género es obligatorio")
    private Long genero;

    private Boolean activo;

    private String imagen;

    @NotNull(message = "El nivel de acceso es obligatorio")
    private Integer nivelAcceso;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Long getGenero() {
        return genero;
    }

    public void setGenero(Long genero) {
        this.genero = genero;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(Integer nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

}
