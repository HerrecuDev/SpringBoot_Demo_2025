package org.iesdm_demoph2025.sprintboot_demo_2025;

import org.iesdm_demoph2025.sprintboot_demo_2025.dao.ClienteDAO;
import org.iesdm_demoph2025.sprintboot_demo_2025.dao.ClienteDAOImpl;
import org.iesdm_demoph2025.sprintboot_demo_2025.dao.ComercialDAOImpl;
import org.iesdm_demoph2025.sprintboot_demo_2025.model.Cliente;
import org.iesdm_demoph2025.sprintboot_demo_2025.model.Comercial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class SprintBootDemo2025ApplicationTests {

    @Autowired
    private ClienteDAOImpl clienteDAOImpl;
    @Autowired
    private ComercialDAOImpl comercialDAOImpl;


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


    @Test

    void testCreate(){
        Cliente cliente = Cliente.builder().nombre("José")
                .apellido1("Martin")
                .apellido2("Tejero")
                .ciudad("Malaga")
                .categoria(1)
                .build();

        System.out.println("Antes de crear el id " + cliente.getId());

        clienteDAOImpl.create(cliente);

        System.out.println("Despues de crear el id " + cliente.getId());




    }

    @Test
    void testUpdate(){

        Cliente cliente = Cliente.builder().nombre("José")
                .apellido1("Martin")
                .apellido2("Tejero")
                .ciudad("Malaga")
                .categoria(1)
                .build();


        clienteDAOImpl.create(cliente);
        cliente.setNombre("Jose Manuel");
        clienteDAOImpl.update(cliente);

        Optional<Cliente> optionalClienteReal = clienteDAOImpl.find(cliente.getId());

        if (optionalClienteReal.isPresent()){
            Assertions.assertEquals("Jose Manuel" , optionalClienteReal.get().getNombre());
        }
        else{
            Assertions.fail();
        }


    }




    @Test
    void testDelete(){

        Cliente cliente = Cliente.builder().nombre("José")
                .apellido1("Martin")
                .apellido2("Tejero")
                .ciudad("Malaga")
                .categoria(1)
                .build();

        clienteDAOImpl.create(cliente);

        clienteDAOImpl.delete(cliente.getId());



        Optional<Cliente> optionalClienteReal = clienteDAOImpl.find(cliente.getId());

        Assertions.assertTrue(optionalClienteReal.isEmpty());


    }




    //Test para COMERCIAL :
    @Test
    void testGetAllComercial(){

        List<Comercial> list = comercialDAOImpl.getAll();

        list.forEach(System.out::println);

    }

    @Test
    void tetsFindComercial(){

        Optional<Comercial> optionalComercial = comercialDAOImpl.find(11);

        if (optionalComercial.isPresent()){
            System.out.println(optionalComercial.get());
        }else{
            System.out.println("VACIOOO!!!");
        }
    }


    @Test

    void testCreateComercial(){
        Comercial comercial = Comercial.builder().nombre("Pablo Jose")
                .apellido1("Herrera")
                .apellido2("Cuevas")
                .comision(0.20f)
                .build();

        System.out.println("Antes de crear el id " + comercial.getId());

        comercialDAOImpl.create(comercial);

        System.out.println("Despues de crear el id " + comercial.getId());




    }

    @Test
    void testUpdateComercial(){

        Comercial comercial = Comercial.builder().nombre("Pablo Jose")
                .apellido1("Herrera")
                .apellido2("Cuevas")
                .comision(0.20f)
                .build();


        comercialDAOImpl.create(comercial);
        comercial.setNombre("Pablo Jose");
        comercialDAOImpl.update(comercial);

        Optional<Comercial> optionalComercialReal = comercialDAOImpl.find(comercial.getId());

        if (optionalComercialReal.isPresent()){
            Assertions.assertEquals("Pablo Jose" , optionalComercialReal.get().getNombre());
        }
        else{
            Assertions.fail();
        }


    }




    @Test
    void testDeleteComercial(){

        Comercial comercial = Comercial.builder().nombre("Pablo Jose")
                .apellido1("Herrera")
                .apellido2("Cuevas")
                .comision(0.20f)
                .build();

        comercialDAOImpl.create(comercial);

        comercialDAOImpl.delete(comercial.getId());



        Optional<Comercial> optionalComercialReal = comercialDAOImpl.find(comercial.getId());

        Assertions.assertTrue(optionalComercialReal.isEmpty());


    }

}
