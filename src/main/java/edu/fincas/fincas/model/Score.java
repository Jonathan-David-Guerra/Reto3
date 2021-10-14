package edu.fincas.fincas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="scores")
public class Score {
    
    @Id
    private Long id;

    @OneToOne
    private Reserva reservation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reserva getReservation() {
        return reservation;
    }

    public void setReservation(Reserva reservation) {
        this.reservation = reservation;
    }

    
}
