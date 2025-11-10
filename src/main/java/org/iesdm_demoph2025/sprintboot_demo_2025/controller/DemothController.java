package org.iesdm_demoph2025.sprintboot_demo_2025.controller;

import jakarta.servlet.http.HttpSession;
import org.iesdm_demoph2025.sprintboot_demo_2025.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DemothController {

    //SIn service , solo activar sobre Plantillas HTML

    //EMPOINTS :

    @GetMapping("/demoth1")
    public String demoThText(Model model){

        model.addAttribute("parrafo2" , "En un lugar de la mancha...");
        return "plantilla";
    }



    @GetMapping("/demoth2")
    public String demothBlock(Model model){

        Cliente cliente = Cliente.builder().nombre("Don Miguel de Cervantes").build();

        Cliente cliente2 = Cliente.builder().nombre("Lope de Vega").build();

        List<Cliente> list = List.of(cliente,cliente2);
        model.addAttribute("escritores" , list);
        return "plantilla2";
    }



    @GetMapping("/demoth3")
    public String demothHttpSessions(Model model , HttpSession session){



        String mensajeASesion = "Lo grabe en demoth3";
        String mensajeAModel = "Esto solo lo ve la plantilla demoth3";

        //Atributos en model solo visibles en esta plantila
        model.addAttribute("msgModel" , mensajeAModel);

       session.setAttribute("msgSession" , mensajeASesion);


        return  "demoth3";
    }


    @GetMapping("/demoth3_2")
    public String demothHttpSessions(){


        return  "demoth3_2";
    }


    @GetMapping("/demoth5")

        public String demoth5(Model model){

        Cliente cliente = Cliente.builder()
                .id(101)
                .nombre("Cervantes")
                .build();

        model.addAttribute("cliente" , cliente);
        return "plantilla5";


        }
}





