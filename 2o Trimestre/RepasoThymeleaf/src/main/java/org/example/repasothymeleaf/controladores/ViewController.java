package org.example.repasothymeleaf.controladores;

import org.example.repasothymeleaf.modelo.dao.IEquipoDAO;
import org.example.repasothymeleaf.modelo.dao.IJugadoresDAO;
import org.example.repasothymeleaf.modelo.dao.IPartidosDAO;
import org.example.repasothymeleaf.modelo.entidades.EntidadEquipo;
import org.example.repasothymeleaf.modelo.entidades.EntidadJugadores;
import org.example.repasothymeleaf.modelo.entidades.EntidadPartido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

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
    public String mostrarEquipos(Model model) {
        model.addAttribute("equipos", equipoDAO.findAll());
        return "verequipos";
    }

    @GetMapping("/verjugadores")
    public String mostrarJugadores(Model model) {
        model.addAttribute("jugadores", jugadoresDAO.findAll());
        return "verjugadores";
    }

    @GetMapping("/verpartidos")
    public String mostrarPartidos(Model model) {
        model.addAttribute("partidos", partidosDAO.findAll());
        return "verpartidos";
    }

    @GetMapping("/verjugador")
    public String verJugador(@RequestParam(name = "id", required = true) int id, Model model) {
        Optional<EntidadJugadores> jugador = jugadoresDAO.findById(id);

        if(jugador.isPresent()) {
            model.addAttribute("jugador", jugador.get());
            return "verjugador";
        }else{
            model.addAttribute("titulo", "Error");
            return "error";
        }
    }

    @GetMapping("/altaequipo")
    public String altaEquipo(Model model) {

        model.addAttribute("equipos", new EntidadEquipo());
        return "altaequipo";
    }

    @PostMapping("/altaequipo")
    public String crarEquipo(@ModelAttribute EntidadEquipo equipo, Model model) {

        equipoDAO.save(equipo);
        model.addAttribute("tipo_operacion", "ok");
        model.addAttribute("mensaje", "Equipo creado correctamente");

        return "altaequipo";
    }

}
