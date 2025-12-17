package com.bibliotecadehogwarts.gestorDeBiblioteca.service;

import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.LibroRequestDTO;
import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Genero;
import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Libro;
import com.bibliotecadehogwarts.gestorDeBiblioteca.model.NivelAcceso;
import com.bibliotecadehogwarts.gestorDeBiblioteca.repository.IGeneroRepository;
import com.bibliotecadehogwarts.gestorDeBiblioteca.repository.ILibroRepository;
import com.bibliotecadehogwarts.gestorDeBiblioteca.repository.INivelAccesoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private final ILibroRepository librosRepository;
    private final IGeneroRepository generoRepository;
    private final INivelAccesoRepository nivelAccesoRepository;

    public LibroService(ILibroRepository librosRepository, IGeneroRepository generoRepository,
            INivelAccesoRepository nivelAccesoRepository) {
        this.librosRepository = librosRepository;
        this.generoRepository = generoRepository;
        this.nivelAccesoRepository = nivelAccesoRepository;
    }

    public List<Libro> getAllLibros() {
        return librosRepository.findAll();
    }

    public Libro getLibroById(Long id) {
        return librosRepository.findById(id).orElse(null);
    }

    public Libro createLibro(Libro libro) {
        return librosRepository.save(libro);
    }

    public Libro createLibroDesdeDTO(LibroRequestDTO dto) {

        Genero genero = generoRepository.findById(dto.getGenero())
                .orElseThrow(() -> new IllegalArgumentException("Género no encontrado"));

        NivelAcceso nivelAcceso = nivelAccesoRepository.findById(dto.getNivelAcceso())
                .orElseThrow(() -> new IllegalArgumentException("Nivel de acceso no encontrado"));

        Libro libro = new Libro();
        libro.setTitulo(dto.getTitulo());
        libro.setIsbn(dto.getIsbn());
        libro.setAnioPublicacion(dto.getAnioPublicacion());
        libro.setDisponible(dto.getDisponible() != null ? dto.getDisponible() : true);
        libro.setActivo(dto.getActivo() != null ? dto.getActivo() : true);
        libro.setGenero(genero);
        libro.setNivelAcceso(nivelAcceso);
        libro.setImagen(dto.getImagen());

        return librosRepository.save(libro);
    }

    public Libro updateLibro(Long id, LibroRequestDTO dto) {
        Optional<Libro> libroExistente = librosRepository.findById(id);
        if (libroExistente.isPresent()) {
            Libro libro = libroExistente.get();

            Genero genero = generoRepository.findById(dto.getGenero())
                    .orElseThrow(() -> new IllegalArgumentException("Género no encontrado"));

            libro.setTitulo(dto.getTitulo());
            libro.setIsbn(dto.getIsbn());
            libro.setAnioPublicacion(dto.getAnioPublicacion());
            libro.setDisponible(dto.getDisponible());
            libro.setGenero(genero);

            return librosRepository.save(libro);
        } else {
            return null;
        }
    }

    public boolean deleteLibro(Long id) {
        if (librosRepository.existsById(id)) {
            librosRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
