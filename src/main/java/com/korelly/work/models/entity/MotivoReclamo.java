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
@Table(name = "motivo_reclamo")
public class MotivoReclamo implements Serializable {

    private static final long serialVersionUID =1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mot_reclamo")
    private Long id_motivo_reclamo;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "motivo_reclamo")
    private List<Reclamo> reclamos;



    public MotivoReclamo() {
    }


    public MotivoReclamo(String descripcion, List<Reclamo> reclamos) {
        this.descripcion = descripcion;
        this.reclamos = reclamos;
    }


    public Long getId_motivo_reclamo() {
        return id_motivo_reclamo;
    }


    public void setId_motivo_reclamo(Long id_motivo_reclamo) {
        this.id_motivo_reclamo = id_motivo_reclamo;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public List<Reclamo> getReclamos() {
        return reclamos;
    }


    public void setReclamos(List<Reclamo> reclamos) {
        this.reclamos = reclamos;
    }

    

    

}
