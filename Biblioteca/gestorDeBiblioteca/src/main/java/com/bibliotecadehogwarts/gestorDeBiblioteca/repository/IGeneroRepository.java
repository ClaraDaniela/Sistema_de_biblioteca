package com.bibliotecadehogwarts.gestorDeBiblioteca.repository;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGeneroRepository extends JpaRepository<Genero, Long> {

}
