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
}
