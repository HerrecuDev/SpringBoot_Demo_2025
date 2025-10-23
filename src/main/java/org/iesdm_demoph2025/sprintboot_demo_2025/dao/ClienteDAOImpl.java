package org.iesdm_demoph2025.sprintboot_demo_2025.dao;

import org.iesdm_demoph2025.sprintboot_demo_2025.model.Cliente;

import java.util.List;
import java.util.Optional;

public class ClienteDAOImpl implements ClienteDAO{
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
        System.out.println();

    }

    @Override
    public void delete(int id) {

    }
}
