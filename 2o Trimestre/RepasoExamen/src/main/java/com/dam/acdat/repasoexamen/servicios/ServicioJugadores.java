package com.dam.acdat.repasoexamen.servicios;

import com.dam.acdat.repasoexamen.modelos.daos.IEquipoDAO;
import com.dam.acdat.repasoexamen.modelos.daos.IJugadoresDAO;
import com.dam.acdat.repasoexamen.modelos.entidades.EntidadEquipo;
import com.dam.acdat.repasoexamen.modelos.entidades.EntidadJugadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServicioJugadores {

    @Autowired
    IJugadoresDAO jugadoresDAO;

    @Autowired
    IEquipoDAO equipoDAO;

    public Set<EntidadJugadores> buscarJugadoresPorEquipo(String stringEquipo) {
        EntidadEquipo equipo = equipoDAO.findByNombre(stringEquipo);
        return equipo.getJugadores();
    }
}
