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
@Table(name = "atencion_al_cliente")
public class AtencionAlCliente implements Serializable {

    private static final long serialVersionUID =1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atencion")
    private Long id_atencion;

    @Column(name = "fecha_atencion")
    private Date fecha_atencion;

    @Column(name = "hora_inicio")
    private Time hora_inicio;
    
    @Column(name = "hora_fin")
    private Time hora_fin;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_recepcionista")
    private Recepcionista recepcionista;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mesero")
    private Mesero mesero;

    @OneToMany(mappedBy = "atencion_al_cliente")
    private List<ReservaMesa> reservas_mesas;
    
    @OneToMany(mappedBy = "atencion_al_cliente")
    private List<PagoPedido> pagos_pedidos;
    
    
    public AtencionAlCliente() {
    }


    public AtencionAlCliente(Date fecha_atencion, Time hora_inicio, Time hora_fin, String estado, Cliente cliente,
            Recepcionista recepcionista, Mesero mesero, List<ReservaMesa> reservas_mesas,
            List<PagoPedido> pagos_pedidos) {
        this.fecha_atencion = fecha_atencion;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.estado = estado;
        this.cliente = cliente;
        this.recepcionista = recepcionista;
        this.mesero = mesero;
        this.reservas_mesas = reservas_mesas;
        this.pagos_pedidos = pagos_pedidos;
    }


    public Long getId_atencion() {
        return id_atencion;
    }


    public void setId_atencion(Long id_atencion) {
        this.id_atencion = id_atencion;
    }


    public Date getFecha_atencion() {
        return fecha_atencion;
    }


    public void setFecha_atencion(Date fecha_atencion) {
        this.fecha_atencion = fecha_atencion;
    }


    public Time getHora_inicio() {
        return hora_inicio;
    }


    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }


    public Time getHora_fin() {
        return hora_fin;
    }


    public void setHora_fin(Time hora_fin) {
        this.hora_fin = hora_fin;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public Recepcionista getRecepcionista() {
        return recepcionista;
    }


    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }


    public Mesero getMesero() {
        return mesero;
    }


    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }


    public List<ReservaMesa> getReservas_mesas() {
        return reservas_mesas;
    }


    public void setReservas_mesas(List<ReservaMesa> reservas_mesas) {
        this.reservas_mesas = reservas_mesas;
    }


    public List<PagoPedido> getPagos_pedidos() {
        return pagos_pedidos;
    }


    public void setPagos_pedidos(List<PagoPedido> pagos_pedidos) {
        this.pagos_pedidos = pagos_pedidos;
    }

    

    

}
