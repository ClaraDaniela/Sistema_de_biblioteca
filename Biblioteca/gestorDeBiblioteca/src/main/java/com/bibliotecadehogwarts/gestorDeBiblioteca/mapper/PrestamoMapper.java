
package com.bibliotecadehogwarts.gestorDeBiblioteca.mapper;

import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.PrestamoDTO;
import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Prestamo;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PrestamoMapper {

    @Mapping(source = "libro.titulo", target = "libro")
    @Mapping(expression = "java(prestamo.getLector().getNombre() + \" \" + prestamo.getLector().getApellido())", target = "lector")
    PrestamoDTO toDto(Prestamo prestamo);

    List<PrestamoDTO> toDtoList(List<Prestamo> prestamos);
}
