package com.bibliotecadehogwarts.gestorDeBiblioteca.repository;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Multa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMultaRepository extends JpaRepository<Multa, Long> {

    Optional<Multa> findByPrestamoId(Long prestamoId);

}
