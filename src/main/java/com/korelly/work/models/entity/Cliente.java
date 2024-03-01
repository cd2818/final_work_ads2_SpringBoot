package com.korelly.work.models.entity;


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
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "id_persona")
public class Cliente extends Persona {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id_cliente;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo")
    private TipoCliente tipoCliente;

    @OneToMany(mappedBy = "cliente")
    private List<AtencionAlCliente> atenciones_al_cliente;

    public Long getId_cliente() {
        return id_cliente;
    }

    
    public Cliente() {
    }


    public Cliente(String nombre, String ap_paterno, String ap_materno, String nro_telefono, String direccion,
            String nro_dni, String email, String estado) {
        super(nombre, ap_paterno, ap_materno, nro_telefono, direccion, nro_dni, email, estado);
    }


    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }


    public List<AtencionAlCliente> getAtenciones_al_cliente() {
        return atenciones_al_cliente;
    }


    public void setAtenciones_al_cliente(List<AtencionAlCliente> atenciones_al_cliente) {
        this.atenciones_al_cliente = atenciones_al_cliente;
    }

    

}
