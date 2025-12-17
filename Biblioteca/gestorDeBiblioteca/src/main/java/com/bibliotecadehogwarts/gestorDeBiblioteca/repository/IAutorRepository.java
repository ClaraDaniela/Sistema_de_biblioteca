package com.bibliotecadehogwarts.gestorDeBiblioteca.repository;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAutorRepository extends JpaRepository<Autor, Long> {
}
