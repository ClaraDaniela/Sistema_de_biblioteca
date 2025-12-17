package com.bibliotecadehogwarts.gestorDeBiblioteca.mapper;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.RolUsuario;
import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.RolUsuarioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolUsuarioMapper {
    RolUsuarioDTO rolUsuarioToRolUsuarioDTO(RolUsuario rolUsuario);
}
