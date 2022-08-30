package com.duoc.turismo.repository.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "BOLETA_RESERVA")
public class BoletaReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_boleta", nullable = false)
    private Integer numeroBoleta;

    @Column(name = "fecha_emision", nullable = false)
    private Date fechaEmision;

    @Column(name = "monto_boleta", nullable = false)
    private Integer montoBoleta;

    @ManyToOne
    @JoinColumn(name = "id_reserva_FK")
    private Reserva reserva;

    public Integer getNumeroBoleta() {
        return numeroBoleta;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Integer getMontoBoleta() {
        return montoBoleta;
    }

    public void setMontoBoleta(Integer montoBoleta) {
        this.montoBoleta = montoBoleta;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
