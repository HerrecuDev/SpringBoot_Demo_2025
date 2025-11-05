package org.iesdm_demoph2025.sprintboot_demo_2025.servicio;

import lombok.AllArgsConstructor;
import org.iesdm_demoph2025.sprintboot_demo_2025.dao.ClienteDAO;
import org.iesdm_demoph2025.sprintboot_demo_2025.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteService {

    //Implementar la capa logica de negocio
    public ClienteDAO clienteDao;

    //Inyeccion de dependencia de clienteDao:
    public ClienteService(ClienteDAO clienteDao) {
        this.clienteDao = clienteDao;
    }

    public List<Cliente> all(){

        return clienteDao.getAll();

    }
}
