package com.duoc.turismo.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ESTADO_RUT")
public class EstadoRut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_rut", nullable = false)
    private Integer idEstadoRut;

    @Column(name = "glosa", nullable = false, length = 45)
    private String glosa;

    @JsonIgnore
    @OneToMany(mappedBy = "estadoRut", cascade = CascadeType.ALL)
    private List<ClienteUsuario> clienteUsuarioList;

    public Integer getIdEstadoRut() {
        return idEstadoRut;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public void setIdEstadoRut(Integer idEstadoRut) {
        this.idEstadoRut = idEstadoRut;
    }

    public List<ClienteUsuario> getClienteUsuarioList() {
        return clienteUsuarioList;
    }

    public void setClienteUsuarioList(List<ClienteUsuario> clienteUsuarioList) {
        this.clienteUsuarioList = clienteUsuarioList;
    }
}
