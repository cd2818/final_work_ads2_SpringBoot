package com.korelly.work.models.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "mesa")
public class Mesa implements Serializable {

    private static final long serialVersionUID =1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mesa")
    private Long id_mesa;

    @Column(name = "nro_mesa")
    private String nro_mesa;

    @Column(name = "capacidad")
    private Integer capacidad;
    
    @Column(name = "estado")
    private String estado;



    @OneToMany(mappedBy = "mesa")
    private List<ReservaMesa> reservas_mesas;



    public Mesa() {
    }


    public Mesa(String nro_mesa, Integer capacidad, String estado) {
        this.nro_mesa = nro_mesa;
        this.capacidad = capacidad;
        this.estado = estado;
    }


    public Long getId_mesa() {
        return id_mesa;
    }


    public void setId_mesa(Long id_mesa) {
        this.id_mesa = id_mesa;
    }


    public String getNro_mesa() {
        return nro_mesa;
    }


    public void setNro_mesa(String nro_mesa) {
        this.nro_mesa = nro_mesa;
    }


    public Integer getCapacidad() {
        return capacidad;
    }


    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }

    

    

    

}
