package com.dam.acdat.repasoexamen.controladores;

import com.dam.acdat.repasoexamen.modelos.entidades.EntidadPartido;
import com.dam.acdat.repasoexamen.servicios.ServicioPartido;
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
    ServicioPartido servicioPartido;

    @GetMapping("/{equipo}")
    public Set<EntidadPartido> obtenerPartidoPorNombreEquipo(@PathVariable (value = "equipo") String equipo) {
        return servicioPartido.mostrarPartidoPorEquipo(equipo);
    }

    @GetMapping("/local")
    public List<EntidadPartido> mostrarPartidosGanadosByEquipoLocal() {
        return servicioPartido.mostrarPartidoGanadoByEquipoLocal();
    }
}
