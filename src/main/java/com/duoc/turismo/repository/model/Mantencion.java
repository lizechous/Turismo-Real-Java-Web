package com.duoc.turismo.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "MANTENCION")
public class Mantencion{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mantencion", nullable = false)
    private Integer idMantencion;

    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Column(name = "fecha_termino", nullable = false)
    private Date fechaTermino;

    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;

    @Column(name = "descripcion", nullable = false, length = 300)
    private String descripcion;

    @Column(name = "presupuesto", nullable = false)
    private Integer presupuesto;

    @Column(name = "estado", nullable = false)
    private String estado;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_departamento_FK")
    private Departamento departamento;

    @Transient
    private Integer idDepartamento;

    @OneToMany(mappedBy = "mantencion", cascade = CascadeType.ALL)
    private List<FotoMantencion> fotoMantencionList;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public List<FotoMantencion> getFotoMantencionList() {
        return fotoMantencionList;
    }

    public void setFotoMantencionList(List<FotoMantencion> fotoMantencionList) {
        this.fotoMantencionList = fotoMantencionList;
    }

    public Integer getIdMantencion() {
        return idMantencion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Integer presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

}
