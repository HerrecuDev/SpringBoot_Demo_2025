package org.iesdm_demoph2025.sprintboot_demo_2025.dao;

import org.iesdm_demoph2025.sprintboot_demo_2025.model.Comercial;

import java.util.List;
import java.util.Optional;

public interface ComercialDAO {

    void create(Comercial comercial);

    List<Comercial> getAll();
    Optional<Comercial> find(int id);

    void update(Comercial comercial);

    void delete(int id);
}
