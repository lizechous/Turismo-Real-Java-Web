package com.duoc.turismo.repository.model;

import com.duoc.turismo.controller.model.AccionEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CONDICIONES_DE_USO")
public class CondicionesDeUso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_condiciones", nullable = false)
    private Integer idCondicion;

    @Column(name = "tipo_condicion_de_uso")
    private String tipoCondicionDeUso;

    @Transient
    private AccionEnum accion;

    //con la anotación JsonIgnore, este atributo no se retornará en la salida del servicio REST
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "DETALLE_CONDICIONES_DE_USO",
            joinColumns = @JoinColumn(name = "id_condiciones_FK"),
            inverseJoinColumns = @JoinColumn(name = "id_departamento_FK"))
    private List<Departamento> departamentoList;

    public Integer getIdCondicion() {
        return idCondicion;
    }

    public void setIdCondicion(Integer idCondicion) {
        this.idCondicion = idCondicion;
    }

    public String getTipoCondicionDeUso() {
        return tipoCondicionDeUso;
    }

    public void setTipoCondicionDeUso(String tipoCondicionDeUso) {
        this.tipoCondicionDeUso = tipoCondicionDeUso;
    }

    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    public AccionEnum getAccion() {
        return accion;
    }

    public void setAccion(AccionEnum accion) {
        this.accion = accion;
    }
}
