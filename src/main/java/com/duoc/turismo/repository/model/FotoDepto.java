package com.duoc.turismo.repository.model;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "FOTO_DEPTO")
public class FotoDepto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto_depto")
    private Integer idFotoDepto;

    @Column(name = "titulo_foto_depto", nullable = false, length = 45)
    private String tituloFotoDepto;

    @Column(name = "foto_depto", nullable = false)
    @Lob
    private Blob fotoDepto;

    @ManyToOne
    @JoinColumn(name = "id_departamento_FK")
    private Departamento departamento;

    public Integer getIdFotoDepto() {
        return idFotoDepto;
    }

    public void setIdFotoDepto(Integer idFotoDepto) {
        this.idFotoDepto = idFotoDepto;
    }

    public String getTituloFotoDepto() {
        return tituloFotoDepto;
    }

    public void setTituloFotoDepto(String tituloFotoDepto) {
        this.tituloFotoDepto = tituloFotoDepto;
    }

    public Blob getFotoDepto() {
        return fotoDepto;
    }

    public void setFotoDepto(Blob fotoDepto) {
        this.fotoDepto = fotoDepto;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
