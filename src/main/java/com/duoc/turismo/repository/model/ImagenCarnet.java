package com.duoc.turismo.repository.model;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "IMAGEN_CARNET")
public class ImagenCarnet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagen_carnet", nullable = false)
    private Integer idImagenCarnet;

    @Column(name = "titulo_foto_carnet", nullable = false, length = 15)
    private String tituloFotoCarnet;

    @Column(name = "foto_carnet", nullable = false)
    @Lob
    private Blob fotoCarnet;

    @ManyToOne
    @JoinColumn(name = "id_cliente_FK")
    private ClienteUsuario clienteUsuario;

    public Integer getIdImagenCarnet() {
        return idImagenCarnet;
    }

    public String getTituloFotoCarnet() {
        return tituloFotoCarnet;
    }

    public void setTituloFotoCarnet(String tituloFotoCarnet) {
        this.tituloFotoCarnet = tituloFotoCarnet;
    }

    public Blob getFotoCarnet() {
        return fotoCarnet;
    }

    public void setFotoCarnet(Blob fotoCarnet) {
        this.fotoCarnet = fotoCarnet;
    }

    public void setIdImagenCarnet(Integer idImagenCarnet) {
        this.idImagenCarnet = idImagenCarnet;
    }

    public ClienteUsuario getClienteUsuario() {
        return clienteUsuario;
    }

    public void setClienteUsuario(ClienteUsuario clienteUsuario) {
        this.clienteUsuario = clienteUsuario;
    }


}
