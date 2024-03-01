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
@Table(name="tarjeta")
public class Tarjeta implements Serializable {

    private static final long serialVersionUID =1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarjeta")
    private Long id_tarjeta;

    @Column(name = "nro_tarjeta")
    private String nro_tarjeta;

    @Column(name = "cvv")
    private String cvv;

    @Column(name = "nombre_titular")
    private String nombre_titular;
    
    @Column(name = "saldo")
    private Float saldo;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_tarjeta")
    private TipoTarjeta tipo_tarjeta;

    @OneToMany(mappedBy = "tarjeta")
    private List<PagoTarjeta> pago_tarjeta;

    public Tarjeta(String nro_tarjeta, String cvv, String nombre_titular, Float saldo, String estado,
            TipoTarjeta tipo_tarjeta) {
        this.nro_tarjeta = nro_tarjeta;
        this.cvv = cvv;
        this.nombre_titular = nombre_titular;
        this.saldo = saldo;
        this.estado = estado;
        this.tipo_tarjeta = tipo_tarjeta;
    }

    public Tarjeta() {
    }

    public Long getId_tarjeta() {
        return id_tarjeta;
    }

    public void setId_tarjeta(Long id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }

    public String getNro_tarjeta() {
        return nro_tarjeta;
    }

    public void setNro_tarjeta(String nro_tarjeta) {
        this.nro_tarjeta = nro_tarjeta;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getNombre_titular() {
        return nombre_titular;
    }

    public void setNombre_titular(String nombre_titular) {
        this.nombre_titular = nombre_titular;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TipoTarjeta getTipo_tarjeta() {
        return tipo_tarjeta;
    }

    public void setTipo_tarjeta(TipoTarjeta tipo_tarjeta) {
        this.tipo_tarjeta = tipo_tarjeta;
    }

    public List<PagoTarjeta> getPago_tarjeta() {
        return pago_tarjeta;
    }

    public void setPago_tarjeta(List<PagoTarjeta> pago_tarjeta) {
        this.pago_tarjeta = pago_tarjeta;
    }


    

}
