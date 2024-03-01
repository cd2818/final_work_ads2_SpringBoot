package com.korelly.work.models.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID =1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long id_pedido;

    @Column(name = "fecha_pedido")
    private Date fecha_pedido;

    @Column(name = "hora_pedido")
    private Time hora_pedido;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cocinero")
    private Cocinero cocinero;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bebida")
    private Bebida bebida;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plato")
    private Plato plato;

    @OneToMany(mappedBy = "pedido")
    private List<Reclamo> reclamos;

    @OneToMany(mappedBy = "pedido")
    private List<AnulacionPedido> anulaciones;
    
    
    public Pedido() {
    }


    public Pedido(Date fecha_pedido, Time hora_pedido, String estado, Cocinero cocinero, Bebida bebida, Plato plato,
            List<Reclamo> reclamos, List<AnulacionPedido> anulaciones) {
        this.fecha_pedido = fecha_pedido;
        this.hora_pedido = hora_pedido;
        this.estado = estado;
        this.cocinero = cocinero;
        this.bebida = bebida;
        this.plato = plato;
        this.reclamos = reclamos;
        this.anulaciones = anulaciones;
    }


    public Long getId_pedido() {
        return id_pedido;
    }


    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }


    public Date getFecha_pedido() {
        return fecha_pedido;
    }


    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }


    public Time getHora_pedido() {
        return hora_pedido;
    }


    public void setHora_pedido(Time hora_pedido) {
        this.hora_pedido = hora_pedido;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public Cocinero getCocinero() {
        return cocinero;
    }


    public void setCocinero(Cocinero cocinero) {
        this.cocinero = cocinero;
    }


    public Bebida getBebida() {
        return bebida;
    }


    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }


    public Plato getPlato() {
        return plato;
    }


    public void setPlato(Plato plato) {
        this.plato = plato;
    }


    public List<Reclamo> getReclamos() {
        return reclamos;
    }


    public void setReclamos(List<Reclamo> reclamos) {
        this.reclamos = reclamos;
    }


    public List<AnulacionPedido> getAnulaciones() {
        return anulaciones;
    }


    public void setAnulaciones(List<AnulacionPedido> anulaciones) {
        this.anulaciones = anulaciones;
    }

    

    

}
