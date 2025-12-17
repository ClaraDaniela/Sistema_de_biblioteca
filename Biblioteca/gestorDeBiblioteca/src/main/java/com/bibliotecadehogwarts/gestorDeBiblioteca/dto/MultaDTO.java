package com.bibliotecadehogwarts.gestorDeBiblioteca.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MultaDTO {
    private Long id;
    private String lector;
    private String prestamo;
    private Integer diasAtraso;
    private BigDecimal monto;
    private LocalDate fechaMulta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLector() {
        return lector;
    }

    public void setLector(String lector) {
        this.lector = lector;
    }

    public String getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(String prestamo) {
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
