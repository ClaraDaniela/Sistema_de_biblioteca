package com.bibliotecadehogwarts.gestorDeBiblioteca.repository;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.RolUsuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolUsuarioRepository extends JpaRepository<RolUsuario, Long> {
}