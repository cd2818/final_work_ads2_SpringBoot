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
@Table(name = "comprobante")
public class Comprobante implements Serializable {

    private static final long serialVersionUID =1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comprobante")
    private Long id_comprobante;

    @Column(name = "cod_comprobante")
    private String cod_comprobante;

    @Column(name = "descripcion")
    private String descripcion;
    
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pago")
    private PagoPedido pagoPedido;

    public Comprobante(String cod_comprobante, String descripcion, PagoPedido pagoPedido) {
        this.cod_comprobante = cod_comprobante;
        this.descripcion = descripcion;
        this.pagoPedido = pagoPedido;
    }

    public Comprobante() {
    }

    public Long getId_comprobante() {
        return id_comprobante;
    }

    public void setId_comprobante(Long id_comprobante) {
        this.id_comprobante = id_comprobante;
    }

    public String getCod_comprobante() {
        return cod_comprobante;
    }

    public void setCod_comprobante(String cod_comprobante) {
        this.cod_comprobante = cod_comprobante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public PagoPedido getPagoPedido() {
        return pagoPedido;
    }

    public void setPagoPedido(PagoPedido pagoPedido) {
        this.pagoPedido = pagoPedido;
    } 

    
}
