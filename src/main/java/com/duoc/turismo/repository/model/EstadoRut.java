package com.duoc.turismo.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "ESTADO_RUT")
public class EstadoRut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_rut", nullable = false)
    private Integer idEstadoRut;

    @Column(name = "glosa", nullable = false, length = 45)
    private String glosa;

    public Integer getIdEstadoRut() {
        return idEstadoRut;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }
}
