package com.bibliotecadehogwarts.gestorDeBiblioteca.mapper;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Lector;
import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.LectorDTO;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LectorMapper {

    @Mapping(source = "tipo.tipo", target = "tipo")
    @Mapping(source = "casa.nombre", target = "casa")
    LectorDTO lectorToLectorDTO(Lector lector);

    List<LectorDTO> lectorToLectorDTOList(List<Lector> lector);
}
