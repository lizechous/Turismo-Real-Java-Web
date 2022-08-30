package com.duoc.turismo.repository.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="GASTO_DEPARTAMENTO")
public class GastoDepartamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gasto_departamento", nullable = false)
    private Integer idGastoDepartamento;

    @Column(name = "tipo_gasto", nullable = false, length = 45)
    private String tipoGasto;

    @Column(name = "monto", nullable = false)
    private Integer monto;

    @Column(name = "fecha_gasto", nullable = false)
    private Date fechaGasto;

    @ManyToOne
    @JoinColumn(name = "id_departamento_FK")
    private Departamento departamento;

    public Integer getIdGastoDepartamento() {
        return idGastoDepartamento;
    }

    public String getTipoGasto() {
        return tipoGasto;
    }

    public void setTipoGasto(String tipoGasto) {
        this.tipoGasto = tipoGasto;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Date getFechaGasto() {
        return fechaGasto;
    }

    public void setFechaGasto(Date fechaGasto) {
        this.fechaGasto = fechaGasto;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
