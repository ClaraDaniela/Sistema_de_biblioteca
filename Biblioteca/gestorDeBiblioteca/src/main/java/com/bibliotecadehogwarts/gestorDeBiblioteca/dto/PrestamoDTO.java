package com.bibliotecadehogwarts.gestorDeBiblioteca.dto;

import java.time.LocalDate;

public class PrestamoDTO {
    private Long id;
    private String libro;
    private String lector;
    private LocalDate fechaPrestamo;
    private LocalDate fechaEstimadaDevolucion;
    private LocalDate fechaDevolucionReal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getLector() {
        return lector;
    }

    public void setLector(String lector) {
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
