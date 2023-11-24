package com.appliction.rest.controller;

import com.appliction.rest.controller.dto.FabricanteDto;
import com.appliction.rest.entities.Fabricante;
import com.appliction.rest.service.IFabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/fabricante")
public class FabricanteController {

    @Autowired
    private IFabricanteService fabricanteService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> finById(@PathVariable Long id){
        Optional<Fabricante> fabricanteOptional = fabricanteService.finById(id);

        if(fabricanteOptional.isPresent()){
            Fabricante fabricante = fabricanteOptional.get();

            FabricanteDto fabricanteDto = FabricanteDto.builder()
                    .id(fabricante.getId())
                    .nombre(fabricante.getNombre())
                    .productoList(fabricante.getProductoList())
                    .build();

            return ResponseEntity.ok(fabricanteDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/finall")
    public ResponseEntity<?> findAll(){
        List<FabricanteDto> fabricanteDtoList = fabricanteService.findAll()
                .stream()
                .map(fabricante -> FabricanteDto.builder()
                        .id(fabricante.getId())
                        .nombre(fabricante.getNombre())
                        .productoList(fabricante.getProductoList())
                        .build())
                .toList();
        return ResponseEntity.ok(fabricanteDtoList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody FabricanteDto fabricanteDto) throws URISyntaxException {

        if(fabricanteDto.getNombre().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        fabricanteService.save(Fabricante.builder().nombre(fabricanteDto.getNombre()).build());

        return ResponseEntity.created(new URI("/api/fabricante/save")).build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody FabricanteDto fabricanteDto){

        Optional<Fabricante> fabricanteOptional = fabricanteService.finById(id);

        if(fabricanteOptional.isPresent()){
            Fabricante fabricante = fabricanteOptional.get();
            fabricante.setNombre(fabricanteDto.getNombre());
            fabricanteService.save(fabricante);

            return ResponseEntity.ok("Servicio actualizado");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){

        if(id != null){
            fabricanteService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }

        return ResponseEntity.badRequest().build();
    }
}
