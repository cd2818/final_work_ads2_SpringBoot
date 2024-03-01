package com.korelly.work.models.entity;

import java.io.Serializable;
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
@Table(name = "pago_pedido")
public class PagoPedido implements Serializable {

    private static final long serialVersionUID =1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Long id_pago;

    @Column(name = "cod_pago")
    private String cod_pago;

    @Column(name = "importe_total")
    private Float importe_total;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_atencion")
    private AtencionAlCliente atencion_al_cliente;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cajero")
    private Cajero cajero;

    @OneToMany(mappedBy = "pago_pedido")
    private List<PagoTarjeta> pago_tarjeta;

    @OneToMany(mappedBy = "pago_pedido")
    private List<Comprobante> comprobante;


    

    public PagoPedido() {
    }

    public PagoPedido(String cod_pago, Float importe_total, AtencionAlCliente atencion_al_cliente, Cajero cajero,
            List<PagoTarjeta> pago_tarjeta, List<Comprobante> comprobante) {
        this.cod_pago = cod_pago;
        this.importe_total = importe_total;
        this.atencion_al_cliente = atencion_al_cliente;
        this.cajero = cajero;
        this.pago_tarjeta = pago_tarjeta;
        this.comprobante = comprobante;
    }

    public Long getId_pago() {
        return id_pago;
    }

    public void setId_pago(Long id_pago) {
        this.id_pago = id_pago;
    }

    public String getCod_pago() {
        return cod_pago;
    }

    public void setCod_pago(String cod_pago) {
        this.cod_pago = cod_pago;
    }

    public Float getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(Float importe_total) {
        this.importe_total = importe_total;
    }

    public AtencionAlCliente getAtencion_al_cliente() {
        return atencion_al_cliente;
    }

    public void setAtencion_al_cliente(AtencionAlCliente atencion_al_cliente) {
        this.atencion_al_cliente = atencion_al_cliente;
    }

    public Cajero getCajero() {
        return cajero;
    }

    public void setCajero(Cajero cajero) {
        this.cajero = cajero;
    }

    public List<PagoTarjeta> getPago_tarjeta() {
        return pago_tarjeta;
    }

    public void setPago_tarjeta(List<PagoTarjeta> pago_tarjeta) {
        this.pago_tarjeta = pago_tarjeta;
    }

    public List<Comprobante> getComprobante() {
        return comprobante;
    }

    public void setComprobante(List<Comprobante> comprobante) {
        this.comprobante = comprobante;
    }

    

    

}
