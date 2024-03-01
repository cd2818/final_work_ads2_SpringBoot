package com.korelly.work.models.entity;

import java.io.Serializable;

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
@Table(name = "pago_tarjeta")
public class PagoTarjeta implements Serializable {

    private static final long serialVersionUID =1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago_tarjeta")
    private Long id_pago_tarjeta;

    @Column(name = "nro_transaccion")
    private Integer nro_transaccion;
    
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tarjeta")
    private Tarjeta tarjeta;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pago")
    private PagoPedido pago_pedido;


    public PagoTarjeta() {
    }


    public PagoTarjeta(Integer nro_transaccion, Tarjeta tarjeta, PagoPedido pago_pedido) {
        this.nro_transaccion = nro_transaccion;
        this.tarjeta = tarjeta;
        this.pago_pedido = pago_pedido;
    }


    public Long getId_pago_tarjeta() {
        return id_pago_tarjeta;
    }


    public void setId_pago_tarjeta(Long id_pago_tarjeta) {
        this.id_pago_tarjeta = id_pago_tarjeta;
    }


    public Integer getNro_transaccion() {
        return nro_transaccion;
    }


    public void setNro_transaccion(Integer nro_transaccion) {
        this.nro_transaccion = nro_transaccion;
    }


    public Tarjeta getTarjeta() {
        return tarjeta;
    }


    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }


    public PagoPedido getPago_pedido() {
        return pago_pedido;
    }


    public void setPago_pedido(PagoPedido pago_pedido) {
        this.pago_pedido = pago_pedido;
    }

    
    

}
