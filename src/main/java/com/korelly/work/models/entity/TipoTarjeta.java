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
@Table(name="tipo_tarjeta")
public class TipoTarjeta implements Serializable {

    private static final long serialVersionUID =1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_tarjeta")
    private Long id_tipo_tarjeta;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_banco")
    private Banco banco;

    @OneToMany(mappedBy = "tipo_tarjeta")
    private List<Tarjeta> tarjetas;

    public TipoTarjeta(String descripcion, Banco banco) {
        this.descripcion = descripcion;
        this.banco = banco;
    }

    public TipoTarjeta() {
    }

    public Long getId_tipo_tarjeta() {
        return id_tipo_tarjeta;
    }

    public void setId_tipo_tarjeta(Long id_tipo_tarjeta) {
        this.id_tipo_tarjeta = id_tipo_tarjeta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }

    
}
