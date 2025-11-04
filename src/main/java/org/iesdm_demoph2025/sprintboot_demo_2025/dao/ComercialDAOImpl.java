package org.iesdm_demoph2025.sprintboot_demo_2025.dao;

import lombok.extern.slf4j.Slf4j;
import org.iesdm_demoph2025.sprintboot_demo_2025.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;



@Slf4j

@Repository

public class ComercialDAOImpl implements ComercialDAO{


    @Override
    public void create(Cliente cliente) {

    }

    @Override
    public List<Cliente> getAll() {
        return List.of();
    }

    @Override
    public Optional<Cliente> find(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Cliente cliente) {

    }

    @Override
    public void delete(int id) {

    }
}
