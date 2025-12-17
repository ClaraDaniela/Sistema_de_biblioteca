package com.bibliotecadehogwarts.gestorDeBiblioteca.controller;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.NivelAcceso;
import com.bibliotecadehogwarts.gestorDeBiblioteca.service.NivelAccesoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/niveles-acceso")
@CrossOrigin(origins = "http://localhost:5173")
public class NivelAccesoController {

    private final NivelAccesoService service;

    public NivelAccesoController(NivelAccesoService service) {
        this.service = service;
    }

    @GetMapping
    public List<NivelAcceso> getAll() {
        return service.getAllNivelAccesos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NivelAcceso> getById(@PathVariable Integer id) {
        NivelAcceso nivel = service.getByIdNivelAcceso(id);
        return nivel != null
                ? ResponseEntity.ok(nivel)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public NivelAcceso create(@RequestBody NivelAcceso nivelAcceso) {
        return service.createNivelAcceso(nivelAcceso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NivelAcceso> update(
            @PathVariable Integer id,
            @RequestBody NivelAcceso nivelAcceso) {

        NivelAcceso actualizado = service.updateNivelAcceso(id, nivelAcceso);
        return actualizado != null
                ? ResponseEntity.ok(actualizado)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return service.deleteNivelAcceso(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
