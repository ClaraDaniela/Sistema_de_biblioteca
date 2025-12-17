package com.bibliotecadehogwarts.gestorDeBiblioteca.repository;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Long> {

}
