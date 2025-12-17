package com.bibliotecadehogwarts.gestorDeBiblioteca.controller;

import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.LectorRequestDTO;
import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.LectorDTO;
import com.bibliotecadehogwarts.gestorDeBiblioteca.mapper.LectorMapper;
import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Lector;
import com.bibliotecadehogwarts.gestorDeBiblioteca.service.LectorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lectores")
@CrossOrigin(origins = "http://localhost:5173")
public class LectorController {
    private final LectorService lectorService;
    private final LectorMapper lectorMapper;

    public LectorController(LectorService lectorService, LectorMapper lectorMapper) {
        this.lectorService = lectorService;
        this.lectorMapper = lectorMapper;
    }

    @GetMapping
    public List<LectorDTO> getAllLectores() {
        List<Lector> lectores = lectorService.getAllLectores();
        return lectorMapper.lectorToLectorDTOList(lectores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LectorDTO> getLectorById(@PathVariable Long id) {
        Lector lector = lectorService.getLectorById(id);
        if (lector == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(lectorMapper.lectorToLectorDTO(lector));
    }

    @PostMapping
    public ResponseEntity<LectorDTO> crearLector(@RequestBody LectorRequestDTO dto) {
        Lector lector = lectorService.createLector(dto);
        return ResponseEntity.ok(lectorMapper.lectorToLectorDTO(lector));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LectorDTO> updateLector(@PathVariable Long id, @RequestBody LectorRequestDTO dto) {
        Lector actualizado = lectorService.updateLector(id, dto);
        return actualizado != null
                ? ResponseEntity.ok(lectorMapper.lectorToLectorDTO(actualizado))
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLector(@PathVariable Long id) {
        boolean eliminado = lectorService.deleteLector(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
