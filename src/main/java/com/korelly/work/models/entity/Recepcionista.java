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
@Table(name = "recepcionista")
@PrimaryKeyJoinColumn(name = "id_empleado")
public class Recepcionista extends Empleado {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recepcionista")    
    private Long id_recepcionista;

    @OneToMany(mappedBy = "recepcionista")
    private List<AtencionAlCliente> atenciones_al_cliente;

    public Recepcionista(String nombre, String ap_paterno, String ap_materno, String nro_telefono, String direccion,
            String nro_dni, String email, String estado, Time hora_entrada, Time hora_salida, Float sueldo,
            Turno turno) {
        super(nombre, ap_paterno, ap_materno, nro_telefono, direccion, nro_dni, email, estado, hora_entrada,
                hora_salida, sueldo, turno);
    }

    public Recepcionista() {

    }

    public Long getId_recepcionista() {
        return id_recepcionista;
    }

    public void setId_recepcionista(Long id_recepcionista) {
        this.id_recepcionista = id_recepcionista;
    }

    public List<AtencionAlCliente> getAtenciones_al_cliente() {
        return atenciones_al_cliente;
    }

    public void setAtenciones_al_cliente(List<AtencionAlCliente> atenciones_al_cliente) {
        this.atenciones_al_cliente = atenciones_al_cliente;
    }

    

    


}
