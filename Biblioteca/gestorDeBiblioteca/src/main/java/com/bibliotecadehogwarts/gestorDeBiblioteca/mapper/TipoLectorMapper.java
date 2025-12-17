package com.bibliotecadehogwarts.gestorDeBiblioteca.mapper;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.TipoLector;
import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.TipoLectorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoLectorMapper {
    TipoLectorDTO tipoLectorToTipoLectorDTO(TipoLector tipoLector);
}