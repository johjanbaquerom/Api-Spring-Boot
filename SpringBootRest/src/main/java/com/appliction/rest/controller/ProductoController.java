package com.appliction.rest.controller;

import com.appliction.rest.controller.dto.FabricanteDto;
import com.appliction.rest.controller.dto.ProductoDto;
import com.appliction.rest.entities.Fabricante;
import com.appliction.rest.entities.Producto;
import com.appliction.rest.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> finById(@PathVariable Long id){
        Optional<Producto> productoOptional = productoService.finById(id);

        if(productoOptional.isPresent()){
            Producto producto = productoOptional.get();

            ProductoDto productoDto = ProductoDto.builder()
                    .id(producto.getId())
                    .nombre(producto.getNombre())
                    .precio(producto.getPrecio())
                    .fabricante(producto.getFabricante())
                    .build();

            return ResponseEntity.ok(productoDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/finall")
    public ResponseEntity<?> findAll(){
        List<ProductoDto> productoDtoList = productoService.findAll()
                .stream()
                .map(producto -> ProductoDto.builder()
                        .id(producto.getId())
                        .nombre(producto.getNombre())
                        .precio(producto.getPrecio())
                        .fabricante(producto.getFabricante())
                        .build())
                .toList();
        return ResponseEntity.ok(productoDtoList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductoDto productoDto) throws URISyntaxException {

        if(productoDto.getNombre().isBlank() || productoDto.getPrecio() == null || productoDto.getFabricante() == null){
            return ResponseEntity.badRequest().build();
        }

        Producto producto = Producto.builder()
                .nombre(productoDto.getNombre())
                .precio(productoDto.getPrecio())
                .fabricante(productoDto.getFabricante())
                .build();
        productoService.save(producto);

        return ResponseEntity.created(new URI("/api/producto/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductoDto productoDto){

        Optional<Producto> productoOptional = productoService.finById(id);

        if(productoOptional.isPresent()){
            Producto producto = productoOptional.get();
            producto.setNombre(productoDto.getNombre());
            producto.setPrecio(productoDto.getPrecio());
            producto.setFabricante(productoDto.getFabricante());
            productoService.save(producto);

            return ResponseEntity.ok("Servicio actualizado");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){

        if(id != null){
            productoService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }

        return ResponseEntity.badRequest().build();
    }
}
