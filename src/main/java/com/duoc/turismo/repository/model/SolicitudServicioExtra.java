package com.duoc.turismo.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SOLICITUD_SERVICIO_EXTRA")
public class SolicitudServicioExtra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud", nullable = false)
    private Integer idSolicitud;

    @Column(name = "fecha_solicitud", nullable = false)
    private Date fechaSolicitud;

    @Column(name = "fecha_planificacion", nullable = true)
    private Date fechaPlanificacion;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_reserva_FK")
    private Reserva reserva;

    @Transient
    private Integer idReserva;

    @ManyToOne
    @JoinColumn(name = "id_servicio_extra_FK")
    private ServicioExtra servicioExtra;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_boleta_FK")
    private BoletaServicioExtra boletaServicioExtra;

    @Column(name = "origen", nullable = true)
    private String origen;

    @Column(name = "destino", nullable = true)
    private String destino;

    @Transient
    private String tipoServicio;

    @Column(name = "personas")
    private Integer personas;

    public Integer getPersonas() {
        return personas;
    }

    public void setPersonas(Integer personas) {
        this.personas = personas;
    }

    public String getTipoServicio() {
        return servicioExtra == null ? "n/a" : servicioExtra instanceof Transporte ? "transporte" : "tour";
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaPlanificacion() {
        return fechaPlanificacion;
    }

    public void setFechaPlanificacion(Date fechaPlanificacion) {
        this.fechaPlanificacion = fechaPlanificacion;
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
        return idReserva == null ? reserva.getIdReserva() : idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public BoletaServicioExtra getBoletaServicioExtra() {
        return boletaServicioExtra;
    }

    public void setBoletaServicioExtra(BoletaServicioExtra boletaServicioExtra) {
        this.boletaServicioExtra = boletaServicioExtra;
    }
}
