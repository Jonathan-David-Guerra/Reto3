package edu.fincas.fincas.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fincas.fincas.model.ReportClients;
import edu.fincas.fincas.model.ReportStatus;
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
/// Implementaciones Reto 5
    public List<Reserva> getReservasFechas(String ini, String fin){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne=new Date();
        Date dateTwo=new Date();
        try {
            dateOne=parser.parse(ini);
            dateTwo=parser.parse(fin);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        if(dateOne.before(dateTwo)){
            return reservaRepository.getReservasFechas(dateOne,dateTwo);
        }else{
            return new ArrayList<>();
        }
    }

    public ReportStatus getReporteStatus(){
        List<Reserva> completed=reservaRepository.getReservasByStatus("completed");
        List<Reserva> cancelled=reservaRepository.getReservasByStatus("cancelled");

        ReportStatus descAmt=new ReportStatus(completed.size(),cancelled.size());
        return descAmt;
    }
    public List<ReportClients> getTopClientes(){
        return reservaRepository.getTopClientes();
    }
}