package com.dam.acdat.thymeleaf;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/departamentos")
    public String mostrarDepartamentos(Model model) {
        return "departamentos";
    }

    @GetMapping("/departamentos")
    public String mostrarDepartamentos(Model model) {
        List<EntidadDepartamentos> departamentos = (List<EntidadDepartamentos>) departamentosDAO.findAll();
        model.addAttribute("departamentos", departamentos);
        return "departamentos";
    }

}
