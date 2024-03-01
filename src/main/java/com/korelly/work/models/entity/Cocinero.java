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
@Table(name = "cocinero")
@PrimaryKeyJoinColumn(name = "id_empleado")
public class Cocinero extends Empleado {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cocinero")
    private Long id_cocinero;

    @OneToMany(mappedBy = "cocinero")
    private List<Pedido> pedidos;

    public Cocinero(String nombre, String ap_paterno, String ap_materno, String nro_telefono, String direccion,
            String nro_dni, String email, String estado, Time hora_entrada, Time hora_salida, Float sueldo,
            Turno turno) {
        super(nombre, ap_paterno, ap_materno, nro_telefono, direccion, nro_dni, email, estado, hora_entrada,
                hora_salida, sueldo, turno);
    }

    public Cocinero() {
    }

    public Long getId_cocinero() {
        return id_cocinero;
    }

    public void setId_cocinero(Long id_cocinero) {
        this.id_cocinero = id_cocinero;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    

}
