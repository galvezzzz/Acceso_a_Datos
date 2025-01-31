package com.dam.acdat.accesodatosapi.controladores;


import com.dam.acdat.accesodatosapi.modelo.dao.IDepartamentoDAO;
import com.dam.acdat.accesodatosapi.modelo.dao.IEmpleadoDAO;
//import com.dam.acdat.accesodatosapi.modelo.dto.EmpleadoDTO;
import com.dam.acdat.accesodatosapi.modelo.entidades.Departamento;
import com.dam.acdat.accesodatosapi.modelo.entidades.Empleado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-res/empleados")
public class
ControladorEmpleados {

    @Autowired
    IEmpleadoDAO empleadoDAO;

    @Autowired
    IDepartamentoDAO departamentoDAO;

    @GetMapping
    public List<Empleado> buscarEmpleados() {
        return (List<Empleado>) empleadoDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> buscarEmpleadoPorID(@PathVariable(value = "id") int id){
        Optional<Empleado> empleado = empleadoDAO.findById(id);
        if (empleado.isPresent()) {
            return ResponseEntity.ok().body(empleado.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEmpleado(@RequestBody Empleado nuevoEmpleado, @PathVariable (value = "id") int id){
        if(empleadoDAO.existsById(id)){
            empleadoDAO.save(nuevoEmpleado);
            return ResponseEntity.ok().body("Actualizado");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    /*
    @GetMapping("dto/{id}")
    public ResponseEntity<EmpleadoDTO> buscarEmpleadosDTOById(@PathVariable(value = "id") int id){
        Optional<Empleado> empleado = empleadoDAO.findById(id);

        if(empleado.isPresent()){

            Optional<Departamento> departamento = departamentoDAO.findById(empleado.get().getId());

            ModelMapper mapper = new ModelMapper();
            EmpleadoDTO empleadosDTO = mapper.map(empleado.get(), EmpleadoDTO.class);
            mapper.map(departamento.get(),empleadosDTO);


            return ResponseEntity.ok().body(empleadosDTO);
        }else{

            return ResponseEntity.notFound().build();
        }
    }

     */

    @PostMapping
    public Empleado guardarEmpleado(@Validated @RequestBody Empleado empleado){
        return empleadoDAO.save(empleado);
    }


}
