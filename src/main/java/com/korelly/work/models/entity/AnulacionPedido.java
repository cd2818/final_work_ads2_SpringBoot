package com.korelly.work.models.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

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
@Table(name = "anulacion_pedido")
public class AnulacionPedido implements Serializable {

    private static final long serialVersionUID =1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anulacion_pedido")
    private Long id_anulacion_pedido;

    @Column(name = "fecha_anulacion")
    private Date fecha_anulacion;

    @Column(name = "hora_anulacion")
    private Time hora_anulacion;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reclamo")
    private Reclamo reclamo;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    public AnulacionPedido(Date fecha_anulacion, Time hora_anulacion, Reclamo reclamo, Pedido pedido) {
        this.fecha_anulacion = fecha_anulacion;
        this.hora_anulacion = hora_anulacion;
        this.reclamo = reclamo;
        this.pedido = pedido;
    }

    public AnulacionPedido() {
    }

    public Long getId_anulacion_pedido() {
        return id_anulacion_pedido;
    }

    public void setId_anulacion_pedido(Long id_anulacion_pedido) {
        this.id_anulacion_pedido = id_anulacion_pedido;
    }

    public Date getFecha_anulacion() {
        return fecha_anulacion;
    }

    public void setFecha_anulacion(Date fecha_anulacion) {
        this.fecha_anulacion = fecha_anulacion;
    }

    public Time getHora_anulacion() {
        return hora_anulacion;
    }

    public void setHora_anulacion(Time hora_anulacion) {
        this.hora_anulacion = hora_anulacion;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    

}
