package com.korelly.work.models.entity;

import java.sql.Time;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "mesero")
@PrimaryKeyJoinColumn(name = "id_empleado")
public class Mesero extends Empleado {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mesero")
    private Long id_mesero;

    @OneToMany(mappedBy = "mesero" )
    private List<AtencionAlCliente> atenciones_al_cliente;

    public Mesero(String nombre, String ap_paterno, String ap_materno, String nro_telefono, String direccion,
            String nro_dni, String email, String estado, Time hora_entrada, Time hora_salida, Float sueldo,
            Turno turno) {
        super(nombre, ap_paterno, ap_materno, nro_telefono, direccion, nro_dni, email, estado, hora_entrada,
                hora_salida, sueldo, turno);
    }

    public Mesero() {
    }

    public Long getId_mesero() {
        return id_mesero;
    }

    public void setId_mesero(Long id_mesero) {
        this.id_mesero = id_mesero;
    }

    public List<AtencionAlCliente> getAtenciones_al_cliente() {
        return atenciones_al_cliente;
    }

    public void setAtenciones_al_cliente(List<AtencionAlCliente> atenciones_al_cliente) {
        this.atenciones_al_cliente = atenciones_al_cliente;
    }

    


}
