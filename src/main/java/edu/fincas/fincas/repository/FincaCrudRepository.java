package edu.fincas.fincas.repository;

import org.springframework.data.repository.CrudRepository;

import edu.fincas.fincas.model.Finca;

public interface FincaCrudRepository extends CrudRepository<Finca,Long> {
    
}
