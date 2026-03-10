package com.alura.forohub.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String password;

    public String getLogin() {
        return "";
    }

    public Object getPassword() {
        return null;
    }
}