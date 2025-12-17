package com.bibliotecadehogwarts.gestorDeBiblioteca.repository;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Casa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICasaRepository extends JpaRepository<Casa, Integer> {

}
