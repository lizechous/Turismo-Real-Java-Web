package com.duoc.turismo.repository.model;

import com.duoc.turismo.controller.model.AccionEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.SQLException;

@Entity
@Table(name = "FOTO_TOUR")
public class FotoTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto_tour")
    private Integer idFotoTour;

    @Column(name = "titulo_foto_tour", nullable = false, length = 45)
    private String tituloFotoTour;

    @JsonIgnore
    @Column(name = "foto_tour", nullable = false)
    @Lob
    private Blob fotoTour;

    @Transient
    private AccionEnum accion;

    @Transient
    private byte[] fotoTourByte;

    @Transient
    private String fotoTourString;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_servicio_extra")
    private ServicioExtra servicioExtra;

    public Integer getIdFotoTour() {
        return idFotoTour;
    }

    public void setIdFotoTour(Integer idFotoTour) {
        this.idFotoTour = idFotoTour;
    }

    public String getTituloFotoTour() {
        return tituloFotoTour;
    }

    public void setTituloFotoTour(String tituloFotoTour) {
        this.tituloFotoTour = tituloFotoTour;
    }

    public Blob getFotoTour() {
        return fotoTour;
    }

    public void setFotoTour(Blob fotoTour) {
        this.fotoTour = fotoTour;
    }

    public ServicioExtra getServicioExtra() {
        return servicioExtra;
    }

    public void setServicioExtra(ServicioExtra servicioExtra) {
        this.servicioExtra = servicioExtra;
    }

    public byte[] getFotoTourByte() {
        if(fotoTour != null){
            try {
                return this.fotoTour.getBytes(1, (int)fotoTour.length());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return fotoTourByte;
    }

    public void setFotoTourByte(byte[] fotoTourByte) {
        this.fotoTourByte = fotoTourByte;
    }

    public String getFotoTourString() {
        return fotoTourString;
    }

    public void setFotoTourString(String fotoTourString) {
        this.fotoTourString = fotoTourString;
    }

    public AccionEnum getAccion() {
        return accion;
    }

    public void setAccion(AccionEnum accion) {
        this.accion = accion;
    }
}
