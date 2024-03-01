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
@Table(name = "administrador")
@PrimaryKeyJoinColumn(name = "id_empleado")
public class Administrador extends Empleado {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_administrador")
    private Long id_administrador;

    @OneToMany(mappedBy = "administrador")
    private List<Reclamo> reclamos;


    public Administrador(String nombre, String ap_paterno, String ap_materno, String nro_telefono, String direccion,
            String nro_dni, String email, String estado, Time hora_entrada, Time hora_salida, Float sueldo,
            Turno turno) {
        super(nombre, ap_paterno, ap_materno, nro_telefono, direccion, nro_dni, email, estado, hora_entrada,
                hora_salida, sueldo, turno);
    }

    public Administrador() {
    }

    public Long getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(Long id_administrador) {
        this.id_administrador = id_administrador;
    }

    public List<Reclamo> getReclamos() {
        return reclamos;
    }

    public void setReclamos(List<Reclamo> reclamos) {
        this.reclamos = reclamos;
    }

    
    
}
