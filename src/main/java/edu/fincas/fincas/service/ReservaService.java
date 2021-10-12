package edu.fincas.fincas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fincas.fincas.model.Reserva;
import edu.fincas.fincas.repository.ReservaRepository;

@Service
public class ReservaService {
    
    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> getReservas(){
        return reservaRepository.getAllReservas();
    }

    public Reserva guardarReserva(Reserva reserva){
    
        if (reserva != null){
            if (reserva.getId() != null){
                Optional<Reserva> optional = reservaRepository.getReserva(reserva.getId());
                if(optional.isEmpty()){
                    return reservaRepository.saveReserva(reserva);
                }else{
                    return reserva;
                }
            }else{
                return reservaRepository.saveReserva(reserva);
            }
        }
        
        return null;
    }
}
