package com.duoc.turismo.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "BOLETA_SERVICIO_EXTRA")
public class BoletaServicioExtra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_boleta_servicio", nullable = false)
    private Integer numeroBoletaServicio;

    @Column(name = "costo_servicio_extra", nullable = false)
    private Integer costoServicioExtra;

    @Column(name = "cantidad_personas", nullable = false)
    private Integer cantidadPersonas;

    @Column(name = "fecha_hora_inicio", nullable = true)
    private Date fechaHoraInicio;

    @Column(name = "fecha_hora_termino", nullable = true)
    private Date fechaHoraTermino;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_reserva_FK")
    private Reserva reserva;

    private Integer idReserva;

    @ManyToOne
    @JoinColumn(name = "id_servicio_extra_FK")
    private ServicioExtra servicioExtra;

    public Integer getNumeroBoletaServicio() {
        return numeroBoletaServicio;
    }

    public Integer getCostoServicioExtra() {
        return costoServicioExtra;
    }

    public void setCostoServicioExtra(Integer costoServicioExtra) {
        this.costoServicioExtra = costoServicioExtra;
    }

    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public Date getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Date fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Date getFechaHoraTermino() {
        return fechaHoraTermino;
    }

    public void setFechaHoraTermino(Date fechaHoraTermino) {
        this.fechaHoraTermino = fechaHoraTermino;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public ServicioExtra getServicioExtra() {
        return servicioExtra;
    }

    public void setServicioExtra(ServicioExtra servicioExtra) {
        this.servicioExtra = servicioExtra;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }
}
