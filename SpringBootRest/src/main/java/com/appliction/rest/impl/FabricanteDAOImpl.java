package com.appliction.rest.impl;

import com.appliction.rest.entities.Fabricante;
import com.appliction.rest.persistence.IFabricanteDAO;
import com.appliction.rest.repoitory.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FabricanteDAOImpl implements IFabricanteDAO {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Override
    public List<Fabricante> finAll() {
        return (List<Fabricante>) fabricanteRepository.findAll();
    }

    @Override
    public Optional<Fabricante> finById(Long id) {
        return fabricanteRepository.findById(id);
    }

    @Override
    public void save(Fabricante fabricante) {
        fabricanteRepository.save(fabricante);
    }

    @Override
    public void deleteById(Long id) {
        fabricanteRepository.deleteById(id);
    }
}
