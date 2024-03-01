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
@Table(name = "reserva_mesa")
public class ReservaMesa implements Serializable {

    private static final long serialVersionUID =1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long id_reserva;

    @Column(name = "cod_reserva")
    private String cod_reserva;

    @Column(name = "fecha_reserva")
    private Date fecha_reserva;

    @Column(name = "hora_reserva")
    private Time hora_reserva;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_atencion")
    private AtencionAlCliente atencion_al_cliente;

    @OneToMany(mappedBy = "reserva_mesa")
    private List<CancelacionReserva> cancelacion_reserva;

    public ReservaMesa() {
    }

    public ReservaMesa(String cod_reserva, Date fecha_reserva, Time hora_reserva, String estado, Mesa mesa,
            AtencionAlCliente atencion_al_cliente, List<CancelacionReserva> cancelacion_reserva) {
        this.cod_reserva = cod_reserva;
        this.fecha_reserva = fecha_reserva;
        this.hora_reserva = hora_reserva;
        this.estado = estado;
        this.mesa = mesa;
        this.atencion_al_cliente = atencion_al_cliente;
        this.cancelacion_reserva = cancelacion_reserva;
    }

    public Long getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(Long id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getCod_reserva() {
        return cod_reserva;
    }

    public void setCod_reserva(String cod_reserva) {
        this.cod_reserva = cod_reserva;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public Time getHora_reserva() {
        return hora_reserva;
    }

    public void setHora_reserva(Time hora_reserva) {
        this.hora_reserva = hora_reserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public AtencionAlCliente getAtencion_al_cliente() {
        return atencion_al_cliente;
    }

    public void setAtencion_al_cliente(AtencionAlCliente atencion_al_cliente) {
        this.atencion_al_cliente = atencion_al_cliente;
    }

    public List<CancelacionReserva> getCancelacion_reserva() {
        return cancelacion_reserva;
    }

    public void setCancelacion_reserva(List<CancelacionReserva> cancelacion_reserva) {
        this.cancelacion_reserva = cancelacion_reserva;
    }

    
}
