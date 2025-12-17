package com.bibliotecadehogwarts.gestorDeBiblioteca.controller;

import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.LibroDTO;
import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.LibroRequestDTO;
import com.bibliotecadehogwarts.gestorDeBiblioteca.mapper.LibroMapper;
import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Libro;
import com.bibliotecadehogwarts.gestorDeBiblioteca.service.LibroService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;
    private final LibroMapper libroMapper;

    public LibroController(LibroService libroService, LibroMapper libroMapper) {
        this.libroService = libroService;
        this.libroMapper = libroMapper;
    }

    @GetMapping
    public ResponseEntity<List<LibroDTO>> listarLibros() {
        List<Libro> libros = libroService.getAllLibros();
        List<LibroDTO> respuesta = libros.stream()
                .map(libroMapper::libroToLibroDTO)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDTO> obtenerPorId(@PathVariable Long id) {
        Libro libro = libroService.getLibroById(id);
        return libro != null
                ? ResponseEntity.ok(libroMapper.libroToLibroDTO(libro))
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<LibroDTO> crearLibro(
            @Valid @RequestBody LibroRequestDTO dto) {

        Libro nuevo = libroService.createLibroDesdeDTO(dto);
        LibroDTO respuesta = libroMapper.libroToLibroDTO(nuevo);
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroDTO> actualizarLibro(@PathVariable Long id, @RequestBody LibroRequestDTO dto) {
        Libro actualizado = libroService.updateLibro(id, dto);
        return actualizado != null
                ? ResponseEntity.ok(libroMapper.libroToLibroDTO(actualizado))
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        boolean eliminado = libroService.deleteLibro(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
