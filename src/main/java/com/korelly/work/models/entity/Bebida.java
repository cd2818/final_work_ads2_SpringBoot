package com.korelly.work.models.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "bebida")
public class Bebida implements Serializable {

    private static final long serialVersionUID =1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bebida")
    private Long id_bebida;

    @Column(name = "cod_bebida")
    private String cod_bebida;

    @Column(name = "nombre_bebida")
    private String nombre_bebida;

    @Column(name = "precio_lista")
    private Float precio_lista;

    @Column(name = "estado")
    private String estado;

    @OneToMany(mappedBy = "bebida")
    private List<Pedido> pedidos;

    public Bebida() {
    }

    public Bebida(String cod_bebida, String nombre_bebida, Float precio_lista, String estado, List<Pedido> pedidos) {
        this.cod_bebida = cod_bebida;
        this.nombre_bebida = nombre_bebida;
        this.precio_lista = precio_lista;
        this.estado = estado;
        this.pedidos = pedidos;
    }

    public Long getId_bebida() {
        return id_bebida;
    }

    public void setId_bebida(Long id_bebida) {
        this.id_bebida = id_bebida;
    }

    public String getCod_bebida() {
        return cod_bebida;
    }

    public void setCod_bebida(String cod_bebida) {
        this.cod_bebida = cod_bebida;
    }

    public String getNombre_bebida() {
        return nombre_bebida;
    }

    public void setNombre_bebida(String nombre_bebida) {
        this.nombre_bebida = nombre_bebida;
    }

    public Float getPrecio_lista() {
        return precio_lista;
    }

    public void setPrecio_lista(Float precio_lista) {
        this.precio_lista = precio_lista;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    
}
