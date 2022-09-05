package com.duoc.turismo.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SERVICIO_DEPTO")
public class ServicioDepto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio_depto", nullable = false)
    private Integer idServicioDepto;

    @Column(name = "tipo_servicio_depto", nullable = false, length = 45)
    private String tipoServicioDepto;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "DETALLE_SERVICIO_DEPTO",
            joinColumns = @JoinColumn(name = "id_servicio_depto_FK"),
            inverseJoinColumns = @JoinColumn(name = "id_departamento_FK"))
    private List<Departamento> departamentoList;

    public Integer getIdServicioDepto() {
        return idServicioDepto;
    }

    public String getTipoServicioDepto() {
        return tipoServicioDepto;
    }

    public void setTipoServicioDepto(String tipoServicioDepto) {
        this.tipoServicioDepto = tipoServicioDepto;
    }

    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }
}
