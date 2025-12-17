package com.bibliotecadehogwarts.gestorDeBiblioteca.mapper;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Multa;
import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.MultaDTO;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MultaMapper {
    @Mapping(target = "lector", expression = "java(multa.getLector() != null ? multa.getLector().getNombre() + \" \" + multa.getLector().getApellido() : \"\")")
    @Mapping(target = "prestamo", expression = "java(multa.getPrestamo() != null && multa.getPrestamo().getLibro() != null ? \"Libro: \" + multa.getPrestamo().getLibro().getTitulo() + \" - Fecha: \" + multa.getPrestamo().getFechaPrestamo() : \"\")")
    MultaDTO multaToMultaDTO(Multa multa);

    List<MultaDTO> multaToMultaDTOList(List<Multa> multas);
}