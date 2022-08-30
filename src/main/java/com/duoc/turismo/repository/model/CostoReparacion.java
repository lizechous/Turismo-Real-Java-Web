package com.duoc.turismo.repository.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "COSTOS_REPARACION")
public class CostoReparacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_costos", nullable = false)
    private Integer idCostos;

    @Column(name = "titulo_reparacion", nullable = false, length = 45)
    private String tituloReparacion;

    @Column(name = "costo_reparacion", nullable = false)
    private Integer costoReparacion;

    @Column(name = "descripcion", nullable = false, length = 300)
    private String descripcion;

    @Column(name = "fecha_emision", nullable = false)
    private Date  fechaEmision;

    @ManyToOne
    @JoinColumn(name = "id_reserva_FK")
    private Reserva reserva;

    public Integer getIdCostos() {
        return idCostos;
    }

    public String getTituloReparacion() {
        return tituloReparacion;
    }

    public void setTituloReparacion(String tituloReparacion) {
        this.tituloReparacion = tituloReparacion;
    }

    public Integer getCostoReparacion() {
        return costoReparacion;
    }

    public void setCostoReparacion(Integer costoReparacion) {
        this.costoReparacion = costoReparacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Reserva getReserva() {
        return reserva;
    }

}
