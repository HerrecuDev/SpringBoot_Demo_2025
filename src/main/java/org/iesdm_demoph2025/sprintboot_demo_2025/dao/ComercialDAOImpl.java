package org.iesdm_demoph2025.sprintboot_demo_2025.dao;

import lombok.extern.slf4j.Slf4j;
import org.iesdm_demoph2025.sprintboot_demo_2025.model.Cliente;
import org.iesdm_demoph2025.sprintboot_demo_2025.model.Comercial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
                insert into cliente (nombre, apellido1, apellido2, ciudad, categoria)
                values (                  ?,         ?,         ?,       ?,         ?);
                
                
                """;


}

@Override
public List<Comercial> getAll() {
return List.of();
}

@Override
public Optional<Comercial> find(int id) {
return Optional.empty();
}

@Override
public void update(Comercial comercial) {

}

@Override
public void delete(int id) {

}
}


