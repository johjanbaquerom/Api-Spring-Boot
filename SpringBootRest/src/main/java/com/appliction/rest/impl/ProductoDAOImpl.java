package com.appliction.rest.impl;

import com.appliction.rest.entities.Producto;
import com.appliction.rest.persistence.IProductoDAO;
import com.appliction.rest.repoitory.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ProductoDAOImpl implements IProductoDAO {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> finAll() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public Optional<Producto> finById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public List<Producto> finByPriceInRange(BigDecimal mixPrice, BigDecimal maxPrice) {
        return productoRepository.findProductoByPriceInRange(mixPrice, maxPrice);
    }

    @Override
    public void save(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}
