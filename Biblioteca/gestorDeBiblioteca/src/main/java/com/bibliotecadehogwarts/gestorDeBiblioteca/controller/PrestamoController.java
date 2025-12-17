package com.bibliotecadehogwarts.gestorDeBiblioteca.controller;

import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.PrestamoRequestDTO;
import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.PrestamoDTO;
import com.bibliotecadehogwarts.gestorDeBiblioteca.mapper.PrestamoMapper;
import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Prestamo;
import com.bibliotecadehogwarts.gestorDeBiblioteca.service.MultaService;
import com.bibliotecadehogwarts.gestorDeBiblioteca.service.PrestamoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
@CrossOrigin(origins = "http://localhost:5173")
public class PrestamoController {

    private final PrestamoService prestamoService;
    private final PrestamoMapper prestamoMapper;
    private final MultaService multaService;

    public PrestamoController(PrestamoService prestamoService,
            PrestamoMapper prestamoMapper, MultaService multaService) {
        this.prestamoService = prestamoService;
        this.prestamoMapper = prestamoMapper;
        this.multaService = multaService;
    }

    @GetMapping
    public List<PrestamoDTO> getAllPrestamos() {
        return prestamoMapper.toDtoList(prestamoService.getAllPrestamos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestamoDTO> getPrestamoById(@PathVariable Long id) {
        Prestamo prestamo = prestamoService.getPrestamoById(id);
        if (prestamo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prestamoMapper.toDto(prestamo));
    }

    @PostMapping
    public ResponseEntity<PrestamoDTO> createPrestamo(@RequestBody PrestamoRequestDTO dto) {
        Prestamo prestamo = prestamoService.createPrestamo(dto);
        return ResponseEntity.ok(prestamoMapper.toDto(prestamo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrestamoDTO> updatePrestamo(@PathVariable Long id,
            @RequestBody PrestamoRequestDTO dto) {

        Prestamo actualizado = prestamoService.updatePrestamo(id, dto);
        return actualizado != null
                ? ResponseEntity.ok(prestamoMapper.toDto(actualizado))
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestamo(@PathVariable Long id) {
        prestamoService.deletePrestamo(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/calcular-multas")
    public ResponseEntity<Void> calcularMultas() {
        multaService.calcularTodasLasMultas(prestamoService.getAllPrestamos());
        return ResponseEntity.ok().build();
    }
}
