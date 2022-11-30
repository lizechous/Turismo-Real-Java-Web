package com.duoc.turismo.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CHECKLIST")
public class Checklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_checklist", nullable = false)
    private Integer idChecklist;

    @Column(name = "tipo_checklist", nullable = false, length = 10)
    private String tipoChecklist;

    @Column(name = "inspeccion_cocina", nullable = false, length = 30)
    private String inspeccionCocina;

    @Column(name = "inspeccion_habitaciones", nullable = false, length = 30)
    private String inspeccionHabitaciones;

    @Column(name = "inspeccion_banio", nullable = false, length = 30)
    private String inspeccionBanio;

    @Column(name = "inspeccion_living", nullable = false, length = 30)
    private String inspeccionLiving;

    @Column(name = "inspeccion_terraza", nullable = false, length = 30)
    private String inspeccionTerraza;

    @Column(name = "agua_caliente", nullable = false, length = 30)
    private String aguaCaliente;

    @Column(name = "luz", nullable = false, length = 30)
    private String luz;

    @Column(name = "refrigerador", nullable = false, length = 30)
    private String refrigerador;

    @Column(name = "observaciones", nullable = false, length = 300)
    private String observaciones;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_reserva_FK")
    private Reserva reserva;

    private Integer idReserva;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_estado_checklist_FK")
    private EstadoChecklist estadoChecklist;

    public Integer getIdChecklist() {
        return idChecklist;
    }

    public String getTipoChecklist() {
        return tipoChecklist;
    }

    public void setTipoChecklist(String tipoChecklist) {
        this.tipoChecklist = tipoChecklist;
    }

    public String getInspeccionCocina() {
        return inspeccionCocina;
    }

    public void setInspeccionCocina(String inspeccionCocina) {
        this.inspeccionCocina = inspeccionCocina;
    }

    public String getInspeccionHabitaciones() {
        return inspeccionHabitaciones;
    }

    public void setInspeccionHabitaciones(String inspeccionHabitaciones) {
        this.inspeccionHabitaciones = inspeccionHabitaciones;
    }

    public String getInspeccionBanio() {
        return inspeccionBanio;
    }

    public void setInspeccionBanio(String inspeccionBanio) {
        this.inspeccionBanio = inspeccionBanio;
    }

    public String getInspeccionLiving() {
        return inspeccionLiving;
    }

    public void setInspeccionLiving(String inspeccionLiving) {
        this.inspeccionLiving = inspeccionLiving;
    }

    public String getInspeccionTerraza() {
        return inspeccionTerraza;
    }

    public void setInspeccionTerraza(String inspeccionTerraza) {
        this.inspeccionTerraza = inspeccionTerraza;
    }

    public String getAguaCaliente() {
        return aguaCaliente;
    }

    public void setAguaCaliente(String aguaCaliente) {
        this.aguaCaliente = aguaCaliente;
    }

    public String getLuz() {
        return luz;
    }

    public void setLuz(String luz) {
        this.luz = luz;
    }

    public String getRefrigerador() {
        return refrigerador;
    }

    public void setRefrigerador(String refrigerador) {
        this.refrigerador = refrigerador;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public EstadoChecklist getEstadoChecklist() {
        return estadoChecklist;
    }

    public void setEstadoChecklist(EstadoChecklist estadoChecklist) {
        this.estadoChecklist = estadoChecklist;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
