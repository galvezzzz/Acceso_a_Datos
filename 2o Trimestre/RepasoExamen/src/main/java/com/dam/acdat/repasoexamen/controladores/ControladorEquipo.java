package com.dam.acdat.repasoexamen.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipo")
public class ControladorEquipo {

    @Autowired
    private ControladorEquipo controladorEquipo;
}
