package edu.fincas.fincas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.fincas.fincas.model.Mensaje;

@Repository
public class MensajeRepository {
    
    @Autowired
    private MensajeCrudRepository mensajeCrudRepository;

    public List<Mensaje> getAllMensajes(){
        return (List<Mensaje>) mensajeCrudRepository.findAll();
    }

    public Optional<Mensaje> getMensaje(Long id){
        return mensajeCrudRepository.findById(id);
    }

    public Mensaje saveMensaje(Mensaje entityMensaje){
        return mensajeCrudRepository.save(entityMensaje);
    }

    public void borrarPorIdMensaje(Long id){
        mensajeCrudRepository.deleteById(id);
    }
}
