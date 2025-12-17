package com.bibliotecadehogwarts.gestorDeBiblioteca.mapper;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Libro;
import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.LibroDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.bibliotecadehogwarts.gestorDeBiblioteca.mapper.LibroMapper;
import com.bibliotecadehogwarts.gestorDeBiblioteca.model.LibroAutor;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LibroMapper {

    @Mapping(source = "genero.nombre", target = "genero")
    @Mapping(source = "nivelAcceso.tipo", target = "nivelAcceso")
    @Mapping(source = "libroAutores", target = "autores")
    LibroDTO libroToLibroDTO(Libro libro);

    default List<String> map(List<LibroAutor> libroAutores) {
        if (libroAutores == null)
            return List.of();

        return libroAutores.stream()
                .map(la -> la.getAutor().getNombre())
                .toList();
    }
}
