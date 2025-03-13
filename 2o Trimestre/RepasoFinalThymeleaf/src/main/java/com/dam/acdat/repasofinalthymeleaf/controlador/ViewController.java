package com.dam.acdat.repasofinalthymeleaf.controlador;

import com.dam.acdat.repasofinalthymeleaf.modelo.dao.IEquipoDAO;
import com.dam.acdat.repasofinalthymeleaf.modelo.dao.IJugadoresDAO;
import com.dam.acdat.repasofinalthymeleaf.modelo.dao.IPartidosDAO;
import com.dam.acdat.repasofinalthymeleaf.modelo.entidades.Equipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewController {

    @Autowired
    IEquipoDAO equipoDAO;

    @Autowired
    IJugadoresDAO jugadoresDAO;

    @Autowired
    IPartidosDAO partidosDAO;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/verequipos")
    public String verEquipos(Model model) {
        model.addAttribute("equipos", equipoDAO.findAll());
        return "verequipos";
    }
}
