package com.bibliotecadehogwarts.gestorDeBiblioteca.service;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.NivelAcceso;
import com.bibliotecadehogwarts.gestorDeBiblioteca.repository.INivelAccesoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NivelAccesoService {

    private final INivelAccesoRepository repository;

    public NivelAccesoService(INivelAccesoRepository repository) {
        this.repository = repository;
    }

    public List<NivelAcceso> getAllNivelAccesos() {
        return repository.findAll();
    }

    public NivelAcceso getByIdNivelAcceso(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public NivelAcceso createNivelAcceso(NivelAcceso nivelAcceso) {
        return repository.save(nivelAcceso);
    }

    public NivelAcceso updateNivelAcceso(Integer id, NivelAcceso nivelAcceso) {
        return repository.findById(id)
                .map(n -> {
                    n.setTipo(nivelAcceso.getTipo());
                    n.setDescripcion(nivelAcceso.getDescripcion());
                    return repository.save(n);
                })
                .orElse(null);
    }

    public boolean deleteNivelAcceso(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
