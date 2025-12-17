package com.bibliotecadehogwarts.gestorDeBiblioteca.mapper;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Genero;
import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.GeneroDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GeneroMapper {
    GeneroDTO generoToGeneroDTO(Genero genero);
}