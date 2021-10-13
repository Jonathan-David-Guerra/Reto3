package edu.fincas.fincas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="fincas")
public class Finca{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="NAME", length = 45)
    private String name; 

    @Column(name="ADDRESS",length = 45)
    private String address;

    @Column(name="EXENSION")
    private Integer extension;

    @Column(name="descripcion", length = 250)
    private String description;

    @ManyToOne
    @JoinColumn(name="CATEGORY")
    @JsonIgnoreProperties("farms")
    private Categoria category;

    @OneToMany
    private List<Mensaje> messages;


    @OneToMany
    private List<Reserva> reservations;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getExtension() {
        return this.extension;
    }

    public void setExtension(Integer extension) {
        this.extension = extension;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categoria getCategory() {
        return this.category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public List<Mensaje> getMessages() {
        return this.messages;
    }

    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    public List<Reserva> getReservations() {
        return this.reservations;
    }

    public void setReservations(List<Reserva> reservations) {
        this.reservations = reservations;
    }


}
