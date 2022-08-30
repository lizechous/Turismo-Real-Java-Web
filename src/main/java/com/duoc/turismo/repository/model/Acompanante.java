package com.duoc.turismo.repository.model;

import javax.persistence.*;

@Entity
@Table(name="ACOMPANANTE")
public class Acompanante {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_acompanante",nullable = false)
    private Integer idAcompanante;

    @Column(name = "nombre_acompanante", nullable = false, length = 45)
    private String nombreAcompanante;

    @Column(name = "rut_acompanante", nullable = false, length = 12)
    private String rutAcompanante;

    @ManyToOne
    @JoinColumn(name = "id_reserva_FK")
    private Reserva reserva;

    public Integer getIdAcompanante() {
        return idAcompanante;
    }

    public String getNombreAcompanante() {
        return nombreAcompanante;
    }

    public void setNombreAcompanante(String nombreAcompanante) {
        this.nombreAcompanante = nombreAcompanante;
    }

    public String getRutAcompanante() {
        return rutAcompanante;
    }

    public void setRutAcompanante(String rutAcompanante) {
        this.rutAcompanante = rutAcompanante;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
