package org.iesdm_demoph2025.sprintboot_demo_2025.dao;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.iesdm_demoph2025.sprintboot_demo_2025.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

//Anotacion lombok para logging(traza) de la aplicación
@Slf4j

//Un repositorio es un componente y a su vez es un estereotipo de Spring que forma parte de la capa de presistencia

@Repository


public class ClienteDAOImpl implements ClienteDAO{

    //Plantilla jbdc inyectada automaticamente por el framework Sprint , gracias a la anotacion @Autowired
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void create(Cliente cliente) {

        String sql = """
                insert into cliente (nombre, apellido1, apellido2, ciudad, categoria)
                values (                  ?,         ?,         ?,       ?,         ?);
                
                
                """;

    /*
        jdbcTemplate.update(sql ,
                                cliente.getNombre(),
                                cliente.getApellido1(),
                                cliente.getApellido2(),
                                cliente.getCiudad(),
                                cliente.getCategoria());
    */

/*Usando el valor del ID :*/
        String[] ids = {"id"};

                KeyHolder keyolder = new GeneratedKeyHolder();
                jdbcTemplate.update(con -> {

                    PreparedStatement ps  = con.prepareStatement(sql , ids);

                    ps.setString(1 , cliente.getNombre());
                    ps.setString(2 , cliente.getApellido1());
                    ps.setString(3 , cliente.getApellido2());
                    ps.setString(4 , cliente.getCiudad());
                    ps.setInt(5 , (cliente.getCategoria()));

                    return ps;

                }, keyolder);

                cliente.setId((int)keyolder.getKey().intValue());

    }

    @Override
    public List<Cliente> getAll() {

        List<Cliente> listClientes = jdbcTemplate.query("""
                                select *
                                from cliente c
                                
                        """,
                        ( rs , rowNum) -> new Cliente(

                                rs.getInt("id"),
                                rs.getString("nombre"),
                                rs.getString("apellido1"),
                                rs.getString("apellido2"),
                                rs.getString("ciudad"),
                                rs.getInt("categoria")
                                )

        );

        log.info("devueltos {} Clientes" , listClientes.size());
        log.debug("devueltos {} Clientes" , listClientes);

          return listClientes;
    }

    @Override
    public Optional<Cliente> find(int id) {

        try {
            Cliente cliente = jdbcTemplate.queryForObject("""
                select * from cliente
                where id = ?
               
               """ ,
                    (rs, rowNum) -> Cliente.builder()
                            .id(rs.getInt("id"))
                            .nombre(rs.getString("nombre"))
                            .apellido1(rs.getString("apellido1"))
                            .apellido2(rs.getString("apellido2"))
                            .ciudad(rs.getString("ciudad"))
                            .categoria(rs.getInt("categoria"))
                            .build()

                    ,
                    id
            );
            return Optional.of(cliente);
        }catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }

    }

    @Override
    public void update(Cliente cliente) {

       int roswUpdated = jdbcTemplate.update("""               
                UPDATE cliente
                SET nombre = ? ,apellido1 = ? , apellido2 = ? ,ciudad = ?, categoria = ?
                WHERE id = ?
                """
                , cliente.getNombre()
                ,cliente.getApellido1()
                , cliente.getApellido2()
                ,cliente.getCiudad()
                ,cliente.getCategoria()
                , cliente.getId());


        log.debug("Filas actualizadas {}" , roswUpdated);


    }

    @Override
    public void delete(int id) {

        int roswUpdated = jdbcTemplate.update("""
                DELETE FROM cliente
                
                WHERE id = ?

                """
                , id);


        log.debug("Filas actualizadas {}" , roswUpdated);

    }
}
