package edu.fincas.fincas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.fincas.fincas.model.Categoria;

@Repository
public class CategoriaRepository {
    
    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;

    public List<Categoria> getAllCategorias(){
        return (List<Categoria>) categoriaCrudRepository.findAll();
    }

    public Optional<Categoria> getCategoria(Long id){
        return categoriaCrudRepository.findById(id);
    }

    public Categoria saveCategoria(Categoria entityCategoria){
        return categoriaCrudRepository.save(entityCategoria);
    }
}
