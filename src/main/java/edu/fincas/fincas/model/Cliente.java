package edu.fincas.fincas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 4000)
    private String name;

    @Column(name = "EMAIL", nullable = false, length = 20)
    private String email;

    @Column(name = "AGE", nullable = false)
    private Integer age;
}
