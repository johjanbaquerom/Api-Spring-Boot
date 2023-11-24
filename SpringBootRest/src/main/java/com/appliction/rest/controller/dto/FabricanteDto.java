package com.appliction.rest.controller.dto;

import com.appliction.rest.entities.Producto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FabricanteDto {

    private Long id;
    private String nombre;
    private List<Producto> productoList = new ArrayList<>();
}
