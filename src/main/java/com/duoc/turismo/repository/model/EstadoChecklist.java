package com.duoc.turismo.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "ESTADO_CHECKLIST")
public class EstadoChecklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_checklist", nullable = false)
    private Integer idEstadoChecklist;

    @Column(name = "glosa", nullable = false, length = 15)
    private String glosa;


    public Integer getIdEstadoChecklist() {
        return idEstadoChecklist;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }


}
