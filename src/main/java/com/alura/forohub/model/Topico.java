package com.alura.forohub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    private String autor;

    private String curso;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    public void setTitulo(@NotBlank String titulo) {
    }

    public void setMensaje(@NotBlank String mensaje) {
    }

    public void setAutor(@NotBlank String autor) {
    }

    public void setCurso(@NotBlank String curso) {
    }
}