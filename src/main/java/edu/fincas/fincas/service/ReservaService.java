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
            if (reserva.getIdReservation() != null){
                Optional<Reserva> optional = reservaRepository.getReserva(reserva.getIdReservation());
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



    public Reserva actualizar(Reserva reserva) {
        if(reserva.getIdReservation() != null){
            Optional<Reserva> oReserva = reservaRepository.getReserva(reserva.getIdReservation());
            if(!oReserva.isEmpty()){
                Reserva r = oReserva.get();
                
                if(reserva.getStartDate()!= null){
                    r.setStartDate(reserva.getStartDate());
                }
                if(reserva.getDevolutionDate()!= null){
                    r.setDevolutionDate(reserva.getDevolutionDate());
                }
                if(reserva.getStatus() != null){
                    r.setStatus(reserva.getStatus());
                }
                if(reserva.getStatus() != null){
                    r.setStatus(reserva.getStatus());
                }
                if(reserva.getFarm() != null){
                    r.setFarm(reserva.getFarm());
                }
                if(reserva.getClient() != null){
                    r.setClient(reserva.getClient());
                }
                if(reserva.getScore() != null){
                    r.setScore(reserva.getScore());
                }

                return reservaRepository.saveReserva(r);

            }else{
                return reserva;
            }
        }else{
            return reserva;
        }
    }

    public Optional<Reserva> getReserva(Long id){
        return reservaRepository.getReserva(id);
    }

    public boolean borrarReserva(Long id){
        Boolean borrado =  getReserva(id).map(c -> {
            reservaRepository.borrarPorIdReserva(id);
            return true;
        }).orElse(false);
        return borrado;
    
    }
}