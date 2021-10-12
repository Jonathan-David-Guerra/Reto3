package edu.fincas.fincas.repository;

import org.springframework.data.repository.CrudRepository;

import edu.fincas.fincas.model.Categoria;

public interface CategoriaCrudRepository extends CrudRepository<Categoria,Long>{
    
}
