package com.bibliotecadehogwarts.gestorDeBiblioteca.service;

import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.UsuarioDTO;
import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.UsuarioRequestDTO;
import com.bibliotecadehogwarts.gestorDeBiblioteca.model.RolUsuario;
import com.bibliotecadehogwarts.gestorDeBiblioteca.model.Usuario;
import com.bibliotecadehogwarts.gestorDeBiblioteca.repository.IRolUsuarioRepository;
import com.bibliotecadehogwarts.gestorDeBiblioteca.repository.IUsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final IUsuarioRepository usuarioRepository;
    private final IRolUsuarioRepository rolUsuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(
            IUsuarioRepository usuarioRepository,
            IRolUsuarioRepository rolUsuarioRepository,
            PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.rolUsuarioRepository = rolUsuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioDTO login(String username, String password) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario == null || !passwordEncoder.matches(password, usuario.getPassword())) {
            return null;
        }
        return mapToDTO(usuario);
    }

    public UsuarioDTO crearUsuario(UsuarioRequestDTO dto) {
        RolUsuario rol = rolUsuarioRepository.findById(dto.getRolUsuario())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        Usuario usuario = new Usuario();
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        usuario.setRolUsuario(rol);

        Usuario guardado = usuarioRepository.save(usuario);
        return mapToDTO(guardado);
    }

    public boolean eliminarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private UsuarioDTO mapToDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setUsername(usuario.getUsername());
        dto.setRolNombre(usuario.getRolUsuario().getRol());
        return dto;
    }
}