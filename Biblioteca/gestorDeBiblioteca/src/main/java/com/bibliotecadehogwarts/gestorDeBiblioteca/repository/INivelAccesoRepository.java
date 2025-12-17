package com.bibliotecadehogwarts.gestorDeBiblioteca.repository;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.NivelAcceso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface INivelAccesoRepository extends JpaRepository<NivelAcceso, Integer> {

}
