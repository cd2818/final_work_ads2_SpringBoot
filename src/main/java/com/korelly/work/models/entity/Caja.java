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
@Table(name = "caja")
public class Caja implements Serializable {

    private static final long serialVersionUID =1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_caja")    
    private Long id_caja;

    @Column(name = "nro_caja")
    private String nro_caja;

    @Column(name = "monto_inicial")
    private Float monto_inicial;

    @Column(name="monto_final")
    private Float monto_final;
    
    @OneToMany(mappedBy = "caja")
    private List<Cajero> cajeros;

    
    public Caja() {
    }


    public Caja(String nro_caja, Float monto_inicial, Float monto_final) {
        this.nro_caja = nro_caja;
        this.monto_inicial = monto_inicial;
        this.monto_final = monto_final;
    }


    public Long getId_caja() {
        return id_caja;
    }


    public void setId_caja(Long id_caja) {
        this.id_caja = id_caja;
    }


    public String getNro_caja() {
        return nro_caja;
    }


    public void setNro_caja(String nro_caja) {
        this.nro_caja = nro_caja;
    }


    public Float getMonto_inicial() {
        return monto_inicial;
    }


    public void setMonto_inicial(Float monto_inicial) {
        this.monto_inicial = monto_inicial;
    }


    public Float getMonto_final() {
        return monto_final;
    }


    public void setMonto_final(Float monto_final) {
        this.monto_final = monto_final;
    }


    
}
