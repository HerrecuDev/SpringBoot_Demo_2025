package org.iesdm_demoph2025.sprintboot_demo_2025.controller;

import org.iesdm_demoph2025.sprintboot_demo_2025.model.Comercial;
import org.iesdm_demoph2025.sprintboot_demo_2025.servicio.ComercialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ComercialController {

    private ComercialService comercialService;

    public ComercialController(ComercialService comercialService) {this.comercialService = comercialService;}



    @GetMapping("/comerciales")

    public String listadoComerciales(Model model){

        List<Comercial> comerciallist = comercialService.all();
        model.addAttribute("listaComerciales" , comerciallist);

        return "comerciales";
    }
}
