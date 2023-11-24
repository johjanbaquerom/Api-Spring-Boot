package com.appliction.rest.persistence;

import com.appliction.rest.entities.Fabricante;

import java.util.List;
import java.util.Optional;

public interface IFabricanteDAO {

    List<Fabricante> finAll();
    Optional<Fabricante> finById(Long id);

    void save(Fabricante fabricante);

    void deleteById(Long id);
}
