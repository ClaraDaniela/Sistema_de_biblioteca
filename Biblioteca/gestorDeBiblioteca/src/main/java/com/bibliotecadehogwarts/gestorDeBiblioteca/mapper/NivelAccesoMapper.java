package com.bibliotecadehogwarts.gestorDeBiblioteca.mapper;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.NivelAcceso;
import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.NivelAccesoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NivelAccesoMapper {
    NivelAccesoDTO nivelAccesoToNivelAccesoDTO(NivelAcceso nivelAcceso);
}
