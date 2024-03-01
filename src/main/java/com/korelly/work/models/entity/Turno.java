package com.korelly.work.models.entity;


import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Turno implements Serializable {

    private static final long serialVersionUID =1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    private Long id_turno;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "turno")
    private List<Empleado> empleados;

    public Turno() {
    }

    public Turno(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Long getId_turno() {
        return id_turno;
    }
    public void setId_turno(Long id_turno) {
        this.id_turno = id_turno;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
