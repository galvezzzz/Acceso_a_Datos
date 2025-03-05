package org.example.springboot.modelo.servicio;

import org.example.springboot.modelo.dao.IDepartamentosDAO;
import org.example.springboot.modelo.dao.IEmpleadosDAO;
import org.example.springboot.modelo.entidades.EntidadDepartamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioDepartamentos {

    @Autowired
    IDepartamentosDAO departamentosDAO;

    public List<EntidadDepartamentos> buscarDepartamentos() {
        return (List<EntidadDepartamentos>) departamentosDAO.findAll();
    }

    public Optional<EntidadDepartamentos> buscarDepartamentoPorId(@PathVariable (value = "id") int id) {
        Optional<EntidadDepartamentos> departamentos = departamentosDAO.findById(id);

        return departamentos;
    }

    public boolean guardarDepartamento (EntidadDepartamentos departamento) {
        Optional<EntidadDepartamentos> dep = departamentosDAO.findById(departamento.getId());
        if (dep.isPresent()) {
            System.out.println("Ya existe el departamento");
            return false;
        }else{
            departamentosDAO.save(departamento);
            return true;
        }
    }

    public boolean actualizarDepartamento (EntidadDepartamentos departamento) {
        Optional<EntidadDepartamentos> dep = departamentosDAO.findById(departamento.getId());
        if (dep.isPresent()) {
            dep.get().setId(departamento.getId());
            dep.get().setNombre(departamento.getNombre());
            dep.get().setUbicacion(departamento.getUbicacion());
            departamentosDAO.save(departamento);
            return true;
        }else{
            System.out.println("No existe el departamento");
            return false;
        }
    }

    public boolean eliminarDepartamento (EntidadDepartamentos departamento) {
        Optional<EntidadDepartamentos> dep = departamentosDAO.findById(departamento.getId());
        if (dep.isPresent()) {
            departamentosDAO.delete(dep.get());
            return true;
        }else{
            System.out.println("El departamento no existe");
            return false;
        }
    }
}
