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



    public Mensaje actualizar(Mensaje mensaje) {
        if(mensaje.getIdMessage() != null){
            Optional<Mensaje> oMensaje = mensajeRepository.getMensaje(mensaje.getIdMessage());
            
            if(!oMensaje.isEmpty()){
                Mensaje m = oMensaje.get();

                if(mensaje.getMessageText()!= null){
                    m.setMessageText(mensaje.getMessageText());
                }
                if(mensaje.getFarm()!= null){
                    m.setFarm(mensaje.getFarm());
                }
                if(mensaje.getClient() != null){
                    m.setClient(mensaje.getClient());
                }
                
                return mensajeRepository.saveMensaje(m);
            }else{
                return mensaje;
            }
        }else{
            return mensaje;
        }
    }

    public Optional<Mensaje> getMensaje(Long id){
        return mensajeRepository.getMensaje(id);
    }

    public boolean borrarMensaje(Long id){
        Boolean borrado =  getMensaje(id).map(c -> {
            mensajeRepository.borrarPorIdMensaje(id);
            return true;
        }).orElse(false);
        return borrado;
    
    }
}