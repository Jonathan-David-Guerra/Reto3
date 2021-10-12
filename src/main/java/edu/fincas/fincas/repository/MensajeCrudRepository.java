package edu.fincas.fincas.repository;

import org.springframework.data.repository.CrudRepository;

import edu.fincas.fincas.model.Mensaje;

public interface MensajeCrudRepository extends CrudRepository<Mensaje,Long>{
    
}
