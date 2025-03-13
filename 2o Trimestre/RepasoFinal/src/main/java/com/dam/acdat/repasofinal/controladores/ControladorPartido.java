package com.dam.acdat.repasofinal.controladores;


import com.dam.acdat.repasofinal.modelo.entidades.EntidadPartido;
import com.dam.acdat.repasofinal.servicios.ServicioPartido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/partido")
public class ControladorPartido {

    @Autowired
    private ServicioPartido servicioPartido;


    @GetMapping("/{equipo}")
    public Set<EntidadPartido> mostrarPartidoByEquipo(@PathVariable String equipo) {
        return servicioPartido.mostrarPartidoByEquipo(equipo);
    }

    @GetMapping("/local")
    public List<EntidadPartido> mostrarPartidoGanado() {
        return servicioPartido.mostrarGanadosByLocal();
    }

}
