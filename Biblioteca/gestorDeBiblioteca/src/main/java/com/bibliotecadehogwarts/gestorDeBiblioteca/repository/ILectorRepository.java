package com.bibliotecadehogwarts.gestorDeBiblioteca.repository;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILectorRepository extends JpaRepository<Lector, Long> {

}
