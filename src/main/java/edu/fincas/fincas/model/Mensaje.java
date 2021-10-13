package edu.fincas.fincas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="mensajes")
public class Mensaje {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMessage;

    @Column(name = "MESSAGETEXT", length = 250)
    private String messageText;

    @ManyToOne
    @JsonIgnoreProperties({"messages","reservations"})
    private Finca farm;

    @ManyToOne
    @JsonIgnoreProperties({"messages","reservations"})
    private Cliente client;

    public Finca getFarm() {
        return this.farm;
    }

    public void setFarm(Finca farm) {
        this.farm = farm;
    }


    public Cliente getClient() {
        return this.client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public Long getIdMessage() {
        return this.idMessage;
    }

    public void setIdMessage(Long idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return this.messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

 
}
