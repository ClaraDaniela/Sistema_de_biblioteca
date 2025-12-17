package com.bibliotecadehogwarts.gestorDeBiblioteca.controller;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Autor;
import com.bibliotecadehogwarts.gestorDeBiblioteca.service.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

@RequestMapping("api/autores")
public class AutorController {
    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> getAllAutores() {
        return autorService.getAllAutores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable Long id) {
        Autor autor = autorService.getAutorById(id);
        return autor != null ? ResponseEntity.ok(autor) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Autor crearteAutor(@RequestBody Autor autor) {
        return autorService.createAutor(autor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable Long id, @RequestBody Autor autor) {
        Autor actualizado = autorService.updateAutor(id, autor);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id) {
        boolean eliminado = autorService.deleteAutor(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
