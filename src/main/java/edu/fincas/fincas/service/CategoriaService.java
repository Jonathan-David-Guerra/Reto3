package edu.fincas.fincas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fincas.fincas.model.Categoria;
import edu.fincas.fincas.repository.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getCategorias(){
        return categoriaRepository.getAllCategorias();
    }

    public Categoria guardarCategoria(Categoria categoria){
    
        if (categoria != null){
            if (categoria.getId() != null){
                Optional<Categoria> optional = categoriaRepository.getCategoria(categoria.getId());
                if(optional.isEmpty()){
                    return categoriaRepository.saveCategoria(categoria);
                }else{
                    return categoria;
                }
            }else{
                return categoriaRepository.saveCategoria(categoria);
            }
        }
        
        return null;
    }
}
