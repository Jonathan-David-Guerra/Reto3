package edu.fincas.fincas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.fincas.fincas.model.Reserva;

public interface ReservaCrudRepository extends CrudRepository<Reserva,Long>{

    public List<Reserva> findAllByStartDateAfterAndDevolutionDateBefore(Date dateIni, Date dateFin);
    public List<Reserva> findAllByStatus(String status);

    @Query("select r.client, COUNT(r.client) from Reserva AS r group by r.client order by COUNT(r.client) desc")
    public List<Object[]> countTotalPapeleriaByCategoria();
}
