package com.duoc.turismo.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "BOLETA_MULTA")
public class BoletaMulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boleta_multa", nullable = false)
    private Integer idBoletaMulta;

    @Column(name = "titulo_multa", nullable = false, length = 45)
    private String titulomulta;

    @Column(name = "descripcion", nullable = false, length = 300)
    private String descripcion;

    @Column(name = "valor_multa", nullable = false)
    private Integer valorMulta;

    @Column(name = "fecha_multa", nullable = false)
    private Date fechaMulta;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_reserva_FK")
    private Reserva reserva;

    private Integer idReserva;

    public Integer getIdBoletaMulta() {
        return idBoletaMulta;
    }

    public String getTitulomulta() {
        return titulomulta;
    }

    public void setTitulomulta(String titulomulta) {
        this.titulomulta = titulomulta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(Integer valorMulta) {
        this.valorMulta = valorMulta;
    }

    public Date getFechaMulta() {
        return fechaMulta;
    }

    public void setFechaMulta(Date fechaMulta) {
        this.fechaMulta = fechaMulta;
    }

    public Reserva getReserva() {
        return reserva;
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
