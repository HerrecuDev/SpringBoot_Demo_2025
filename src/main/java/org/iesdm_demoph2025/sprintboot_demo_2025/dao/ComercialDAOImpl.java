package org.iesdm_demoph2025.sprintboot_demo_2025.dao;

import lombok.extern.slf4j.Slf4j;
import org.iesdm_demoph2025.sprintboot_demo_2025.model.Cliente;
import org.iesdm_demoph2025.sprintboot_demo_2025.model.Comercial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import static java.time.chrono.JapaneseEra.values;


@Slf4j

@Repository

public class ComercialDAOImpl implements ComercialDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void create(Comercial comercial) {

        String sql = """
                insert into cliente (nombre, apellido1, apellido2, comision)
                values (                  ?,         ?,         ?,         ?);
                
                
                """;

        String[] ids = {"id"};

        KeyHolder keyolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {

            PreparedStatement ps  = con.prepareStatement(sql , ids);

            ps.setString(1 , comercial.getNombre());
            ps.setString(2 , comercial.getApellido1());
            ps.setString(3 , comercial.getApellido2());
            ps.setFloat(4 , comercial.getComision());

            return ps;

        }, keyolder);

        comercial.setId((int)keyolder.getKey().intValue());

    }

    @Override
    public List<Comercial> getAll() {
        List<Comercial> listComercial = jdbcTemplate.query("""
                                    select *
                                    from comercial c
                                    
                            """,
                ( rs , rowNum) -> new Comercial(

                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getFloat("comision")
                )

        );

        log.info("devueltos {} Clientes" , listComercial.size());
        log.debug("devueltos {} Clientes" , listComercial);

        return listComercial;

    }

    @Override
    public Optional<Comercial> find(int id) {
        try {
            Comercial comercial = jdbcTemplate.queryForObject("""
                  
                  select * from comercial
                  where id = ?          
                  
                            
                            """,

                    (rs, rowNum) -> Comercial.builder()
                            .id(rs.getInt("id"))
                            .nombre(rs.getString("nombre"))
                            .apellido1(rs.getString("apellido1"))
                            .apellido2(rs.getString("apellido2"))
                            .comision(rs.getFloat("comision"))
                            .build()

                    ,
                    id

            );
            return Optional.of(comercial);

        }catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }

    @Override
    public void update(Comercial comercial) {

            int roswUpdated = jdbcTemplate.update("""
    
                    UPDATE comercial
                    SET nombre =? , apellido1 = ? ,apellido2 = ? , comision = ?
                    WHERE id = ?
    
                    
                    """

                    , comercial.getNombre()
                    ,comercial.getApellido1()
                    ,comercial.getApellido2()
                    ,comercial.getComision()
                    ,comercial.getId());

            log.debug("Filas actualizadas {}" , roswUpdated);

    }

    @Override
    public void delete(int id) {

            int roswUpdated = jdbcTemplate.update("""
    
                    DELETE FROM comercial
                    WHERE id = ?
                    
                    
                    """
                    , id);


                    log.debug("Filas actualizadas {}" , roswUpdated);


    }
}


