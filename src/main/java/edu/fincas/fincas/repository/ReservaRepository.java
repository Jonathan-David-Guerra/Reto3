package edu.fincas.fincas.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.fincas.fincas.model.Cliente;
import edu.fincas.fincas.model.ReportClients;
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

    public void borrarPorIdReserva(Long id){
        reservaCrudRepository.deleteById(id);
    }


    // Reto 5
    public List<Reserva> getReservasFechas(Date dateIni,Date dateFin){
        return reservaCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(dateIni, dateFin);
    }
    public List<Reserva> getReservasByStatus(String description){
        return reservaCrudRepository.findAllByStatus(description);
    }
    public List<ReportClients> getTopClientes(){
        List<ReportClients> res=new ArrayList<>();

        List<Object[]> report=reservaCrudRepository.countTotalPapeleriaByCategoria();
        for(int i=0;i<report.size();i++){
            res.add(new ReportClients((Long) report.get(i)[1],(Cliente)report.get(i)[0] ));
        }
        return res;
    }
}