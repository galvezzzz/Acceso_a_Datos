package org.example.springboot.controladores;

import org.example.springboot.modelo.dao.IDepartamentosDAO;
import org.example.springboot.modelo.dao.IEmpleadosDAO;
import org.example.springboot.modelo.entidades.EntidadDepartamentos;
import org.example.springboot.modelo.entidades.EntidadEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-res/departamentos")
public class ControladorDepartamentos {

    @Autowired
    IDepartamentosDAO departamentosDAO;

    @GetMapping
    public List<EntidadDepartamentos> buscarDepartamentos() {

        return (List<EntidadDepartamentos>) departamentosDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity <EntidadDepartamentos> buscarDepartamentosPorId(@PathVariable(value="id") int id) {

        Optional<EntidadDepartamentos> departamento = departamentosDAO.findById(id);

        if(departamento.isPresent()){
            return ResponseEntity.ok(departamento.get());

        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public EntidadDepartamentos guardarDepartamentos(@RequestBody EntidadDepartamentos entidad) {

        return departamentosDAO.save(entidad);
    }
}
