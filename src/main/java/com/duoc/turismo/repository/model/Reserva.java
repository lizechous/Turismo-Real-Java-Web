package com.duoc.turismo.repository.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="RESERVA")
public class Reserva {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_reserva",nullable = false)
    private Integer idReserva;

    @Column(name = "fecha_llegada", nullable = false)
    private Date fechaLlegada;

    @Column(name = "fecha_salida", nullable = false)
    private Date fechaSalida;

    @Column(name = "fecha_reserva", nullable = false)
    private Date fechaReserva;

    @Column(name = "monto_prepago", nullable = false)
    private Date montoPrepago;

    //Aqui si se aplica el OneToMany porque trae pocos registros
    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<Acompanante> acompananteList;

    @OneToMany(mappedBy = "reserva")
    private List<BoletaMulta> boletaMultaList;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<BoletaReserva> boletaReservaList;

    @OneToMany(mappedBy = "reserva")
    private List<BoletaServicioExtra> boletaServicioExtraList;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<Checklist> checklistList;

    @OneToMany(mappedBy = "reserva")
    private List<CostoReparacion> costoReparacionList;

    @ManyToOne
    @JoinColumn(name = "id_cliente_FK")
    private ClienteUsuario clienteUsuario;

    @ManyToOne
    @JoinColumn(name = "id_departamento_FK")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "id_estado_reserva_FK")
    private EstadoReserva estadoReserva;

    public Integer getIdReserva() {
        return idReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getMontoPrepago() {
        return montoPrepago;
    }

    public void setMontoPrepago(Date montoPrepago) {
        this.montoPrepago = montoPrepago;
    }

    public List<Acompanante> getAcompananteList() {
        return acompananteList;
    }

    public void setAcompananteList(List<Acompanante> acompananteList) {
        this.acompananteList = acompananteList;
    }

    public List<BoletaMulta> getBoletaMultaList() {
        return boletaMultaList;
    }

    public void setBoletaMultaList(List<BoletaMulta> boletaMultaList) {
        this.boletaMultaList = boletaMultaList;
    }

    public List<BoletaReserva> getBoletaReservaList() {
        return boletaReservaList;
    }

    public void setBoletaReservaList(List<BoletaReserva> boletaReservaList) {
        this.boletaReservaList = boletaReservaList;
    }

    public List<BoletaServicioExtra> getBoletaServicioExtraList() {
        return boletaServicioExtraList;
    }

    public void setBoletaServicioExtraList(List<BoletaServicioExtra> boletaServicioExtraList) {
        this.boletaServicioExtraList = boletaServicioExtraList;
    }

    public List<Checklist> getChecklistList() {
        return checklistList;
    }

    public void setChecklistList(List<Checklist> checklistList) {
        this.checklistList = checklistList;
    }

    public List<CostoReparacion> getCostoReparacionList() {
        return costoReparacionList;
    }

    public void setCostoReparacionList(List<CostoReparacion> costoReparacionList) {
        this.costoReparacionList = costoReparacionList;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public ClienteUsuario getClienteUsuario() {
        return clienteUsuario;
    }

    public void setClienteUsuario(ClienteUsuario clienteUsuario) {
        this.clienteUsuario = clienteUsuario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
