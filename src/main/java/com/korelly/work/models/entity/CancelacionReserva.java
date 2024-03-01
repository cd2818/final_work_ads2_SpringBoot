package com.korelly.work.models.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cancelacion_reserva")
public class CancelacionReserva implements Serializable {

    private static final long serialVersionUID =1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cancelacion")
    private Long id_cancelacion;

    @Column(name = "cod_cancelacion")
    private String cod_cancelacion;

    @Column(name = "fecha_cancelacion")
    private Date fecha_cancelacion;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mot_cancelacion")
    private MotivoCancelacion motivo_cancelacion;
    
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reserva")
    private ReservaMesa reserva_mesa;

    public CancelacionReserva(String cod_cancelacion, Date fecha_cancelacion, MotivoCancelacion motivo_cancelacion,
            ReservaMesa reserva_mesa) {
        this.cod_cancelacion = cod_cancelacion;
        this.fecha_cancelacion = fecha_cancelacion;
        this.motivo_cancelacion = motivo_cancelacion;
        this.reserva_mesa = reserva_mesa;
    }

    public CancelacionReserva() {
    }

    public Long getId_cancelacion() {
        return id_cancelacion;
    }

    public void setId_cancelacion(Long id_cancelacion) {
        this.id_cancelacion = id_cancelacion;
    }

    public String getCod_cancelacion() {
        return cod_cancelacion;
    }

    public void setCod_cancelacion(String cod_cancelacion) {
        this.cod_cancelacion = cod_cancelacion;
    }

    public Date getFecha_cancelacion() {
        return fecha_cancelacion;
    }

    public void setFecha_cancelacion(Date fecha_cancelacion) {
        this.fecha_cancelacion = fecha_cancelacion;
    }

    public MotivoCancelacion getMotivo_cancelacion() {
        return motivo_cancelacion;
    }

    public void setMotivo_cancelacion(MotivoCancelacion motivo_cancelacion) {
        this.motivo_cancelacion = motivo_cancelacion;
    }

    public ReservaMesa getReserva_mesa() {
        return reserva_mesa;
    }

    public void setReserva_mesa(ReservaMesa reserva_mesa) {
        this.reserva_mesa = reserva_mesa;
    }

    

}
