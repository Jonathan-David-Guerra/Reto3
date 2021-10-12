package edu.fincas.fincas.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="reservas")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    //@JsonFormat(pattern="yyyy-MM-dd")
    private String startDate;

    //@JsonFormat(pattern="yyyy-MM-dd")
    private String devolutionDate;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties("reservations")
    private Cliente client;

    @ManyToOne
    private Finca farm;



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDevolutionDate() {
        return this.devolutionDate;
    }

    public void setDevolutionDate(String devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public Cliente getClient() {
        return this.client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public Finca getFarm() {
        return this.farm;
    }

    public void setFarm(Finca farm) {
        this.farm = farm;
    }

    
}
