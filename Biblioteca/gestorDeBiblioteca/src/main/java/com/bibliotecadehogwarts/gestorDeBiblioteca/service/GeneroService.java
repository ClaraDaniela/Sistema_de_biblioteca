package com.bibliotecadehogwarts.gestorDeBiblioteca.service;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Genero;
import com.bibliotecadehogwarts.gestorDeBiblioteca.repository.IGeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {

    private IGeneroRepository generoRepository;

    public GeneroService(IGeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }
    public List<Genero> getAllGeneros() {
        return generoRepository.findAll();
    }
    public Genero getGeneroById(Long id) {
        return generoRepository.findById(id).orElse(null);
    }
    public Genero createGenero(Genero genero) {
        return generoRepository.save(genero);
    }
    public Genero updateGenero(Long id, Genero generoActualizado) {
        Optional<Genero> generoExistente = generoRepository.findById(id);
        if (generoExistente.isPresent()) {
            Genero genero = generoExistente.get();
            genero.setNombre(generoActualizado.getNombre());
            return generoRepository.save(genero);
        } else {
            return null;
        }
    }
    public boolean deleteGenero(Long id) {
        if (generoRepository.existsById(id)) {
            generoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
