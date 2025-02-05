package com.dam.acdat.appbiblioteca2425.controladores;

import com.dam.acdat.appbiblioteca2425.modelo.entidades.EntidadLibros;
import com.dam.acdat.appbiblioteca2425.servicios.ServicioLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-rest/libros")
public class ControladorLibros {

    @Autowired
    ServicioLibros servicioLibros;


}
