package com.bibliotecadehogwarts.gestorDeBiblioteca.mapper;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Casa;
import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.CasaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CasaMapper {
    CasaDTO casaToCasaDTO(Casa casa);
}