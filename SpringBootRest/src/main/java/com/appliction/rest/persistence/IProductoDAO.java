package com.appliction.rest.persistence;

import com.appliction.rest.entities.Producto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductoDAO {

    List<Producto> finAll();

    Optional<Producto> finById(Long id);

    List<Producto> finByPriceInRange(BigDecimal mixPrice, BigDecimal maxPrice);

    void save(Producto producto);

    void deleteById(Long id);
}
