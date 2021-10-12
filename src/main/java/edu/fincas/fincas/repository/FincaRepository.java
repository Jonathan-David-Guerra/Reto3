package edu.fincas.fincas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.fincas.fincas.model.Finca;

@Repository
public class FincaRepository {
    
    @Autowired
    private FincaCrudRepository fincaCrudRepository;

    public List<Finca> getAllFincas(){
        return (List<Finca>) fincaCrudRepository.findAll();
    }

    public Optional<Finca> getFinca(Long id){
        return fincaCrudRepository.findById(id);
    }

    public Finca saveFinca(Finca entityFinca){
        return fincaCrudRepository.save(entityFinca);
    }
}
