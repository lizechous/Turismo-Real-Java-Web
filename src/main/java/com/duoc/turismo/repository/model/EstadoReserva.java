package com.duoc.turismo.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ESTADO_RESERVA")
public class EstadoReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_reserva", nullable = false)
    private Integer idEstadoReserva;

    @Column(name = "glosa", nullable = false, length = 20)
    private String glosa;

    @JsonIgnore
    @OneToMany(mappedBy = "estadoReserva")
    private List<Reserva> reservaList;

    public Integer getIdEstadoReserva() {
        return idEstadoReserva;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setIdEstadoReserva(Integer idEstadoReserva) {
        this.idEstadoReserva = idEstadoReserva;
    }
}
