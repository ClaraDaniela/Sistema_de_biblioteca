package com.bibliotecadehogwarts.gestorDeBiblioteca.service;

import java.util.List;
import java.util.Optional;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.TipoLector;
import com.bibliotecadehogwarts.gestorDeBiblioteca.repository.ITipoLectorRepository;

public class TipoLectorService {
    private ITipoLectorRepository tipoLectorRepository;

    public TipoLectorService(ITipoLectorRepository tipoLectorRepository) {
        this.tipoLectorRepository = tipoLectorRepository;
    }

    public List<TipoLector> getAllTipoLectors() {
        return tipoLectorRepository.findAll();
    }

    public TipoLector getTipoLectorById(Integer id) {
        return tipoLectorRepository.findById(id).orElse(null);
    }

    public TipoLector createTipoLector(TipoLector genero) {
        return tipoLectorRepository.save(genero);
    }

    public TipoLector updateTipoLector(Integer id, TipoLector generoActualizado) {
        Optional<TipoLector> generoExistente = tipoLectorRepository.findById(id);
        if (generoExistente.isPresent()) {
            TipoLector genero = generoExistente.get();
            genero.setTipo(generoActualizado.getTipo());
            return tipoLectorRepository.save(genero);
        } else {
            return null;
        }
    }

    public boolean deleteTipoLector(Integer id) {
        if (tipoLectorRepository.existsById(id)) {
            tipoLectorRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
