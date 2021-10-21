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



    public Categoria actualizar(Categoria categoria) {
        if(categoria.getId() != null){
            Optional<Categoria> oCategoria = categoriaRepository.getCategoria(categoria.getId());
            if(!oCategoria.isEmpty()){
                Categoria c = oCategoria.get();
                if(categoria.getName()!= null){
                    c.setName(categoria.getName());
                }
                if(categoria.getDescription()!= null){
                    c.setDescription(categoria.getDescription());
                }
                if(categoria.getFarms() != null){
                    c.setDescription(categoria.getDescription());
                }
                
                return categoriaRepository.saveCategoria(c);
            }else{
                return categoria;
            }
        }else{
            return categoria;
        }
    }

    public Optional<Categoria> getCategoria(Long id){
        return categoriaRepository.getCategoria(id);
    }

    public boolean borrarCategoria(Long id){
        Boolean borrado =  getCategoria(id).map(c -> {
            categoriaRepository.borrarPorIdCategoria(id);
            return true;
        }).orElse(false);
        return borrado;
    
    }

}
