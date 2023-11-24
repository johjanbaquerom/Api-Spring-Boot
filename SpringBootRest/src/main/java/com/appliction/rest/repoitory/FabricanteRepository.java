package com.appliction.rest.repoitory;

import com.appliction.rest.entities.Fabricante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends CrudRepository<Fabricante, Long> {
}
