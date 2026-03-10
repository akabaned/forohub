package com.alura.forohub.controller;

import com.alura.forohub.dto.DatosLogin;
import com.alura.forohub.model.Usuario;
import com.alura.forohub.repository.UsuarioRepository;
import com.alura.forohub.security.TokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public String login(@RequestBody DatosLogin datos){

        Usuario usuario = repository.findByLogin(datos.login());

        if(usuario == null || !usuario.getPassword().equals(datos.password())){
            throw new RuntimeException("Credenciales inválidas");
        }

        return tokenService.generarToken(usuario);
    }
}