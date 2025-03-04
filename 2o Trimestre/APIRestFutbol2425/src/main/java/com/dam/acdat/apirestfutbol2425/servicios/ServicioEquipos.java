package com.dam.acdat.apirestfutbol2425.servicios;

import com.dam.acdat.apirestfutbol2425.modelos.daos.IEquiposDAO;
import com.dam.acdat.apirestfutbol2425.modelos.entidades.EntidadEquipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioEquipos {

    @Autowired
    IEquiposDAO equiposDAO;

    public List<EntidadEquipos> buscarEquipos(){
        return (List<EntidadEquipos>) equiposDAO.findAll();
    }

    public Optional<EntidadEquipos> buscarEquipoById(Integer id){
        return equiposDAO.findById(id);
    }

    public boolean crearEquipo (@Validated @RequestBody EntidadEquipos equipos){
        if(!equiposDAO.existsById(equipos.getId())){
            equiposDAO.save(equipos);
            return true;
        }else{
            return false;
        }
    }

    public boolean eliminarEquipo(@PathVariable(value = "id") int id){
        if(equiposDAO.existsById(id)){
            equiposDAO.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public boolean modificarEquipo(int id, EntidadEquipos nuevoEquipo) {
        Optional<EntidadEquipos> equipos = equiposDAO.findById(id);

        if(equipos.isPresent()) {
            equipos.get().setNombre(nuevoEquipo.getNombre());
            equipos.get().setEscudo(nuevoEquipo.getEscudo());
            equipos.get().setId(nuevoEquipo.getId());
            equiposDAO.save(equipos.get());
            return true;
        } else {
            return false;
        }
    }
}
