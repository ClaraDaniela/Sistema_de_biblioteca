package com.bibliotecadehogwarts.gestorDeBiblioteca.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "multa")
public class Multa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lector_id", nullable = false)
    private Lector lector;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "prestamo_id", nullable = false)
    private Prestamo prestamo;

    @Column(name = "dias_atraso", nullable = false)
    private Integer diasAtraso;

    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "fecha_multa", nullable = false)
    private LocalDate fechaMulta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Integer getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(Integer diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDate getFechaMulta() {
        return fechaMulta;
    }

    public void setFechaMulta(LocalDate fechaMulta) {
        this.fechaMulta = fechaMulta;
    }

}