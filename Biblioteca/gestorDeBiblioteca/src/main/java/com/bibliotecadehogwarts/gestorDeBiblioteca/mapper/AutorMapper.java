package com.bibliotecadehogwarts.gestorDeBiblioteca.mapper;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Autor;
import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.AutorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AutorMapper {
    AutorDTO autorToAutorDTO(Autor autor);
}
