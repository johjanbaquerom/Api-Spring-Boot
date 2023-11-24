package com.appliction.rest.service.iimpl;

import com.appliction.rest.entities.Producto;
import com.appliction.rest.persistence.IProductoDAO;
import com.appliction.rest.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoDAO productoDAO;

    @Override
    public List<Producto> findAll() {
        return productoDAO.finAll();
    }

    @Override
    public Optional<Producto> finById(Long id) {
        return productoDAO.finById(id);
    }

    @Override
    public List<Producto> finByPriceInRange(BigDecimal mixPrice, BigDecimal maxPrice) {
        return productoDAO.finByPriceInRange(mixPrice, maxPrice);
    }

    @Override
    public void save(Producto producto) {
        productoDAO.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoDAO.deleteById(id);
    }
}
