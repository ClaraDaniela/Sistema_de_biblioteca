package com.bibliotecadehogwarts.gestorDeBiblioteca.service;

import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Lector;
import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.LectorRequestDTO;
import com.bibliotecadehogwarts.gestorDeBiblioteca.repository.ILectorRepository;
import com.bibliotecadehogwarts.gestorDeBiblioteca.repository.ICasaRepository;
import com.bibliotecadehogwarts.gestorDeBiblioteca.repository.ITipoLectorRepository;
import com.bibliotecadehogwarts.gestorDeBiblioteca.model.TipoLector;
import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Casa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectorService {

    private final ILectorRepository lectorRepository;
    private final ICasaRepository casaRepository;
    private final ITipoLectorRepository tipoLectorRepository;

    public LectorService(
            ILectorRepository lectorRepository,
            ICasaRepository casaRepository,
            ITipoLectorRepository tipoLectorRepository) {

        this.lectorRepository = lectorRepository;
        this.casaRepository = casaRepository;
        this.tipoLectorRepository = tipoLectorRepository;
    }

    public List<Lector> getAllLectores() {
        return lectorRepository.findAll();
    }

    public Lector getLectorById(Long id) {
        return lectorRepository.findById(id).orElse(null);
    }

    public Lector createLector(LectorRequestDTO dto) {

        Casa casa = casaRepository.findById(dto.getCasa())
                .orElseThrow(() -> new IllegalArgumentException("Casa no encontrada"));

        TipoLector tipo = tipoLectorRepository.findById(dto.getTipo())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de lector no encontrado"));

        Lector lector = new Lector();
        lector.setNombre(dto.getNombre());
        lector.setApellido(dto.getApellido());
        lector.setEmail(dto.getEmail());
        lector.setTipo(tipo);
        lector.setCasa(casa);
        lector.setBloqueado(dto.getBloqueado());

        return lectorRepository.save(lector);
    }

    public Lector updateLector(Long id, LectorRequestDTO dto) {
        return lectorRepository.findById(id).map(lector -> {

            Casa casa = casaRepository.findById(dto.getCasa())
                    .orElseThrow(() -> new IllegalArgumentException("Casa no encontrada"));

            TipoLector tipo = tipoLectorRepository.findById(dto.getTipo())
                    .orElseThrow(() -> new IllegalArgumentException("Tipo de lector no encontrado"));

            lector.setNombre(dto.getNombre());
            lector.setApellido(dto.getApellido());
            lector.setEmail(dto.getEmail());
            lector.setTipo(tipo);
            lector.setCasa(casa);
            lector.setBloqueado(dto.getBloqueado());

            return lectorRepository.save(lector);
        }).orElse(null);
    }

    public boolean deleteLector(Long id) {
        if (lectorRepository.existsById(id)) {
            lectorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
