package com.duoc.turismo.controller.model;

public class FotoDeptoRequest {

    private Integer idFoto;

    private String tituloFotoDepto;

    private String fotoDepto;

    private AccionEnum accionFoto;

    public Integer getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Integer idFoto) {
        this.idFoto = idFoto;
    }

    public String getTituloFotoDepto() {
        return tituloFotoDepto;
    }

    public void setTituloFotoDepto(String tituloFotoDepto) {
        this.tituloFotoDepto = tituloFotoDepto;
    }

    public String getFotoDepto() {
        return fotoDepto;
    }

    public void setFotoDepto(String fotoDepto) {
        this.fotoDepto = fotoDepto;
    }

    public AccionEnum getAccionFoto() {
        return accionFoto;
    }

    public void setAccionFoto(AccionEnum accionFoto) {
        this.accionFoto = accionFoto;
    }
}
