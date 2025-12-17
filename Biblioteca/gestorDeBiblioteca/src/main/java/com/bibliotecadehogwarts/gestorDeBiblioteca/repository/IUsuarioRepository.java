package com.bibliotecadehogwarts.gestorDeBiblioteca.repository;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
