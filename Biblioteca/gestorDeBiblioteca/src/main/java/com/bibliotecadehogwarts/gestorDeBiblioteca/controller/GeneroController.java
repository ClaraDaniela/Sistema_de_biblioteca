package com.bibliotecadehogwarts.gestorDeBiblioteca.controller;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Genero;
import com.bibliotecadehogwarts.gestorDeBiblioteca.service.GeneroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

@RequestMapping("api/generos")
public class GeneroController {
    private final GeneroService generoService;

    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @GetMapping
    public List<Genero> getAllGeneros() {
        return generoService.getAllGeneros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> getGeneroById(@PathVariable Long id) {
        Genero genero = generoService.getGeneroById(id);
        return genero != null ? ResponseEntity.ok(genero) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Genero crearteGenero(@RequestBody Genero genero) {
        return generoService.createGenero(genero);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genero> updateGenero(@PathVariable Long id, @RequestBody Genero genero) {
        Genero actualizado = generoService.updateGenero(id, genero);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenero(@PathVariable Long id) {
        boolean eliminado = generoService.deleteGenero(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
