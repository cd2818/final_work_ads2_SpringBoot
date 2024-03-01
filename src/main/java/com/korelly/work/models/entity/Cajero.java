package com.korelly.work.models.entity;


import java.sql.Time;
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
@Table(name = "cajero")
@PrimaryKeyJoinColumn(name = "id_empleado")
public class Cajero extends Empleado {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cajero")
    private Long id_cajero;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_caja")
    private Caja caja;

    @OneToMany(mappedBy = "cajero")
    private List<PagoPedido> pagos_pedidos;

    public Cajero(String nombre, String ap_paterno, String ap_materno, String nro_telefono, String direccion,
            String nro_dni, String email, String estado, Time hora_entrada, Time hora_salida, Float sueldo, Turno turno,
            Caja caja) {
        super(nombre, ap_paterno, ap_materno, nro_telefono, direccion, nro_dni, email, estado, hora_entrada,
                hora_salida, sueldo, turno);
        this.caja = caja;
    }

    public Cajero() {}

    public Long getId_cajero() {
        return id_cajero;
    }

    public void setId_cajero(Long id_cajero) {
        this.id_cajero = id_cajero;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public List<PagoPedido> getPagos_pedidos() {
        return pagos_pedidos;
    }

    public void setPagos_pedidos(List<PagoPedido> pagos_pedidos) {
        this.pagos_pedidos = pagos_pedidos;
    }

    

    

}
