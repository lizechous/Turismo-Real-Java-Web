package com.duoc.turismo.repository.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TOUR")
@PrimaryKeyJoinColumn(name = "id_servicio_extra_FK")
public class Tour extends ServicioExtra implements Serializable, Cloneable {
    @Column(name = "cantidad_personas_max", nullable = false)
    private Integer cantidadPersonasMax;

    @Column(name = "titulo_tour", nullable = false, length = 45)
    private String tituloTour;

    @Column(name = "descripcion_tour", nullable = false, length = 500)
    private String descripcionTour;

    @Column(name = "valor_tour", nullable = false, length = 45)
    private Integer valorTour;

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

    public Integer getValorTour() {
        return valorTour;
    }

    public void setValorTour(Integer valorTour) {
        this.valorTour = valorTour;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
