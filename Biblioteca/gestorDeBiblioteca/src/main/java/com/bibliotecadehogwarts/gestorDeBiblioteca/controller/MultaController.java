package com.bibliotecadehogwarts.gestorDeBiblioteca.controller;

import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.MultaDTO;
import com.bibliotecadehogwarts.gestorDeBiblioteca.mapper.MultaMapper;
import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Multa;
import com.bibliotecadehogwarts.gestorDeBiblioteca.service.MultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/multas")
public class MultaController {

    private final MultaService multaService;
    private final MultaMapper multaMapper;

    public MultaController(MultaService multaService, MultaMapper multaMapper) {
        this.multaService = multaService;
        this.multaMapper = multaMapper;
    }

    @GetMapping
    public List<MultaDTO> getAllMultas() {
        return multaMapper.multaToMultaDTOList(multaService.getAllMultas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MultaDTO> getMultaById(@PathVariable Long id) {
        Multa multa = multaService.getMultaById(id);
        if (multa == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(multaMapper.multaToMultaDTO(multa));
    }
}
