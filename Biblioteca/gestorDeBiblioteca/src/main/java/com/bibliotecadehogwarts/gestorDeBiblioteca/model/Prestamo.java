package com.bibliotecadehogwarts.gestorDeBiblioteca.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestamo")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "libro_id", nullable = false)
    private Libro libro;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lector_id", nullable = false)
    private Lector lector;

    @Column(name = "fecha_prestamo", nullable = false)
    private LocalDate fechaPrestamo;

    @Column(name = "fecha_estimada_devolucion", nullable = false)
    private LocalDate fechaEstimadaDevolucion;

    @Column(name = "fecha_devolucion_real")
    private LocalDate fechaDevolucionReal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaEstimadaDevolucion() {
        return fechaEstimadaDevolucion;
    }

    public void setFechaEstimadaDevolucion(LocalDate fechaEstimadaDevolucion) {
        this.fechaEstimadaDevolucion = fechaEstimadaDevolucion;
    }

    public LocalDate getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public void setFechaDevolucionReal(LocalDate fechaDevolucionReal) {
        this.fechaDevolucionReal = fechaDevolucionReal;
    }

}