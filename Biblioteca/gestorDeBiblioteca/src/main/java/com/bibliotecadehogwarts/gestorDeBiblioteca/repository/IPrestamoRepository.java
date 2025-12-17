package com.bibliotecadehogwarts.gestorDeBiblioteca.repository;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPrestamoRepository extends JpaRepository<Prestamo, Long> {
}
