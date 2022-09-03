package com.duoc.turismo.repository.model;

import javax.persistence.*;
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

    @ManyToMany
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
}
