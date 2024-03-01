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
@Table(name = "reclamo")
public class Reclamo implements Serializable {

    private static final long serialVersionUID =1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reclamo") 
    private Long id_reclamo;

    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "estado")
    private String estado;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_administrador")
    private Administrador administrador;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_motivo_reclamo")
    private MotivoReclamo motivo_reclamo;

    @OneToMany(mappedBy = "reclamo")
    private List<AnulacionPedido> anulaciones_pedidos;

    public Reclamo(String descripcion, String estado, Pedido pedido, Administrador administrador,
            MotivoReclamo motivo_reclamo) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.pedido = pedido;
        this.administrador = administrador;
        this.motivo_reclamo = motivo_reclamo;
    }

    public Reclamo() {
    }

    public Long getId_reclamo() {
        return id_reclamo;
    }

    public void setId_reclamo(Long id_reclamo) {
        this.id_reclamo = id_reclamo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public MotivoReclamo getMotivo_reclamo() {
        return motivo_reclamo;
    }

    public void setMotivo_reclamo(MotivoReclamo motivo_reclamo) {
        this.motivo_reclamo = motivo_reclamo;
    }

    public List<AnulacionPedido> getAnulaciones_pedidos() {
        return anulaciones_pedidos;
    }

    public void setAnulaciones_pedidos(List<AnulacionPedido> anulaciones_pedidos) {
        this.anulaciones_pedidos = anulaciones_pedidos;
    }

    
}
