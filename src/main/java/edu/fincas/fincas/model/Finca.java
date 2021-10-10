package edu.fincas.fincas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fincas")
public class Finca{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    
    @Column(name="ADDRESS", nullable = false, length = 20)
    private String address;

    @Column(name="EXENSION", nullable = false)
    private Integer exension;

    @Column(name="CATEGORY_ID", nullable = false)
    private Integer categoryId;

    @Column(name="NAME", nullable = false, length = 400)
    private String name;

    
}
