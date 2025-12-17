package com.bibliotecadehogwarts.gestorDeBiblioteca.service;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Prestamo;
import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Lector;
import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Libro;
import com.bibliotecadehogwarts.gestorDeBiblioteca.repository.IPrestamoRepository;
import com.bibliotecadehogwarts.gestorDeBiblioteca.repository.ILibroRepository;
import com.bibliotecadehogwarts.gestorDeBiblioteca.repository.ILectorRepository;
import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.PrestamoRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {

    private final IPrestamoRepository prestamoRepo;
    private final ILibroRepository libroRepo;
    private final ILectorRepository lectorRepo;
    private final MultaService multaService;

    public PrestamoService(
            IPrestamoRepository prestamoRepo,
            ILibroRepository libroRepo,
            ILectorRepository lectorRepo,
            MultaService multaService) {

        this.prestamoRepo = prestamoRepo;
        this.libroRepo = libroRepo;
        this.lectorRepo = lectorRepo;
        this.multaService = multaService;
    }

    public List<Prestamo> getAllPrestamos() {
        return prestamoRepo.findAll();
    }

    public Prestamo getPrestamoById(Long id) {
        return prestamoRepo.findById(id).orElse(null);
    }

    public Prestamo createPrestamo(PrestamoRequestDTO dto) {

        Libro libro = libroRepo.findById(dto.getLibroId())
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        Lector lector = lectorRepo.findById(dto.getLectorId())
                .orElseThrow(() -> new RuntimeException("Lector no encontrado"));

        validarAccesoLibro(lector, libro);

        if (!libro.getDisponible()) {
            throw new RuntimeException("El libro ya está prestado");
        }

        Prestamo p = new Prestamo();
        p.setLibro(libro);
        p.setLector(lector);
        p.setFechaPrestamo(dto.getFechaPrestamo());
        p.setFechaEstimadaDevolucion(dto.getFechaEstimadaDevolucion());
        p.setFechaDevolucionReal(dto.getFechaDevolucionReal());

        libro.setDisponible(false);
        libroRepo.save(libro);

        return prestamoRepo.save(p);
    }

    public Prestamo updatePrestamo(Long id, PrestamoRequestDTO dto) {

        Prestamo p = prestamoRepo.findById(id).orElse(null);
        if (p == null)
            return null;

        boolean seDevuelveAhora = p.getFechaDevolucionReal() == null &&
                dto.getFechaDevolucionReal() != null;

        if (dto.getLibroId() != null) {
            Libro libro = libroRepo.findById(dto.getLibroId())
                    .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
            p.setLibro(libro);
        }

        if (dto.getLectorId() != null) {
            Lector lector = lectorRepo.findById(dto.getLectorId())
                    .orElseThrow(() -> new RuntimeException("Lector no encontrado"));
            p.setLector(lector);
        }

        if (dto.getFechaPrestamo() != null)
            p.setFechaPrestamo(dto.getFechaPrestamo());

        if (dto.getFechaEstimadaDevolucion() != null)
            p.setFechaEstimadaDevolucion(dto.getFechaEstimadaDevolucion());

        if (dto.getFechaDevolucionReal() != null)
            p.setFechaDevolucionReal(dto.getFechaDevolucionReal());

        Prestamo guardado = prestamoRepo.save(p);

        // Si se devuelve ahora, marcar libro disponible y calcular multa
        if (seDevuelveAhora) {
            Libro libro = guardado.getLibro();
            libro.setDisponible(true);
            libroRepo.save(libro);

            multaService.calcularMulta(guardado);
        }

        return guardado;
    }

    // BORRADO LÓGICO
    public boolean deletePrestamo(Long id) {
        return prestamoRepo.existsById(id);
    }

    private void validarAccesoLibro(Lector lector, Libro libro) {
        String nivel = libro.getNivelAcceso().getTipo();
        String tipo = lector.getTipo().getTipo();

        if ("COMUN".equalsIgnoreCase(nivel)) {
            return;
        }

        if ("RESTRINGIDO".equalsIgnoreCase(nivel)) {
            if (!"PROFESOR".equalsIgnoreCase(tipo) && !"ALUMNO_AVANZADO".equalsIgnoreCase(tipo)) {
                throw new RuntimeException("No tiene permiso para tomar un libro restringido");
            }
        }

        if ("PROHIBIDO".equalsIgnoreCase(nivel)) {
            if (!"PROFESOR".equalsIgnoreCase(tipo)) {
                throw new RuntimeException("No tiene permiso para tomar un libro prohibido");
            }
        }
    }

}
