package com.bibliotecadehogwarts.gestorDeBiblioteca.service;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Multa;
import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Prestamo;
import com.bibliotecadehogwarts.gestorDeBiblioteca.repository.IMultaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class MultaService {
    private final IMultaRepository multaRepository;

    public MultaService(IMultaRepository multaRepository) {
        this.multaRepository = multaRepository;
    }

    public List<Multa> getAllMultas() {
        return multaRepository.findAll();
    }

    public Multa getMultaById(Long id) {
        return multaRepository.findById(id).orElse(null);
    }

    public void calcularMulta(Prestamo prestamo) {
        if (prestamo.getFechaDevolucionReal() == null)
            return;

        long diasAtraso = ChronoUnit.DAYS.between(
                prestamo.getFechaEstimadaDevolucion(),
                prestamo.getFechaDevolucionReal());

        if (diasAtraso <= 0)
            return; // No hay multa

        BigDecimal monto = BigDecimal.valueOf(diasAtraso * 5);

        Multa multa = multaRepository.findByPrestamoId(prestamo.getId())
                .orElse(new Multa());

        multa.setPrestamo(prestamo);
        multa.setLector(prestamo.getLector());
        multa.setDiasAtraso((int) diasAtraso);
        multa.setMonto(monto);
        multa.setFechaMulta(LocalDate.now());

        multaRepository.save(multa);
    }

    public void calcularTodasLasMultas(List<Prestamo> prestamos) {
        for (Prestamo p : prestamos) {
            calcularMulta(p);
        }
    }
}
