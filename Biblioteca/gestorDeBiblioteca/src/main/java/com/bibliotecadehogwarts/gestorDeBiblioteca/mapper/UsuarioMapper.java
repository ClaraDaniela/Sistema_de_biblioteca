package com.bibliotecadehogwarts.gestorDeBiblioteca.mapper;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Usuario;
import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mapping(source = "rolUsuario.rol", target = "rolNombre")
    UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);
}