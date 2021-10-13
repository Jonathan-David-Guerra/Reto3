package edu.fincas.fincas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fincas.fincas.model.Mensaje;
import edu.fincas.fincas.repository.MensajeRepository;

@Service
public class MensajeService {
    
    @Autowired
    private MensajeRepository mensajeRepository;

    public List<Mensaje> getMensajes(){
        return mensajeRepository.getAllMensajes();
    }

    public Mensaje guardaMensajee(Mensaje mensaje){
    
        if (mensaje != null){
            if (mensaje.getIdMessage() != null){
                Optional<Mensaje> optional = mensajeRepository.getMensaje(mensaje.getIdMessage());
                if(optional.isEmpty()){
                    return mensajeRepository.saveMensaje(mensaje);
                }else{
                    return mensaje;
                }
            }else{
                return mensajeRepository.saveMensaje(mensaje);
            }
        }
        
        return null;
    }
}
