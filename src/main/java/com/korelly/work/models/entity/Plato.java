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
@Table(name = "plato")
public class Plato implements Serializable {

    private static final long serialVersionUID =1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plato")
    private Long id_plato;

    @Column(name = "cod_plato")
    private String cod_plato;

    @Column(name = "nombre_plato")
    private String nombre_plato;

    @Column(name="precio_lista")
    private Float precio_lista;
    
    @Column(name="estado")
    private String estado;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_plato")
    private TipoPlato tipo_plato;

    @OneToMany(mappedBy = "plato")
    private List<Pedido> pedidos;

    public Plato() {
    }

    public Plato(String cod_plato, String nombre_plato, Float precio_lista, String estado, TipoPlato tipo_plato,
            List<Pedido> pedidos) {
        this.cod_plato = cod_plato;
        this.nombre_plato = nombre_plato;
        this.precio_lista = precio_lista;
        this.estado = estado;
        this.tipo_plato = tipo_plato;
        this.pedidos = pedidos;
    }

    public Long getId_plato() {
        return id_plato;
    }

    public void setId_plato(Long id_plato) {
        this.id_plato = id_plato;
    }

    public String getCod_plato() {
        return cod_plato;
    }

    public void setCod_plato(String cod_plato) {
        this.cod_plato = cod_plato;
    }

    public String getNombre_plato() {
        return nombre_plato;
    }

    public void setNombre_plato(String nombre_plato) {
        this.nombre_plato = nombre_plato;
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

    public TipoPlato getTipo_plato() {
        return tipo_plato;
    }

    public void setTipo_plato(TipoPlato tipo_plato) {
        this.tipo_plato = tipo_plato;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }


    
}
