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
@Table(name = "banco")
public class Banco implements Serializable {

    private static final long serialVersionUID =1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_banco")
    private Long id_banco;

    @Column(name = "nombre_banco")
    private String nombre_banco;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "estado")
    private String estado;


    @OneToMany(mappedBy = "banco")
    private List<TipoTarjeta> tipos_tarjetas;


    public Banco() {
    }


    public Banco(String nombre_banco, String ubicacion, String estado, List<TipoTarjeta> tipos_tarjetas) {
        this.nombre_banco = nombre_banco;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.tipos_tarjetas = tipos_tarjetas;
    }


    public Long getId_banco() {
        return id_banco;
    }


    public void setId_banco(Long id_banco) {
        this.id_banco = id_banco;
    }


    public String getNombre_banco() {
        return nombre_banco;
    }


    public void setNombre_banco(String nombre_banco) {
        this.nombre_banco = nombre_banco;
    }


    public String getUbicacion() {
        return ubicacion;
    }


    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public List<TipoTarjeta> getTipos_tarjetas() {
        return tipos_tarjetas;
    }


    public void setTipos_tarjetas(List<TipoTarjeta> tipos_tarjetas) {
        this.tipos_tarjetas = tipos_tarjetas;
    }

    
}
