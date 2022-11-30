package com.duoc.turismo.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "BOLETA_SERVICIO_EXTRA")
public class BoletaServicioExtra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_boleta_servicio", nullable = false)
    private Integer numeroBoletaServicio;

    @Column(name = "costo_servicio_extra", nullable = false)
    private Integer costoServicioExtra;

    @JsonIgnore
    @OneToOne(mappedBy = "boletaServicioExtra", cascade = CascadeType.ALL)
    private SolicitudServicioExtra solicitudServicioExtra;

    public SolicitudServicioExtra getSolicitudServicioExtra() {
        return solicitudServicioExtra;
    }

    public void setSolicitudServicioExtra(SolicitudServicioExtra solicitudServicioExtra) {
        this.solicitudServicioExtra = solicitudServicioExtra;
    }

    public Integer getNumeroBoletaServicio() {
        return numeroBoletaServicio;
    }

    public Integer getCostoServicioExtra() {
        return costoServicioExtra;
    }

    public void setCostoServicioExtra(Integer costoServicioExtra) {
        this.costoServicioExtra = costoServicioExtra;
    }

}
