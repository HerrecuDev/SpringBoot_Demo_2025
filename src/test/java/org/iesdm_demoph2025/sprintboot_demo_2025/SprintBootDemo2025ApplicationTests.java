package org.iesdm_demoph2025.sprintboot_demo_2025;

import org.iesdm_demoph2025.sprintboot_demo_2025.dao.ClienteDAOImpl;
import org.iesdm_demoph2025.sprintboot_demo_2025.model.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class SprintBootDemo2025ApplicationTests {

    @Autowired
    private ClienteDAOImpl clienteDAOImpl;


    //SPring es un framework de Inyección de dependencias e Inversion de Control
    @Test
    void contextLoads() {
        System.out.println();
    }


    @Test
    void testGetAll(){

        List<Cliente> list = clienteDAOImpl.getAll();

        list.forEach(System.out::println);

    }

    @Test
    void tetsFind(){

        Optional<Cliente> optionalCLiente = clienteDAOImpl.find(3);

        if (optionalCLiente.isPresent()){
            System.out.println(optionalCLiente.get());
        }else{
            System.out.println("VACIOOO!!!");
        }
    }

}
