package org.iesdm_demoph2025.sprintboot_demo_2025.controller;

import org.iesdm_demoph2025.sprintboot_demo_2025.model.Cliente;
import org.iesdm_demoph2025.sprintboot_demo_2025.servicio.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    //Empoint para la ruta http://localhost:8080/clientes
    @GetMapping("/clientes")
    public String listerClientes(Model model){

        List<Cliente> clientelist = clienteService.all();
        model.addAttribute("listaClientes" , clientelist);

        return "clientes";

    }
}
