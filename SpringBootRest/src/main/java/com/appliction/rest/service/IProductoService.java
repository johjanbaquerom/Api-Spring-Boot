package com.appliction.rest.service;

import com.appliction.rest.entities.Producto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductoService {

    List<Producto> findAll();

    Optional<Producto> finById(Long id);

    List<Producto> finByPriceInRange(BigDecimal mixPrice, BigDecimal maxPrice);

    void save(Producto producto);

    void deleteById(Long id);
}
