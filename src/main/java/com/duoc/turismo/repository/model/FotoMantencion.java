package com.duoc.turismo.repository.model;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "FOTO_MANTENCION")
public class FotoMantencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto_mantencion", nullable = false)
    private Integer idFotoMatencion;

    @Column(name = "titulo_foto", nullable = true, length = 50)
    private String tituloFoto;

    @Column(name = "foto_mantencion", nullable = true)
    @Lob
    private Blob fotoMantencion;

    @ManyToOne
    @JoinColumn(name = "id_mantencion_FK")
    private Mantencion mantencion;

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
