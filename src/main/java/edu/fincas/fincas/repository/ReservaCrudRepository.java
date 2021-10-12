package edu.fincas.fincas.repository;

import org.springframework.data.repository.CrudRepository;

import edu.fincas.fincas.model.Reserva;

public interface ReservaCrudRepository extends CrudRepository<Reserva,Long>{
    
}
