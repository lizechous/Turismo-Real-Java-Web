package com.duoc.turismo.repository.model;

import com.duoc.turismo.controller.model.AccionEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.SQLException;

@Entity
@Table(name = "FOTO_MANTENCION")
public class FotoMantencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto_mantencion", nullable = false)
    private Integer idFotoMatencion;

    @Column(name = "titulo_foto", nullable = true, length = 50)
    private String tituloFoto;

    @JsonIgnore
    @Column(name = "foto_mantencion", nullable = true)
    @Lob
    private Blob fotoMantencion;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_mantencion_FK")
    private Mantencion mantencion;

    @Transient
    private AccionEnum accion;

    @Transient
    private byte[] fotoMantencionByte;

    @Transient
    private String fotoMantencionString;

    public void setMantencion(Mantencion mantencion) {
        this.mantencion = mantencion;
    }

    public AccionEnum getAccion() {
        return accion;
    }

    public void setAccion(AccionEnum accion) {
        this.accion = accion;
    }

    public byte[] getFotoMantencionByte() {
        if(fotoMantencion != null){
            try {
                return this.fotoMantencion.getBytes(1, (int)fotoMantencion.length());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return fotoMantencionByte;
    }

    public void setFotoMantencionByte(byte[] fotoMantencionByte) {
        this.fotoMantencionByte = fotoMantencionByte;
    }

    public String getFotoMantencionString() {
        return fotoMantencionString;
    }

    public void setFotoMantencionString(String fotoMantencionString) {
        this.fotoMantencionString = fotoMantencionString;
    }

    public Integer getIdFotoMatencion() {
        return idFotoMatencion;
    }

    public String getTituloFoto() {
        return tituloFoto;
    }

    public void setTituloFoto(String tituloFoto) {
        this.tituloFoto = tituloFoto;
    }

    public Blob getFotoMantencion() {
        return fotoMantencion;
    }

    public void setFotoMantencion(Blob fotoMantencion) {
        this.fotoMantencion = fotoMantencion;
    }

    public Mantencion getMantencion() {
        return mantencion;
    }

}
