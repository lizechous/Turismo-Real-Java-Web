package com.duoc.turismo.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TOUR")
@PrimaryKeyJoinColumn(name = "id_servicio_extra_FK")
public class Tour extends ServicioExtra{
    @Column(name = "cantidad_personas_max", nullable = false)
    private Integer cantidadPersonasMax;

    @Column(name = "titulo_tour", nullable = false, length = 45)
    private String tituloTour;

    @Column(name = "descripcion_tour", nullable = false, length = 500)
    private String descripcionTour;

    public Integer getCantidadPersonasMax() {
        return cantidadPersonasMax;
    }

    public void setCantidadPersonasMax(Integer cantidadPersonasMax) {
        this.cantidadPersonasMax = cantidadPersonasMax;
    }

    public String getTituloTour() {
        return tituloTour;
    }

    public void setTituloTour(String tituloTour) {
        this.tituloTour = tituloTour;
    }

    public String getDescripcionTour() {
        return descripcionTour;
    }

    public void setDescripcionTour(String descripcionTour) {
        this.descripcionTour = descripcionTour;
    }
}
