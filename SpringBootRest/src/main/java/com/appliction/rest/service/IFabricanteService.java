package com.appliction.rest.service;

import com.appliction.rest.entities.Fabricante;

import java.util.List;
import java.util.Optional;

public interface IFabricanteService {

    List<Fabricante> findAll();
    Optional<Fabricante> finById(Long id);

    void save(Fabricante fabricante);

    void deleteById(Long id);
}
