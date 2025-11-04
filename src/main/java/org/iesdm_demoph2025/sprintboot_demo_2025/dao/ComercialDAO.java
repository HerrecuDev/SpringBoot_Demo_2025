package org.iesdm_demoph2025.sprintboot_demo_2025.dao;

import org.iesdm_demoph2025.sprintboot_demo_2025.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ComercialDAO {

    void create(Cliente cliente);

    List<Cliente> getAll();
    Optional<Cliente> find(int id);

    void update(Cliente cliente);

    void delete(int id);
}
