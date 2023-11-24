package com.appliction.rest.service.iimpl;

import com.appliction.rest.entities.Fabricante;
import com.appliction.rest.persistence.IFabricanteDAO;
import com.appliction.rest.service.IFabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FabricanteServiceImpl implements IFabricanteService {

    @Autowired
    private IFabricanteDAO fabricanteDAO;

    @Override
    public List<Fabricante> findAll() {
        return fabricanteDAO.finAll();
    }

    @Override
    public Optional<Fabricante> finById(Long id) {
        return fabricanteDAO.finById(id);
    }

    @Override
    public void save(Fabricante fabricante) {
        fabricanteDAO.save(fabricante);
    }

    @Override
    public void deleteById(Long id) {
        fabricanteDAO.deleteById(id);
    }
}
