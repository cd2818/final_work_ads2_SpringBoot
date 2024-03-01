package com.korelly.work.models.entity;

import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")
@PrimaryKeyJoinColumn(name = "id_persona")
public class Empleado extends Persona {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Long id_empleado;

    @Column(name = "hora_entrada")
    private Time hora_entrada;

    @Column(name = "hora_salida")
    private Time hora_salida;

    @Column(name = "sueldo")
    private Float sueldo;

    @ManyToOne
    @JoinColumn(name = "id_turno")
    private Turno turno;

    public Empleado(){}

    public Empleado(String nombre, String ap_paterno, String ap_materno, String nro_telefono, String direccion,
            String nro_dni, String email, String estado, Time hora_entrada, Time hora_salida, Float sueldo,
            Turno turno) {
        super(nombre, ap_paterno, ap_materno, nro_telefono, direccion, nro_dni, email, estado);
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.sueldo = sueldo;
        this.turno = turno;
    }

    public Long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Time getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(Time hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public Time getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Time hora_salida) {
        this.hora_salida = hora_salida;
    }

    public Float getSueldo() {
        return sueldo;
    }

    public void setSueldo(Float sueldo) {
        this.sueldo = sueldo;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    
    

}
