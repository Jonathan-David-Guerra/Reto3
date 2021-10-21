package edu.fincas.fincas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fincas.fincas.model.Finca;
import edu.fincas.fincas.repository.FincaRepository;

@Service
public class FincaService {
    
    @Autowired
    private FincaRepository fincaRepository;

    public List<Finca> getFincas(){
        return fincaRepository.getAllFincas();
    }

    public Finca guardarFinca(Finca finca){
    
        if (finca != null){
            if (finca.getId() != null){
                Optional<Finca> optional = fincaRepository.getFinca(finca.getId());
                if(optional.isEmpty()){
                    return fincaRepository.saveFinca(finca);
                }else{
                    return finca;
                }
            }else{
                return fincaRepository.saveFinca(finca);
            }
        }
        
        return null;
    }



    public Finca actualizar(Finca finca) {
        if(finca.getId() != null){
            Optional<Finca> oFinca = fincaRepository.getFinca(finca.getId());
            if(!oFinca.isEmpty()){
                Finca f = oFinca.get();
                

                if(finca.getName()!= null){
                    f.setName(finca.getName());
                }

                if(finca.getAddress() != null){
                    f.setAddress(finca.getAddress());
                }

                if(finca.getExtension() != null){
                    f.setExtension(finca.getExtension());
                }

                if(finca.getDescription()!= null){
                    f.setDescription(finca.getDescription());
                }

                if(finca.getCategory() != null){
                    f.setCategory(finca.getCategory());
                }
                
                if(finca.getMessages() != null){
                    f.setMessages(finca.getMessages());
                }

                if(finca.getReservations() != null){
                    f.setReservations(finca.getReservations());
                }

                return fincaRepository.saveFinca(f);
            }else{
                return finca;
            }
        }else{
            return finca;
        }
    }

    public Optional<Finca> getFinca(Long id){
        return fincaRepository.getFinca(id);
    }

    public boolean borrarFinca(Long id){
        Boolean borrado =  getFinca(id).map(c -> {
            fincaRepository.borrarPorIdFinca(id);
            return true;
        }).orElse(false);
        return borrado;
    
    }

}
