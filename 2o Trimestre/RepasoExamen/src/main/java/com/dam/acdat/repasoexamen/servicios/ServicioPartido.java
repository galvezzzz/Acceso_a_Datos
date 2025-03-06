package com.dam.acdat.repasoexamen.servicios;

import com.dam.acdat.repasoexamen.modelos.daos.IEquipoDAO;

import com.dam.acdat.repasoexamen.modelos.daos.IPartidoDAO;
import com.dam.acdat.repasoexamen.modelos.entidades.EntidadEquipo;
import com.dam.acdat.repasoexamen.modelos.entidades.EntidadPartido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ServicioPartido {

    @Autowired
    IEquipoDAO equipoDAO;

    @Autowired
    IPartidoDAO partidoDAO;

    public Set<EntidadPartido> mostrarPartidoPorEquipo(String stringEquipo) {
        EntidadEquipo equipo = equipoDAO.findByNombre(stringEquipo);
        return equipo.getPartidos_local();
    }

    public List<EntidadPartido> mostrarPartidoGanadoByEquipoLocal() {
        return partidoDAO.mostrarPartidosGanadosByEquipoLocal();
    }
}
