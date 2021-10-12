package edu.fincas.fincas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.fincas.fincas.model.Reserva;

@Repository
public class ReservaRepository {
    
    @Autowired
    private ReservaCrudRepository reservaCrudRepository;

    public List<Reserva> getAllReservas(){
        return (List<Reserva>) reservaCrudRepository.findAll();
    }

    public Optional<Reserva> getReserva(Long id){
        return reservaCrudRepository.findById(id);
    }

    public Reserva saveReserva(Reserva entityReserva){
        return reservaCrudRepository.save(entityReserva);
    }
}
