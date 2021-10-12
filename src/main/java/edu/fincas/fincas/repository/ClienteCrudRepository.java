package edu.fincas.fincas.repository;

import org.springframework.data.repository.CrudRepository;

import edu.fincas.fincas.model.Cliente;

public interface ClienteCrudRepository extends CrudRepository<Cliente,Long>{
    
}
