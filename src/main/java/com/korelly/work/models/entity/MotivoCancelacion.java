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
@Table(name = "motivo_cancelacion")
public class MotivoCancelacion implements Serializable {

    private static final long serialVersionUID =1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mot_cancelacion")    
    private Long id_mot_cancelacion;

    @Column(name = "descripcion")
    private String descripcion;


    @OneToMany(mappedBy = "motivo_cancelacion")
    private List<CancelacionReserva> cancelaciones_reservas;

    

    
    public MotivoCancelacion(String descripcion) {
        this.descripcion = descripcion;
    }




    public Long getId_mot_cancelacion() {
        return id_mot_cancelacion;
    }


    public void setId_mot_cancelacion(Long id_mot_cancelacion) {
        this.id_mot_cancelacion = id_mot_cancelacion;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public List<CancelacionReserva> getCancelaciones_reservas() {
        return cancelaciones_reservas;
    }


    public void setCancelaciones_reservas(List<CancelacionReserva> cancelaciones_reservas) {
        this.cancelaciones_reservas = cancelaciones_reservas;
    }

    


    
}
