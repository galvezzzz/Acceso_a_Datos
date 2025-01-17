package com.dam.acdat.accesodatosapi.controladores;

import com.dam.acdat.accesodatosapi.modelo.dao.IDepartamentoDAO;
import com.dam.acdat.accesodatosapi.modelo.entidades.Departamento;
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
    IDepartamentoDAO departamentoDAO;

    @GetMapping
    public List<Departamento> buscarEmpleados() {
        return (List<Departamento>) departamentoDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscarEmpleadoPorID(@PathVariable(value = "id") int id){
        Optional<Departamento> departamento = departamentoDAO.findById(id);
        if (departamento.isPresent()) {
            return ResponseEntity.ok().body(departamento.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Departamento guardarEmpleado(@Validated @RequestBody Departamento departamento){
        return departamentoDAO.save(departamento);
    }
}
