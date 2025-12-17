package com.bibliotecadehogwarts.gestorDeBiblioteca.service;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Autor;
import com.bibliotecadehogwarts.gestorDeBiblioteca.repository.IAutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    private final IAutorRepository autorRepository;

    public AutorService(IAutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }
    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }
    public Autor getAutorById(Long id) {
        return autorRepository.findById(id).orElse(null);
    }
    public Autor createAutor(Autor autor) {
        return autorRepository.save(autor);
    }
    public Autor updateAutor(Long id, Autor autorActualizado) {
        Optional<Autor> autorExistente = autorRepository.findById(id);
        if (autorExistente.isPresent()) {
            Autor autor = autorExistente.get();
            autor.setNombre(autorActualizado.getNombre());
            autor.setApellido(autorActualizado.getApellido());
            return autorRepository.save(autor);
        } else {
            return null;
        }
    }
    public boolean deleteAutor(Long id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
