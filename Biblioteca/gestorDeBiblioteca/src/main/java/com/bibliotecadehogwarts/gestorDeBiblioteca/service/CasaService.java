package com.bibliotecadehogwarts.gestorDeBiblioteca.service;

import java.util.List;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Casa;
import com.bibliotecadehogwarts.gestorDeBiblioteca.repository.ICasaRepository;

public class CasaService {
    private ICasaRepository casaRepository;

    public CasaService(ICasaRepository casaRepository) {
        this.casaRepository = casaRepository;
    }

    public List<Casa> getAllCasa() {
        return casaRepository.findAll();
    }

    public Casa getCasaById(Integer id) {
        return casaRepository.findById(id).orElse(null);
    }
}
