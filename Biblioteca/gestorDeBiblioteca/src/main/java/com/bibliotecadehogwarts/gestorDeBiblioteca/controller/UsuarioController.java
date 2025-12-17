package com.bibliotecadehogwarts.gestorDeBiblioteca.controller;

import com.bibliotecadehogwarts.gestorDeBiblioteca.service.UsuarioService;
import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.UsuarioDTO;
import com.bibliotecadehogwarts.gestorDeBiblioteca.dto.UsuarioRequestDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioRequestDTO usuarioRequest) {
        UsuarioDTO validado = usuarioService.login(
                usuarioRequest.getUsername(),
                usuarioRequest.getPassword());

        if (validado == null) {
            return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");
        }

        return ResponseEntity.ok(validado);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> crearUsuario(@RequestBody UsuarioRequestDTO usuarioRequest) {
        UsuarioDTO creado = usuarioService.crearUsuario(usuarioRequest);
        return ResponseEntity.ok(creado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        boolean eliminado = usuarioService.eliminarUsuario(id);
        return eliminado
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
