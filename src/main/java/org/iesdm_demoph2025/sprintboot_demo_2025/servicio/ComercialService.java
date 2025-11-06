package org.iesdm_demoph2025.sprintboot_demo_2025.servicio;

import org.iesdm_demoph2025.sprintboot_demo_2025.dao.ComercialDAO;
import org.iesdm_demoph2025.sprintboot_demo_2025.model.Comercial;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComercialService {

    //Implementamos la capa logica :
    public ComercialDAO comercialDAO;


    //Inyectamos la dependencia de ComercialDao

    public ComercialService(ComercialDAO comercialDAO) {this.comercialDAO = comercialDAO;}

    public List<Comercial> all(){

        return comercialDAO.getAll();
    }
}
