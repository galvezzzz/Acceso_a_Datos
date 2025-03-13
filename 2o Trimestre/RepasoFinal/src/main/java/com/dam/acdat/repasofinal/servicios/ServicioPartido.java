package com.dam.acdat.repasofinal.servicios;

import com.dam.acdat.repasofinal.modelo.dao.IEquipoDAO;
import com.dam.acdat.repasofinal.modelo.dao.IPartidoDAO;
import com.dam.acdat.repasofinal.modelo.entidades.EntidadEquipo;
import com.dam.acdat.repasofinal.modelo.entidades.EntidadPartido;
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

    public Set<EntidadPartido> mostrarPartidoByEquipo(String equipo) {
        EntidadEquipo partido = equipoDAO.findByNombre(equipo);
        return partido.getPartidos_local();
    }

    public List<EntidadPartido> mostrarGanadosByLocal(){
        return partidoDAO.mostrarPartidosGanadosByEquipoLocal();
    }

}
