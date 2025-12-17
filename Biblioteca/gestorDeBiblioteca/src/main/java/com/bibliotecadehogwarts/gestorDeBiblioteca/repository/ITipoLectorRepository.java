package com.bibliotecadehogwarts.gestorDeBiblioteca.repository;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.TipoLector;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoLectorRepository extends JpaRepository<TipoLector, Integer> {
}