package com.alura.forohub.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.alura.forohub.model.Usuario;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    private String secret = "123456";

    public String generarToken(Usuario usuario){

        return JWT.create()
                .withIssuer("forohub")
                .withSubject(usuario.getLogin())
                .withExpiresAt(fechaExpiracion())
                .sign(Algorithm.HMAC256(secret));
    }

    private Instant fechaExpiracion(){
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.UTC);
    }
}