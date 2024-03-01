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
@Table(name="tipo_plato")
public class TipoPlato implements Serializable {

    private static final long serialVersionUID =1L;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_plato")
    private Long id_tipo_plato;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private String estado;

    @OneToMany(mappedBy = "tipo_plato")
    private List<Plato> plato;

    public TipoPlato(String descripcion, String estado) {
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Long getId_tipo_plato() {
        return id_tipo_plato;
    }

    public void setId_tipo_plato(Long id_tipo_plato) {
        this.id_tipo_plato = id_tipo_plato;
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

    public List<Plato> getPlato() {
        return plato;
    }

    public void setPlato(List<Plato> plato) {
        this.plato = plato;
    }

    
}
