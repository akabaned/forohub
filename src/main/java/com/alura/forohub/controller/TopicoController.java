package com.alura.forohub.controller;

import com.alura.forohub.dto.DatosActualizarTopico;
import com.alura.forohub.dto.DatosRegistroTopico;
import com.alura.forohub.model.Topico;
import com.alura.forohub.repository.TopicoRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;
    @GetMapping
    public List<Topico> listarTopicos(){
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Topico obtenerTopico(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Topico no encontrado"));
    }
    @PutMapping("/{id}")
    public Topico actualizarTopico(@PathVariable Long id,
                                   @RequestBody @Valid DatosActualizarTopico datos){

        Topico topico = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Topico no encontrado"));

        topico.setTitulo(datos.titulo());
        topico.setMensaje(datos.mensaje());

        return repository.save(topico);
    }
    @DeleteMapping("/{id}")
    public void eliminarTopico(@PathVariable Long id){
        repository.deleteById(id);
    }
    @PostMapping
    public Topico registrarTopico(@RequestBody @Valid DatosRegistroTopico datos){

        Topico topico = new Topico();

        topico.setTitulo(datos.titulo());
        topico.setMensaje(datos.mensaje());
        topico.setAutor(datos.autor());
        topico.setCurso(datos.curso());

        return repository.save(topico);
    }
}