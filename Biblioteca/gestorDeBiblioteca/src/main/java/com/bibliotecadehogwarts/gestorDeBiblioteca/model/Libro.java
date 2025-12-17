package com.bibliotecadehogwarts.gestorDeBiblioteca.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "isbn", length = 20)
    private String isbn;

    @Column(name = "anio_publicacion")
    private Integer anioPublicacion;

    @ColumnDefault("1")
    @Column(name = "disponible")
    private Boolean disponible;

    @ColumnDefault("1")
    @Column(name = "activo")
    private Boolean activo = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nivel_acceso_id")
    private NivelAcceso nivelAcceso;

    @Column(name = "imagen", nullable = true)
    private String imagen;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LibroAutor> libroAutores = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<LibroAutor> getLibroAutores() {
        return libroAutores;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public NivelAcceso getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(NivelAcceso nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}