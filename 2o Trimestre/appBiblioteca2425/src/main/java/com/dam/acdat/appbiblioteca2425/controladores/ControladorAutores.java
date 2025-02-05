package com.dam.acdat.appbiblioteca2425.controladores;

import com.dam.acdat.appbiblioteca2425.modelo.entidades.EntidadAutores;
import com.dam.acdat.appbiblioteca2425.servicios.ServicioAutores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-rest/autores")
public class ControladorAutores {

    @Autowired
    ServicioAutores servicioAutores;

    @GetMapping
    public ResponseEntity<List<EntidadAutores>> buscarAutores() {
        List<EntidadAutores> autores = this.servicioAutores.buscarAutores();
        if (autores.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(servicioAutores.buscarAutores());
    }

    @GetMapping("/{id}")
    ResponseEntity<Optional<EntidadAutores>> buscarAutoresPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(servicioAutores.buscarAutorPorId(id));
    }

    @PostMapping
    public ResponseEntity<EntidadAutores> guardarAutor(@RequestBody EntidadAutores autores) {
        if (autores.getId() != null)
            return ResponseEntity.badRequest().build();

        this.servicioAutores.guardarAutor(autores);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntidadAutores> actualizarAutor(@RequestBody EntidadAutores autores) {
        this.servicioAutores.guardarAutor(autores);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EntidadAutores> borrarAutor(@PathVariable Integer id) {
        this.servicioAutores.borrarAutor(id);
        return ResponseEntity.noContent().build();
    }



}
