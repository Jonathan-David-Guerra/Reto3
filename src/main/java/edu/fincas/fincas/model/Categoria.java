package edu.fincas.fincas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categorias")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="NOMBRE", nullable = false,length = 45)
    private String nombre;

    @Column(name="DESCRIPCION", nullable = false,length = 250)
    private String descripcion;
}
